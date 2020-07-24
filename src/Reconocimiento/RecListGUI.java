package Reconocimiento;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class RecListGUI extends javax.swing.JFrame {

    private JTable jtable1; // The table displayed on the GUI
    private RecListTableController recListTableController = null;

    public RecListGUI() {
        
        // This method creates the labels and text fields on the GUI
        initComponents();
        
        // Creates a controller for the table
        recListTableController = new RecListTableController(this);

        // Add a table JTable to the GUI
        addJTable();

    }
    
    public void addJTable() {
        // Add the data and column names to a JTable
        jtable1 = new JTable(recListTableController.getTableModel());
    
        // Add a ListSelectionListener to the table
        jtable1.getSelectionModel().addListSelectionListener(recListTableController);
        
        // Add the table to a scrollpane
        JScrollPane scrollpane = new JScrollPane(jtable1);
        
        // Create a window
        // This was originally jPanel
        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(scrollpane, BorderLayout.CENTER);

        // User can only select one row at a time
        jtable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Update the JTable
    public void updateTable() {
        jtable1.setModel(recListTableController.getTableModel());
    }

    // Set data on the RecNameTextField
    

    // Set data on the RecNumberTextField
    public void setRecNumberTextField(String value) { RecNumberTextField.setText(value); }
    
    public void setRecPerCodComboBox(String value) { 
    	int size = RecPerCodComboBox.getItemCount();
    	for(int c=0; c<size; c++) {
    		if(RecPerCodComboBox.getItemAt(c).toString().substring(0,RecPerCodComboBox.getItemAt(c).toString().indexOf(' ')).equals(value)) {
    			RecPerCodComboBox.setSelectedIndex(c);
    			break;
    		}
    	}
    }
    public void setRecCerCodComboBox(String value) {
    	int size = RecCerCodComboBox.getItemCount();
    	for(int c=0; c<size; c++) {
    		if(RecCerCodComboBox.getItemAt(c).toString().substring(0,RecCerCodComboBox.getItemAt(c).toString().indexOf(' ')).equals(value)) {
    			RecCerCodComboBox.setSelectedIndex(c);
    			break;
    		}
    	}
    }
    public void setRecFesPreCodComboBox(String value) {
    	int size = RecFesPreCodComboBox.getItemCount();
    	for(int c=0; c<size; c++) {
    		if(RecFesPreCodComboBox.getItemAt(c).toString().substring(0,RecFesPreCodComboBox.getItemAt(c).toString().indexOf(' ')).equals(value)) {
    			RecFesPreCodComboBox.setSelectedIndex(c);
    			break;
    		}
    	}
    }
    
    // Set data on the RecEstRegTextField
    
    public void setRecEstRegTextField(String value) { RecEstRegTextField.setText(value); }

    // Set data on the enrollmentTextField
    

    // Set data on the startDateTextField
    

    // Set data on the endDateTextField
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * reRecerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Recerated Code">//Rec-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        RecNumberLabel = new javax.swing.JLabel();
        RecEstRegLabel = new javax.swing.JLabel();
        RecPerCodLabel = new javax.swing.JLabel();
        RecPerCodComboBox = new javax.swing.JComboBox<String>();

        RecCerCodLabel = new javax.swing.JLabel();
        RecCerCodComboBox = new javax.swing.JComboBox<String>();
        RecFesPreCodLabel = new javax.swing.JLabel();
        RecFesPreCodComboBox = new javax.swing.JComboBox<String>();
        
        RecNumberTextField = new javax.swing.JTextField();
        RecEstRegTextField = new javax.swing.JTextField();
        modButton =new javax.swing.JButton();
        actButton = new javax.swing.JButton();
        inactButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        RecListLabel = new javax.swing.JLabel();
        remplir_Jcomb();
        // Recgram will terminate when the window is closed
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RecNumberLabel.setText("Codigo:");
        RecPerCodLabel.setText("Personaje(Codigo):");
        RecCerCodLabel.setText("Certamen(Codigo):");
        RecFesPreCodLabel.setText("Festival-Premio(Codigo):");
        
        RecEstRegLabel.setText("Estado del Registro:");
        
        

        // Details for the Add button
        addButton.setText("Adicionar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtoRectionRecformed(evt);
            }
        });

        // Details for the Delete button
        deleteButton.setText("Eliminar");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtoRectionRecformed(evt);
            }
        });
        modButton.setText("Modificar");
        modButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modButtoRectionRecformed(evt);
            }
        });
        actButton.setText("Activar..");
        actButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actButtoRectionRecformed(evt);
            }
        });
        inactButton.setText("Inactivar");
        inactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inactButtoRectionRecformed(evt);
            }
        });
        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtoRectionRecformed(evt);
            }
        });
        exitButton.setText("Salir");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtoRectionRecformed(evt);
            }
        });
        // Details for the Update button
        updateButton.setText("Actualizar");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtoRectionRecformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RecNumberLabel))
                .addGap(147, 147, 147)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RecNumberTextField))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(RecPerCodLabel)
                    .addGap(148, 148, 148)
                    .addComponent(RecPerCodComboBox)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(RecCerCodLabel)
                    .addGap(148, 148, 148)
                    .addComponent(RecCerCodComboBox)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(RecFesPreCodLabel)
                    .addGap(148, 148, 148)
                    .addComponent(RecFesPreCodComboBox)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(RecEstRegLabel)
                    .addGap(148, 148, 148)
                    .addComponent(RecEstRegTextField)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(deleteButton)
                .addGap(81, 81, 81)
                .addComponent(updateButton)
                .addGap(70, 70, 70))
            .addGroup(jPanel1Layout.createSequentialGroup()
            		.addGap(30, 30, 30)
                    .addComponent(modButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                    .addComponent(inactButton)
                    .addGap(81, 81, 81)
                    .addComponent(actButton)
                    .addGap(70, 70, 70))
            .addGroup(jPanel1Layout.createSequentialGroup()
            		.addGap(30, 30, 30)
                    .addComponent(cancelButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                    .addComponent(exitButton)
                    .addGap(81, 81, 81)
                    )
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            
            
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RecNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RecNumberLabel))
                .addGap(18, 18, 18)
                
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RecPerCodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(RecPerCodLabel))
                    .addGap(18, 18, 18)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RecCerCodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RecCerCodLabel))
                        .addGap(18, 18, 18) 
                  
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(RecFesPreCodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(RecFesPreCodLabel))
                            .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RecEstRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(RecEstRegLabel))
                    .addGap(18, 18, 18)
                    
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(deleteButton)
                    .addComponent(updateButton)
                    )
                .addGap(18, 18, 18)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                		 .addComponent(modButton)
                         .addComponent(inactButton)
                         .addComponent(actButton)
                 )
                 .addGap(18, 18, 18)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                		 .addComponent(cancelButton)
                         .addComponent(exitButton)
                 )
                .addGap(42, 42, 42)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        RecListLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        RecListLabel.setText("Reconocimiento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(RecListLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RecListLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//Rec-END:initComponents

    // Code for the add button
    private void addButtoRectionRecformed(java.awt.event.ActionEvent evt) {//Rec-FIRST:event_addButtoRectionRecformed
        // TODO add your handling code here:

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = RecNumberTextField.getText();
        array[1] = RecPerCodComboBox.getSelectedItem().toString().substring(0,RecPerCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[2] = RecCerCodComboBox.getSelectedItem().toString().substring(0,RecCerCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[3] = RecFesPreCodComboBox.getSelectedItem().toString().substring(0,RecFesPreCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[4] = returnQuery("personaje","PerCod","PerNacCod",array[1]);
        array[5] = returnQuery("festival_premio","FesPreCod","FesPreFesCod",array[3]);
        array[6] = returnQuery("festival_premio","FesPreCod","FesPrePreCod",array[3]);
        array[7] = returnQuery("festival_premio","FesPreCod","TarCod",array[3]);
        array[8] = returnQuery("certamen","CerCod","CerOrgCod",array[2]);
        array[9] = returnQuery("personaje","PerCod","PerSexCod",array[1]);
        array[10] = RecEstRegTextField.getText();
        
        // Send data to the controller to add it to the model
        recListTableController.addRow(array);
    }//Rec-LAST:event_addButtoRectionRecformed

    // Code for the delete button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // RecListTableController.java (LINE 65) and CouseListTableModel.java (LINE 149)
    private void deleteButtoRectionRecformed(java.awt.event.ActionEvent evt) {//Rec-FIRST:event_deleteButtoRectionRecformed
        // TODO add your handling code here:
        String[] array = new String[jtable1.getColumnCount()];
        array[0] = RecNumberTextField.getText();
        array[1] = RecPerCodComboBox.getSelectedItem().toString().substring(0,RecPerCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[2] = RecCerCodComboBox.getSelectedItem().toString().substring(0,RecCerCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[3] = RecFesPreCodComboBox.getSelectedItem().toString().substring(0,RecFesPreCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[4] = returnQuery("personaje","PerCod","PerNacCod",array[1]);
        array[5] = returnQuery("festival_premio","FesPreCod","FesPreFesCod",array[3]);
        array[6] = returnQuery("festival_premio","FesPreCod","FesPrePreCod",array[3]);
        array[7] = returnQuery("festival_premio","FesPreCod","TarCod",array[3]);
        array[8] = returnQuery("certamen","CerCod","CerOrgCod",array[2]);
        array[9] = returnQuery("personaje","PerCod","PerSexCod",array[1]);
        array[10] = RecEstRegTextField.getText();
        // Send data to the controller to remove it from the model
        recListTableController.deleteRow(array);
    }//Rec-LAST:event_deleteButtoRectionRecformed
    private void exitButtoRectionRecformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
    
    // Code for the activate button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // RecListTableController.java (LINE 66) and CouseListTableModel.java (LINE 248)
    private void actButtoRectionRecformed(java.awt.event.ActionEvent evt) {
    	 // TODO add your handling code here:
        String[] array = new String[jtable1.getColumnCount()];
        array[0] = RecNumberTextField.getText();
        array[1] = RecPerCodComboBox.getSelectedItem().toString().substring(0,RecPerCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[2] = RecCerCodComboBox.getSelectedItem().toString().substring(0,RecCerCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[3] = RecFesPreCodComboBox.getSelectedItem().toString().substring(0,RecFesPreCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[4] = returnQuery("personaje","PerCod","PerNacCod",array[1]);
        array[5] = returnQuery("festival_premio","FesPreCod","FesPreFesCod",array[3]);
        array[6] = returnQuery("festival_premio","FesPreCod","FesPrePreCod",array[3]);
        array[7] = returnQuery("festival_premio","FesPreCod","TarCod",array[3]);
        array[8] = returnQuery("certamen","CerCod","CerOrgCod",array[2]);
        array[9] = returnQuery("personaje","PerCod","PerSexCod",array[1]);
        array[10] = RecEstRegTextField.getText();
        
        // Send data to the controller to activate it from the model
        recListTableController.activateRow(array);
    }//Rec-LAST:event_activateButtoRectionRecformed
    
    // Code for the inactivate button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // RecListTableController.java (LINE 71) and CouseListTableModel.java (LINE 268)
    private void inactButtoRectionRecformed(java.awt.event.ActionEvent evt) {
    	 // TODO add your handling code here:

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = RecNumberTextField.getText();
        array[1] = RecPerCodComboBox.getSelectedItem().toString().substring(0,RecPerCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[2] = RecCerCodComboBox.getSelectedItem().toString().substring(0,RecCerCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[3] = RecFesPreCodComboBox.getSelectedItem().toString().substring(0,RecFesPreCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[4] = returnQuery("personaje","PerCod","PerNacCod",array[1]);
        array[5] = returnQuery("festival_premio","FesPreCod","FesPreFesCod",array[3]);
        array[6] = returnQuery("festival_premio","FesPreCod","FesPrePreCod",array[3]);
        array[7] = returnQuery("festival_premio","FesPreCod","TarCod",array[3]);
        array[8] = returnQuery("certamen","CerCod","CerOrgCod",array[2]);
        array[9] = returnQuery("personaje","PerCod","PerSexCod",array[1]);
        array[10] = RecEstRegTextField.getText();
        // Send data to the controller to inactivate it from the model
        recListTableController.inactivateRow(array);
    }//Rec-LAST:event_inactivateButtoRectionRecformed
    
    private void cancelButtoRectionRecformed(java.awt.event.ActionEvent evt) {
    	RecNumberTextField.enable();
    	RecEstRegTextField.enable();
    	
    	RecPerCodComboBox.setSelectedIndex(0);
    	RecCerCodComboBox.setSelectedIndex(0);
    	RecFesPreCodComboBox.setSelectedIndex(0);
    	
    	RecNumberTextField.setText("");
    	RecEstRegTextField.setText("");
    }
    // Code for the update button
    private void modButtoRectionRecformed(java.awt.event.ActionEvent evt) {
    	RecNumberTextField.disable();

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = RecNumberTextField.getText();
        array[1] = RecPerCodComboBox.getSelectedItem().toString().substring(0,RecPerCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[2] = RecCerCodComboBox.getSelectedItem().toString().substring(0,RecCerCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[3] = RecFesPreCodComboBox.getSelectedItem().toString().substring(0,RecFesPreCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[4] = returnQuery("personaje","PerCod","PerNacCod",array[1]);
        array[5] = returnQuery("festival_premio","FesPreCod","FesPreFesCod",array[3]);
        array[6] = returnQuery("festival_premio","FesPreCod","FesPrePreCod",array[3]);
        array[7] = returnQuery("festival_premio","FesPreCod","TarCod",array[3]);
        array[8] = returnQuery("certamen","CerCod","CerOrgCod",array[2]);
        array[9] = returnQuery("personaje","PerCod","PerSexCod",array[1]);
        array[10] = RecEstRegTextField.getText();
        recListTableController.updateRow(array, jtable1);
        
    }
    
    private void updateButtoRectionRecformed(java.awt.event.ActionEvent evt) {//Rec-FIRST:event_updateButtoRectionRecformed
        // TODO add your handling code here:

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = RecNumberTextField.getText();
        array[1] = RecPerCodComboBox.getSelectedItem().toString().substring(0,RecPerCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[2] = RecCerCodComboBox.getSelectedItem().toString().substring(0,RecCerCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[3] = RecFesPreCodComboBox.getSelectedItem().toString().substring(0,RecFesPreCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[4] = returnQuery("personaje","PerCod","PerNacCod",array[1]);
        array[5] = returnQuery("festival_premio","FesPreCod","FesPreFesCod",array[3]);
        array[6] = returnQuery("festival_premio","FesPreCod","FesPrePreCod",array[3]);
        array[7] = returnQuery("festival_premio","FesPreCod","TarCod",array[3]);
        array[8] = returnQuery("certamen","CerCod","CerOrgCod",array[2]);
        array[9] = returnQuery("personaje","PerCod","PerSexCod",array[1]);
        array[10] = RecEstRegTextField.getText();
        array[10] = RecEstRegTextField.getText();
        
        // Send data to the controller to update it in the model
        recListTableController.updateRow(array, jtable1);
    }//Rec-LAST:event_updateButtoRectionRecformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RecListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecListGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//Rec-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel RecListLabel;
    private javax.swing.JLabel RecNumberLabel;
    private javax.swing.JTextField RecNumberTextField;
    private javax.swing.JLabel RecEstRegLabel;
    private javax.swing.JTextField RecEstRegTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton modButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton inactButton;
    private javax.swing.JButton actButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel RecPerCodLabel;
    private javax.swing.JComboBox<String> RecPerCodComboBox;
    private javax.swing.JLabel RecCerCodLabel;
    private javax.swing.JComboBox<String> RecCerCodComboBox;
    private javax.swing.JLabel RecFesPreCodLabel;
    private javax.swing.JComboBox<String> RecFesPreCodComboBox;

     // End of variables declaration//Rec-END:variables
    Connection connection;
    Statement statement;
    void remplir_Jcomb() {
    	String url="jdbc:mysql://localhost:3306/";
    	String dbname="toadv2";
    	String regla="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    	String username="root";
    	String pass="";
        
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
        	statement = connection.createStatement();
        	
            ResultSet rs1 = statement.executeQuery("SELECT PerCod, PerNom FROM personaje");

            while (rs1.next()){
            	RecPerCodComboBox.addItem(rs1.getString(1)+" - "+rs1.getString(2));
            }
            ResultSet rs2 = statement.executeQuery("SELECT CerCod, CerNom FROM certamen");

            while (rs2.next()){
            	RecCerCodComboBox.addItem(rs2.getString(1)+" - "+rs2.getString(2));
            }
            ResultSet rs3 = statement.executeQuery("SELECT FesPreCod, FesPreGal FROM festival_premio");

            while (rs3.next()){
            	RecFesPreCodComboBox.addItem(rs3.getString(1)+" - "+rs3.getString(2));
            }
            
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
        finally {
        	try {
        		statement.close();
        		connection.close();
            } catch (SQLException ex) {
            	System.out.println(ex.getMessage());
                System.out.println(ex.getSQLState());
                System.out.println(ex.getErrorCode());
            }
        }
    }
    String returnQuery(String tabla, String colOri, String colDest, String data) {
    	String url="jdbc:mysql://localhost:3306/";
    	String dbname="toadv2";
    	String regla="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    	String username="root";
    	String pass="";
        String ret = "";
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
        	statement = connection.createStatement();
        	
            ResultSet rs1 = statement.executeQuery("SELECT "+colDest+" FROM "+ tabla + " WHERE " + colOri + " = " + data);
            while (rs1.next()){
            	 ret = rs1.getString(1);
            }
            
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
        finally {
        	try {
        		statement.close();
        		connection.close();
            } catch (SQLException ex) {
            	System.out.println(ex.getMessage());
                System.out.println(ex.getSQLState());
                System.out.println(ex.getErrorCode());
            }
        }
        return ret;
    }
}
