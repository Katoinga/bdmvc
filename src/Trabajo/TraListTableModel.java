package Trabajo;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import javax.sql.*;
import javax.sql.rowset.*;
import com.sun.rowset.CachedRowSetImpl;

public class TraListTableModel extends AbstractTableModel {
	String url="jdbc:mysql://localhost:3306/";
	String dbname="toadv2";
	String regla="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String username="root";
	String pass="";
    CachedRowSet TraListRowSet; // Contains data
    ResultSetMetaData metadata; // Additional info about the data
    Connection connection;
    Statement statement;
    int numcols, numrows; // Number of rows and columns

    // Constructor used to connect to the database
    public TraListTableModel() {
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
            TraListRowSet = new CachedRowSetImpl();
            TraListRowSet.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
            TraListRowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);
            TraListRowSet.setCommand("SELECT * FROM trabajo");
            TraListRowSet.execute(connection);
            
            metadata = TraListRowSet.getMetaData();
            numcols = metadata.getColumnCount();
            numrows = TraListRowSet.size();
            TraListRowSet.first();
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
    }

    // Constructor that uses a RowSet and a database connection
    public TraListTableModel(RowSet rowSet, Connection conn) {
        try {
            TraListRowSet = (CachedRowSet) rowSet;
            TraListRowSet.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
            TraListRowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);
            metadata = TraListRowSet.getMetaData();
            numcols = metadata.getColumnCount();
            numrows = TraListRowSet.size();
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
            if (row >= TraListRowSet.size())
                //Error: Trying to access a deleted row
                return null;

            TraListRowSet.absolute(row + 1);
            Object obj = TraListRowSet.getObject(col + 1);
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
            TraListRowSet.moveToInsertRow();
            System.out.println(aValue + " setValueAt " + (row+1) + " " + (col+1));
            TraListRowSet.updateObject(col+1, (String) aValue);
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

            TraListRowSet.beforeFirst();
            while (TraListRowSet.next()) {
                if (TraListRowSet.getString("TraCod").equals(array[0]))
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
                TraListRowSet.last();
                TraListRowSet.moveToInsertRow();
                TraListRowSet.updateString("TraCod", (String) array[0]);
                TraListRowSet.updateString("TraTarCod", (String) array[1]);
                TraListRowSet.updateString("TraPerCod", (String) array[2]);
                TraListRowSet.updateString("TraPelCod", (String) array[3]);
                TraListRowSet.updateString("PerNacCod", (String) array[4]);
                TraListRowSet.updateString("PelNacCod", (String) array[5]);
                TraListRowSet.updateString("SexCod", (String) array[6]);
                TraListRowSet.updateString("TraEstReg", (String) array[7]);

                TraListRowSet.insertRow();
                TraListRowSet.moveToCurrentRow();
                TraListRowSet.acceptChanges(connection);
            } else {
                // Error: User's desired primary key is already in the database
                JOptionPane.showMessageDialog(null,
                        "Cannot have multiple records with the same primary key (TraCod).",
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
            TraListRowSet.beforeFirst();
            while (TraListRowSet.next()) {
                if (TraListRowSet.getString("TraCod").equals(array[0])) {
                	TraListRowSet.updateString("TraEstReg", "*");
                    
                    TraListRowSet.updateRow();
                    TraListRowSet.first();
                    break;
                }
            }
            TraListRowSet.acceptChanges(connection);
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
            TraListRowSet.absolute(jtable.getSelectedRow() + 1);

            // Current Tra number in the selected row
            String selectedTraNumber = TraListRowSet.getString("TraCod");

            // Tra number entered into the text field
            String desiredTraNumber = (String) array[0];

            // Update the row if the desired primary key is not in the database, or the desired primary key is in the
            // database, but the row's primary key is not being updated
            if (!isPrimaryKeyInDB(array) || desiredTraNumber.equals(selectedTraNumber)) {
                TraListRowSet.absolute(jtable.getSelectedRow() + 1);
                TraListRowSet.updateString("TraCod", (String) array[0]);
                TraListRowSet.updateString("TraTarCod", (String) array[1]);
                TraListRowSet.updateString("TraPerCod", (String) array[2]);
                TraListRowSet.updateString("TraPelCod", (String) array[3]);
                TraListRowSet.updateString("PerNacCod", (String) array[4]);
                TraListRowSet.updateString("PelNacCod", (String) array[5]);
                TraListRowSet.updateString("SexCod", (String) array[6]);
                TraListRowSet.updateString("TraEstReg", (String) array[7]);
                TraListRowSet.updateRow();
                TraListRowSet.first();
                TraListRowSet.acceptChanges(connection);
                return;
            }

            // Error: User is trying to change the primary key to a new primary key already in the database
            JOptionPane.showMessageDialog(null,
                    "Cannot have multiple records with the same primary key (TraCod).",
                    "Primary Key Error", JOptionPane.ERROR_MESSAGE);

        } catch(SQLException err) {
            err.getMessage();
            err.printStackTrace();
        }
    }
    
    // Activate a row from the database
    public void activateRow(Object[] array) {
        try {
            TraListRowSet.beforeFirst();
            while (TraListRowSet.next()) {
                if (TraListRowSet.getString("TraCod").equals(array[0])) {
                	TraListRowSet.updateString("TraEstReg", "A");
                    
                    TraListRowSet.updateRow();
                    TraListRowSet.first();
                    break;
                }
            }
            TraListRowSet.acceptChanges(connection);
        } catch(SQLException err) {
            err.getMessage();
            err.printStackTrace();
        }
    }
    
    // inactivate a row from the database
    public void inactivateRow(Object[] array) {
        try {
            TraListRowSet.beforeFirst();
            while (TraListRowSet.next()) {
                if (TraListRowSet.getString("TraCod").equals(array[0])) {
                	TraListRowSet.updateString("TraEstReg", "I");
                    
                    TraListRowSet.updateRow();
                    TraListRowSet.first();
                    break;
                }
            }
            TraListRowSet.acceptChanges(connection);
        } catch(SQLException err) {
            err.getMessage();
            err.printStackTrace();
        }
    }
    
    // Returns the current CachedRowSet in the TableModel
    public CachedRowSet getRowSet() {
        return TraListRowSet;
    }
    
    // Helps Traserve the old connection for the new TableModel
    public Connection getConnection() {
        return connection;
    }

    // Checks if the enrollment field is an integer
   
    
    public static void main(String[] args) {
        // TODO code application logic here
        TraListGUI TraListGUI = new TraListGUI();
        TraListGUI.setVisible(true);
    }
    
}