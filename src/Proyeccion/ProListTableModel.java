package Proyeccion;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import javax.sql.*;
import javax.sql.rowset.*;
import com.sun.rowset.CachedRowSetImpl;

public class ProListTableModel extends AbstractTableModel {
	String url="jdbc:mysql://localhost:3306/";
	String dbname="toadv2";
	String regla="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String username="root";
	String pass="";
    CachedRowSet ProListRowSet; // Contains data
    ResultSetMetaData metadata; // Additional info about the data
    Connection connection;
    Statement statement;
    int numcols, numrows; // Number of rows and columns

    // Constructor used to connect to the database
    public ProListTableModel() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception e) {
            System.err.println("Unable to find and load driver");
            System.exit(1);
        }
        
        try {
            
            connection = DriverManager.getConnection(url+dbname+regla,username,pass);
        } catch (SQLException sqlerr) {
            System.out.println(sqlerr.getMessage());
            System.out.println(sqlerr.getSQLState());
            System.out.println(sqlerr.getErrorCode());
        }
        
        System.out.println("Connected Successfully");
        
        try {
            connection.setAutoCommit(false);
            ProListRowSet = new CachedRowSetImpl();
            ProListRowSet.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
            ProListRowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);
            ProListRowSet.setCommand("SELECT * FROM proyeccion");
            ProListRowSet.execute(connection);
            
            metadata = ProListRowSet.getMetaData();
            numcols = metadata.getColumnCount();
            numrows = ProListRowSet.size();
            ProListRowSet.first();
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
    }

    // Constructor that uses a RowSet and a database connection
    public ProListTableModel(RowSet rowSet, Connection conn) {
        try {
            ProListRowSet = (CachedRowSet) rowSet;
            ProListRowSet.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
            ProListRowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);
            metadata = ProListRowSet.getMetaData();
            numcols = metadata.getColumnCount();
            numrows = ProListRowSet.size();
            connection = conn;
        } catch(SQLException exp) {
            exp.printStackTrace();
        }
    }

    // Gets the total number of rows
    public int getRowCount() {
        return numrows;
    }

    // Gets the total number of columns
    public int getColumnCount() {
        return numcols;
    }

    // Gets the value of an object at a given row and column
    public Object getValueAt(int row, int col) {
        try {
            if (row >= ProListRowSet.size())
                //Error: Trying to access a deleted row
                return null;

            ProListRowSet.absolute(row + 1);
            Object obj = ProListRowSet.getObject(col + 1);
            if (obj == null)
                return null;
            else
                return obj.toString();
        } catch (SQLException err) {
            err.printStackTrace();
            return err.toString();
        }
    }

    // Returns false because cells are not editable
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    // Returns the name of a column
    public String getColumnName(int col) {
        try {
            return metadata.getColumnLabel(col + 1);
        } catch (SQLException err) {
            return err.toString();
        }
    }

    // Sets the value of an object at a given row and column
    public void setValueAt(Object aValue, int row, int col) {
        try {
            ProListRowSet.moveToInsertRow();
            System.out.println(aValue + " setValueAt " + (row+1) + " " + (col+1));
            ProListRowSet.updateObject(col+1, (String) aValue);
        } catch (SQLException err) {
            err.getMessage();
            err.printStackTrace();
        }
    }

    // Checks if the inserted or updated record has the same primary key as a record already in the database.
    // Returns true if there is no record with the same primary key; otherwise, return false and display a message
    public boolean isPrimaryKeyInDB(Object[] array) {
        try {

            if (getRowCount() == 0)
                // Database is empty, so the desired primary key does not exist
                return false;

            ProListRowSet.beforeFirst();
            while (ProListRowSet.next()) {
                if (ProListRowSet.getString("ProCod").equals(array[0]))
                    // Desired primary key is in the database
                    return true;
            }

            // Desired primary key is not in the database
            return false;
        } catch(SQLException err) {
            err.getMessage();
            err.printStackTrace();
            return false;
        }
    }

    // Adds a row to the database
    public void addRow(Object[] array) {
        try {

            

            // Insert the row if the desired primary key is not already in use
            if (!isPrimaryKeyInDB(array)) {
                ProListRowSet.last();
                ProListRowSet.moveToInsertRow();
                ProListRowSet.updateString("ProCod", (String) array[0]);
                ProListRowSet.updateString("ProFecEstAño", (String) array[1]);
                ProListRowSet.updateString("ProFecEstMes", (String) array[2]);
                ProListRowSet.updateString("ProFecEstDia", (String) array[3]);
                ProListRowSet.updateString("ProDiaEst", (String) array[4]);
                ProListRowSet.updateString("ProEsp", (String) array[5]);
                ProListRowSet.updateString("ProRec", (String) array[6]);
                ProListRowSet.updateString("ProCinCod", (String) array[7]);
                ProListRowSet.updateString("ProSalCod", (String) array[8]);
                ProListRowSet.updateString("ProPelCod", (String) array[9]);
                ProListRowSet.updateString("PelNacCod", (String) array[10]);
                ProListRowSet.updateString("ProEstReg", (String) array[11]);

                ProListRowSet.insertRow();
                ProListRowSet.moveToCurrentRow();
                ProListRowSet.acceptChanges(connection);
            } else {
                // Error: User's desired primary key is already in the database
                JOptionPane.showMessageDialog(null,
                        "Cannot have multiple records with the same primary key (ProCod).",
                        "Primary Key Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch(SQLException err) {
            err.getMessage();
            err.printStackTrace();
        }
    }

    // Deletes a row from the database
    public void deleteRow(Object[] array) {
        try {
            ProListRowSet.beforeFirst();
            while (ProListRowSet.next()) {
                if (ProListRowSet.getString("ProCod").equals(array[0])) {
                	ProListRowSet.updateString("ProEstReg", "*");
                    
                    ProListRowSet.updateRow();
                    ProListRowSet.first();
                    break;
                }
            }
            ProListRowSet.acceptChanges(connection);
        } catch(SQLException err) {
            err.getMessage();
            err.printStackTrace();
        }
    }

    // Updates a row in the database
    // array: Grabs what is in the text field
    // getString(): Grabs where the cursor is
    public void updateRow(Object[] array, JTable jtable) {
        try {
            if (jtable.getSelectedRow() == -1)
                // Error: No row is selected for updating. This error is quietly handled.
                return;

            

            // Move to the selected row
            ProListRowSet.absolute(jtable.getSelectedRow() + 1);

            // Current Pro number in the selected row
            String selectedProNumber = ProListRowSet.getString("ProCod");

            // Pro number entered into the text field
            String desiredProNumber = (String) array[0];

            // Update the row if the desired primary key is not in the database, or the desired primary key is in the
            // database, but the row's primary key is not being updated
            if (!isPrimaryKeyInDB(array) || desiredProNumber.equals(selectedProNumber)) {
                ProListRowSet.absolute(jtable.getSelectedRow() + 1);
                ProListRowSet.updateString("ProCod", (String) array[0]);
                ProListRowSet.updateString("ProFecEstAño", (String) array[1]);
                ProListRowSet.updateString("ProFecEstMes", (String) array[2]);
                ProListRowSet.updateString("ProFecEstDia", (String) array[3]);
                ProListRowSet.updateString("ProDiaEst", (String) array[4]);
                ProListRowSet.updateString("ProEsp", (String) array[5]);
                ProListRowSet.updateString("ProRec", (String) array[6]);
                ProListRowSet.updateString("ProCinCod", (String) array[7]);
                ProListRowSet.updateString("ProSalCod", (String) array[8]);
                ProListRowSet.updateString("ProPelCod", (String) array[9]);
                ProListRowSet.updateString("PelNacCod", (String) array[10]);
                ProListRowSet.updateString("ProEstReg", (String) array[11]);

                ProListRowSet.updateRow();
                ProListRowSet.first();
                ProListRowSet.acceptChanges(connection);
                return;
            }

            // Error: User is trying to change the primary key to a new primary key already in the database
            JOptionPane.showMessageDialog(null,
                    "Cannot have multiple records with the same primary key (ProCod).",
                    "Primary Key Error", JOptionPane.ERROR_MESSAGE);

        } catch(SQLException err) {
            err.getMessage();
            err.printStackTrace();
        }
    }
    
    // Activate a row from the database
    public void activateRow(Object[] array) {
        try {
            ProListRowSet.beforeFirst();
            while (ProListRowSet.next()) {
                if (ProListRowSet.getString("ProCod").equals(array[0])) {
                	ProListRowSet.updateString("ProEstReg", "A");
                    
                    ProListRowSet.updateRow();
                    ProListRowSet.first();
                    break;
                }
            }
            ProListRowSet.acceptChanges(connection);
        } catch(SQLException err) {
            err.getMessage();
            err.printStackTrace();
        }
    }
    
    // inactivate a row from the database
    public void inactivateRow(Object[] array) {
        try {
            ProListRowSet.beforeFirst();
            while (ProListRowSet.next()) {
                if (ProListRowSet.getString("ProCod").equals(array[0])) {
                	ProListRowSet.updateString("ProEstReg", "I");
                    
                    ProListRowSet.updateRow();
                    ProListRowSet.first();
                    break;
                }
            }
            ProListRowSet.acceptChanges(connection);
        } catch(SQLException err) {
            err.getMessage();
            err.printStackTrace();
        }
    }
    
    // Returns the current CachedRowSet in the TableModel
    public CachedRowSet getRowSet() {
        return ProListRowSet;
    }
    
    // Helps preserve the old connection for the new TableModel
    public Connection getConnection() {
        return connection;
    }

    // Checks if the enrollment field is an integer
   
    
    public static void main(String[] args) {
        // TODO code application logic here
        ProListGUI ProListGUI = new ProListGUI();
        ProListGUI.setVisible(true);
    }
    
}