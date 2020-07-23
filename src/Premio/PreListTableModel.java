package Premio;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import javax.sql.*;
import javax.sql.rowset.*;
import com.sun.rowset.CachedRowSetImpl;

public class PreListTableModel extends AbstractTableModel {
	String url="jdbc:mysql://localhost:3306/";
	String dbname="toadv2";
	String regla="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String username="root";
	String pass="";
    CachedRowSet PreListRowSet; // Contains data
    ResultSetMetaData metadata; // Additional info about the data
    Connection connection;
    Statement statement;
    int numcols, numrows; // Number of rows and columns

    // Constructor used to connect to the database
    public PreListTableModel() {
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
            PreListRowSet = new CachedRowSetImpl();
            PreListRowSet.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
            PreListRowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);
            PreListRowSet.setCommand("SELECT * FROM premio");
            PreListRowSet.execute(connection);
            
            metadata = PreListRowSet.getMetaData();
            numcols = metadata.getColumnCount();
            numrows = PreListRowSet.size();
            PreListRowSet.first();
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
    }

    // Constructor that uses a RowSet and a database connection
    public PreListTableModel(RowSet rowSet, Connection conn) {
        try {
            PreListRowSet = (CachedRowSet) rowSet;
            PreListRowSet.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
            PreListRowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);
            metadata = PreListRowSet.getMetaData();
            numcols = metadata.getColumnCount();
            numrows = PreListRowSet.size();
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
            if (row >= PreListRowSet.size())
                //Error: Trying to access a deleted row
                return null;

            PreListRowSet.absolute(row + 1);
            Object obj = PreListRowSet.getObject(col + 1);
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
            PreListRowSet.moveToInsertRow();
            System.out.println(aValue + " setValueAt " + (row+1) + " " + (col+1));
            PreListRowSet.updateObject(col+1, (String) aValue);
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

            PreListRowSet.beforeFirst();
            while (PreListRowSet.next()) {
                if (PreListRowSet.getString("PreCod").equals(array[1]))
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
                PreListRowSet.last();
                PreListRowSet.moveToInsertRow();
                PreListRowSet.updateString("PreNom", (String) array[0]);
                PreListRowSet.updateString("PreCod", (String) array[1]);
                PreListRowSet.updateString("PreTarCod", (String) array[2]);
                PreListRowSet.updateString("PreEstReg", (String) array[3]);

                PreListRowSet.insertRow();
                PreListRowSet.moveToCurrentRow();
                PreListRowSet.acceptChanges(connection);
            } else {
                // Error: User's desired primary key is already in the database
                JOptionPane.showMessageDialog(null,
                        "Cannot have multiple records with the same primary key (PreCod).",
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
            PreListRowSet.beforeFirst();
            while (PreListRowSet.next()) {
                if (PreListRowSet.getString("PreCod").equals(array[1])) {
                	PreListRowSet.updateString("PreEstReg", "*");
                    
                    PreListRowSet.updateRow();
                    PreListRowSet.first();
                    break;
                }
            }
            PreListRowSet.acceptChanges(connection);
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
            PreListRowSet.absolute(jtable.getSelectedRow() + 1);

            // Current Pre number in the selected row
            String selectedPreNumber = PreListRowSet.getString("PreCod");

            // Pre number entered into the text field
            String desiredPreNumber = (String) array[1];

            // Update the row if the desired primary key is not in the database, or the desired primary key is in the
            // database, but the row's primary key is not being updated
            if (!isPrimaryKeyInDB(array) || desiredPreNumber.equals(selectedPreNumber)) {
                PreListRowSet.absolute(jtable.getSelectedRow() + 1);
                PreListRowSet.updateString("PreNom", (String) array[0]);
                PreListRowSet.updateString("PreCod", (String) array[1]);
                PreListRowSet.updateString("PreTarCod", (String) array[2]);
                PreListRowSet.updateString("PreEstReg", (String) array[3]);
                PreListRowSet.updateRow();
                PreListRowSet.first();
                PreListRowSet.acceptChanges(connection);
                return;
            }

            // Error: User is trying to change the primary key to a new primary key already in the database
            JOptionPane.showMessageDialog(null,
                    "Cannot have multiple records with the same primary key (PreCod).",
                    "Primary Key Error", JOptionPane.ERROR_MESSAGE);

        } catch(SQLException err) {
            err.getMessage();
            err.printStackTrace();
        }
    }
    
    // Activate a row from the database
    public void activateRow(Object[] array) {
        try {
            PreListRowSet.beforeFirst();
            while (PreListRowSet.next()) {
                if (PreListRowSet.getString("PreCod").equals(array[1])) {
                	PreListRowSet.updateString("PreEstReg", "A");
                    
                    PreListRowSet.updateRow();
                    PreListRowSet.first();
                    break;
                }
            }
            PreListRowSet.acceptChanges(connection);
        } catch(SQLException err) {
            err.getMessage();
            err.printStackTrace();
        }
    }
    
    // inactivate a row from the database
    public void inactivateRow(Object[] array) {
        try {
            PreListRowSet.beforeFirst();
            while (PreListRowSet.next()) {
                if (PreListRowSet.getString("PreCod").equals(array[1])) {
                	PreListRowSet.updateString("PreEstReg", "I");
                    
                    PreListRowSet.updateRow();
                    PreListRowSet.first();
                    break;
                }
            }
            PreListRowSet.acceptChanges(connection);
        } catch(SQLException err) {
            err.getMessage();
            err.printStackTrace();
        }
    }
    
    // Returns the current CachedRowSet in the TableModel
    public CachedRowSet getRowSet() {
        return PreListRowSet;
    }
    
    // Helps preserve the old connection for the new TableModel
    public Connection getConnection() {
        return connection;
    }

    // Checks if the enrollment field is an integer
   
    
    public static void main(String[] args) {
        // TODO code application logic here
        PreListGUI PreListGUI = new PreListGUI();
        PreListGUI.setVisible(true);
    }
    
}