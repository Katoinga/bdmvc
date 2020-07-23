package nacionalidad;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import com.sun.rowset.CachedRowSetImpl;

public class NacListTableModel extends AbstractTableModel {
	String url="jdbc:mysql://localhost:3306/";
	String dbname="toadv2";
	String regla="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String username="root";
	String pass="";
    CachedRowSet NacListRowSet; // Contains data
    ResultSetMetaData metadata; // Additional info about the data
    Connection connection;
    Statement statement;
    int numcols, numrows; // Number of rows and columns

    // Constructor used to connect to the database
    public NacListTableModel() {
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
            NacListRowSet = new CachedRowSetImpl();
            NacListRowSet.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
            NacListRowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);
            NacListRowSet.setCommand("SELECT * FROM nacionalidad");
            NacListRowSet.execute(connection);
            
            metadata = NacListRowSet.getMetaData();
            numcols = metadata.getColumnCount();
            numrows = NacListRowSet.size();
            NacListRowSet.first();
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
    }

    // Constructor that uses a RowSet and a database connection
    public NacListTableModel(RowSet rowSet, Connection conn) {
        try {
            NacListRowSet = (CachedRowSet) rowSet;
            NacListRowSet.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
            NacListRowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);
            metadata = NacListRowSet.getMetaData();
            numcols = metadata.getColumnCount();
            numrows = NacListRowSet.size();
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
            if (row >= NacListRowSet.size())
                //Error: Trying to access a deleted row
                return null;

            NacListRowSet.absolute(row + 1);
            Object obj = NacListRowSet.getObject(col + 1);
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
            NacListRowSet.moveToInsertRow();
            System.out.println(aValue + " setValueAt " + (row+1) + " " + (col+1));
            NacListRowSet.updateObject(col+1, (String) aValue);
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

            NacListRowSet.beforeFirst();
            while (NacListRowSet.next()) {
                if (NacListRowSet.getString("NacCod").equals(array[1]))
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
                NacListRowSet.last();
                NacListRowSet.moveToInsertRow();
                NacListRowSet.updateString("NacDes", (String) array[0]);
                NacListRowSet.updateString("NacCod", (String) array[1]);
                NacListRowSet.updateString("NacEstReg", (String) array[2]);
                
                NacListRowSet.insertRow();
                NacListRowSet.moveToCurrentRow();
                NacListRowSet.acceptChanges(connection);
            } else {
                // Error: User's desired primary key is already in the database
                JOptionPane.showMessageDialog(null,
                        "Cannot have multiple records with the same primary key (NacCod).",
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
            NacListRowSet.beforeFirst();
            while (NacListRowSet.next()) {
                if (NacListRowSet.getString("NacCod").equals(array[1])) {
                	NacListRowSet.updateString("NacEstReg", "*");
                    
                    NacListRowSet.updateRow();
                    NacListRowSet.first();
                    break;
                }
            }
            NacListRowSet.acceptChanges(connection);
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
            NacListRowSet.absolute(jtable.getSelectedRow() + 1);

            // Current Nac number in the selected row
            String selectedNacNumber = NacListRowSet.getString("NacCod");

            // Nac number entered into the text field
            String desiredNacNumber = (String) array[1];

            // Update the row if the desired primary key is not in the database, or the desired primary key is in the
            // database, but the row's primary key is not being updated
            if (!isPrimaryKeyInDB(array) || desiredNacNumber.equals(selectedNacNumber)) {
                NacListRowSet.absolute(jtable.getSelectedRow() + 1);
                NacListRowSet.updateString("NacDes", (String) array[0]);
                NacListRowSet.updateString("NacCod", (String) array[1]);
                NacListRowSet.updateString("NacEstReg", (String) array[2]);
                
                NacListRowSet.updateRow();
                NacListRowSet.first();
                NacListRowSet.acceptChanges(connection);
                return;
            }

            // Error: User is trying to change the primary key to a new primary key already in the database
            JOptionPane.showMessageDialog(null,
                    "Cannot have multiple records with the same primary key (NacCod).",
                    "Primary Key Error", JOptionPane.ERROR_MESSAGE);

        } catch(SQLException err) {
            err.getMessage();
            err.printStackTrace();
        }
    }
    
    // Activate a row from the database
    public void activateRow(Object[] array) {
        try {
            NacListRowSet.beforeFirst();
            while (NacListRowSet.next()) {
                if (NacListRowSet.getString("NacCod").equals(array[1])) {
                	NacListRowSet.updateString("NacEstReg", "A");
                    
                    NacListRowSet.updateRow();
                    NacListRowSet.first();
                    break;
                }
            }
            NacListRowSet.acceptChanges(connection);
        } catch(SQLException err) {
            err.getMessage();
            err.printStackTrace();
        }
    }
    
    // Inactivate a row from the database
    public void inactivateRow(Object[] array) {
        try {
            NacListRowSet.beforeFirst();
            while (NacListRowSet.next()) {
                if (NacListRowSet.getString("NacCod").equals(array[1])) {
                	NacListRowSet.updateString("NacEstReg", "I");
                    
                    NacListRowSet.updateRow();
                    NacListRowSet.first();
                    break;
                }
            }
            NacListRowSet.acceptChanges(connection);
        } catch(SQLException err) {
            err.getMessage();
            err.printStackTrace();
        }
    }
    
    // Returns the current CachedRowSet in the TableModel
    public CachedRowSet getRowSet() {
        return NacListRowSet;
    }
    
    // Helps preserve the old connection for the new TableModel
    public Connection getConnection() {
        return connection;
    }

    // Checks if the enrollment field is an integer
   
    
    public static void main(String[] args) {
        // TODO code application logic here
        NacListGUI NacListGUI = new NacListGUI();
        NacListGUI.setVisible(true);
    }
    
}