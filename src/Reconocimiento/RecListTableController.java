package Reconocimiento;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;



public class RecListTableController implements ListSelectionListener, RowSetListener {
    
    private RecListTableModel tableModel = null;
    private RecListGUI gui;
    
    public RecListTableController(RecListGUI gui) {
        this.gui = gui;
        // Create the tableModel using the data in the cachedRowSet
        tableModel = new RecListTableModel();
        tableModel.getRowSet().addRowSetListener(this);
    }
    
    // Get the table model
    public TableModel getTableModel() {
        return tableModel;
    }

    // Method from the ListSelectionListener Interface
    // Called whenever the value of the selection changes.
    public void valueChanged(ListSelectionEvent e) {
        // Prevent action from being Recformed twice
        // https://stackoverflow.com/questions/5865343/why-does-jtable-always-trigger-listselectionlistener-twice
        if (!e.getValueIsAdjusting()) {

            ListSelectionModel selectModel = (ListSelectionModel) e.getSource();

            int firstIndex = selectModel.getMinSelectionIndex();

            // Selection is empty
            if (firstIndex == -1)
                return;

            // Read the data in each column using getValue and display it on corresponding text field
            
            gui.setRecNumberTextField((String) tableModel.getValueAt(firstIndex, 0));
            gui.setRecPerCodComboBox((String) tableModel.getValueAt(firstIndex, 1));
            gui.setRecCerCodComboBox((String) tableModel.getValueAt(firstIndex, 2));
            gui.setRecFesPreCodComboBox((String) tableModel.getValueAt(firstIndex, 3));           
            gui.setRecEstRegTextField((String) tableModel.getValueAt(firstIndex, 4));

        }
    }

    // Add a row to the database using addRow() in RecListTableModel
    public void addRow(String[] array) {
        tableModel.addRow(array);
    }

    // Delete a row to the database using deleteRow() in RecListTableModel
    public void deleteRow(String[] array) {
        tableModel.deleteRow(array);
    }

    // Update a row to the database using updateRow() in RecListTableModel
    public void updateRow(String[] array, JTable jtable) {
        tableModel.updateRow(array, jtable);
    }
    
    // Activate a row to the database using updateRow() in RecListTableModel
    public void activateRow(String[] array) {
        tableModel.activateRow(array);
    }
    
    // inactivate a row to the database using updateRow() in RecListTableModel
    public void inactivateRow(String[] array) {
        tableModel.inactivateRow(array);
    }

    // Method from the RowSetListener Interface
    // Notifies registered listeners that a RowSet object has had a change in one of its rows.
    public void rowChanged(RowSetEvent event) {
        try {
            // Get the index of the inserted row
            // getRowSet() is a method in RecListTableModel that returns a CachedRowSet object
            // getRow() is a method in ResultSet that returns the current row
            tableModel.getRowSet().moveToCurrentRow();
            int firstIndex = tableModel.getRowSet().getRow();

            // Create a new table model with the new data
            tableModel = new RecListTableModel(tableModel.getRowSet(), tableModel.getConnection());

            //update the JTable with the data
            gui.updateTable();

            // Read the data in each column using getValueAt and display it on the corresponding text field
            gui.setRecNumberTextField((String) tableModel.getValueAt(firstIndex, 0));
            gui.setRecPerCodComboBox((String) tableModel.getValueAt(firstIndex, 1));
            gui.setRecCerCodComboBox((String) tableModel.getValueAt(firstIndex, 2));
            gui.setRecFesPreCodComboBox((String) tableModel.getValueAt(firstIndex, 3));           
            gui.setRecEstRegTextField((String) tableModel.getValueAt(firstIndex, 4));
        } catch (Exception exp) {
            exp.getMessage();
            exp.printStackTrace();
        }
    }

    // Method from the RowSetListener Interface
    // Notifies registered listeners that a RowSet object's cursor has moved.
    public void cursorMoved(RowSetEvent event) { }

    // Method from the RowSetListener Interface
    // Notifies registered listeners that a RowSet object in the given RowSetEvent object has changed its entire contents.
    public void rowSetChanged(RowSetEvent event) { }
    
}
