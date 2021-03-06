package otorgo;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class OtoListGUI extends javax.swing.JFrame {

    private JTable jtable1; // The table displayed on the GUI
    private OtoListTableController otoListTableController = null;

    public OtoListGUI() {
        
        // This method creates the labels and text fields on the GUI
        initComponents();
        
        // Creates a controller for the table
        otoListTableController = new OtoListTableController(this);

        // Add a table JTable to the GUI
        addJTable();

    }
    
    public void addJTable() {
        // Add the data and column names to a JTable
        jtable1 = new JTable(otoListTableController.getTableModel());
    
        // Add a ListSelectionListener to the table
        jtable1.getSelectionModel().addListSelectionListener(otoListTableController);
        
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
        jtable1.setModel(otoListTableController.getTableModel());
    }

    // Set data on the OtoCodTextField
    public void setOtoCodTextField(String name) {   OtoCodTextField.setText(name);     }
    
 // Set data on the GenTipTarSexCodTextField
    public void setOtoEstRegTextField(String value) { OtoEstRegTextField.setText(value); }
    
 // Set data on the GenCerFesCodTextField
    public void setOtoPelCodJComboBox(String value) { 
    	int size = OtoPelCodComboBox.getItemCount();
    	for(int c=0; c<size; c++) {
    		if(OtoPelCodComboBox.getItemAt(c).toString().substring(0,OtoPelCodComboBox.getItemAt(c).toString().indexOf(' ')).equals(value)) {
    			OtoPelCodComboBox.setSelectedIndex(c);
    			break;
    		}
    	}
    }
    
    // Set data on the GenCerFesCodTextField
    public void setOtoPreCodJComboBox(String value) {
    	int size = OtoPreCodComboBox.getItemCount();
    	for(int c=0; c<size; c++) {
    		if(OtoPreCodComboBox.getItemAt(c).toString().substring(0,OtoPreCodComboBox.getItemAt(c).toString().indexOf(' ')).equals(value)) {
    			OtoPreCodComboBox.setSelectedIndex(c);
    			break;
    		}
    	}
    }
    
   // Set data on the GenCerFesCodTextField
    public void setOtoCerCodJComboBox(String value) {
    	int size = OtoCerCodComboBox.getItemCount();
    	for(int c=0; c<size; c++) {
    		if(OtoCerCodComboBox.getItemAt(c).toString().substring(0,OtoCerCodComboBox.getItemAt(c).toString().indexOf(' ')).equals(value)) {
    			OtoCerCodComboBox.setSelectedIndex(c);
    			break;
    		}
    	}
    }
    
    // Set data on the GenCerFesCodTextField
    public void setOtoFesCodJComboBox(String value) {
    	int size = OtoFesCodComboBox.getItemCount();
    	for(int c=0; c<size; c++) {
    		if(OtoFesCodComboBox.getItemAt(c).toString().substring(0,OtoFesCodComboBox.getItemAt(c).toString().indexOf(' ')).equals(value)) {
    			OtoFesCodComboBox.setSelectedIndex(c);
    			break;
    		}
    	}
    }
    
    // Set data on the enrollmentTextField
    

    // Set data on the startDateTextField
    

    // Set data on the endDateTextField
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        OtoCodLabel = new javax.swing.JLabel();
        OtoPelCodLabel = new javax.swing.JLabel();
        OtoPreCodLabel = new javax.swing.JLabel();
        OtoCerCodLabel = new javax.swing.JLabel();
        OtoFesCodLabel = new javax.swing.JLabel();
        OtoEstRegLabel = new javax.swing.JLabel();

        OtoCodTextField = new javax.swing.JTextField();
        OtoEstRegTextField = new javax.swing.JTextField();
        
        OtoPelCodComboBox = new javax.swing.JComboBox<String>();
        OtoPreCodComboBox = new javax.swing.JComboBox<String>();
        OtoCerCodComboBox = new javax.swing.JComboBox<String>();
        OtoFesCodComboBox = new javax.swing.JComboBox<String>();
        remplir_Jcomb();
        
        modButton =new javax.swing.JButton();
        actButton = new javax.swing.JButton();
        inactButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        GenListLabel = new javax.swing.JLabel();

        // Program will terminate when the window is closed
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        OtoPelCodLabel.setText("Codigo de la pelicula:");
        OtoCodLabel.setText("Codigo :");
        OtoPreCodLabel.setText("Codigo del Premio: ");
        OtoCerCodLabel.setText("Codigo del Certamen: ");
        OtoFesCodLabel.setText("Codigo del Festival: ");
        OtoEstRegLabel.setText("Estado del Registro: ");
        
        // Details for the Add button
        addButton.setText("Adicionar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        // Details for the Delete button
        deleteButton.setText("Eliminar");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        modButton.setText("Modificar");
        modButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modButtonActionPerformed(evt);
            }
        });
        actButton.setText("Activar..");
        actButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actButtonActionPerformed(evt);
            }
        });
        inactButton.setText("Inactivar");
        inactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inactButtonActionPerformed(evt);
            }
        });
        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        exitButton.setText("Salir");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        // Details for the Update button
        updateButton.setText("Actualizar");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
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
                    .addComponent(OtoPelCodLabel))
                .addGap(147, 147, 147)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OtoPelCodComboBox))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(OtoPreCodLabel)
                    .addGap(161, 161, 161)
                    .addComponent(OtoPreCodComboBox)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(OtoCerCodLabel)
                    .addGap(161, 161, 161)
                    .addComponent(OtoCerCodComboBox)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(OtoFesCodLabel)
                    .addGap(161, 161, 161)
                    .addComponent(OtoFesCodComboBox)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(OtoEstRegLabel)
                    .addGap(161, 161, 161)
                    .addComponent(OtoEstRegTextField)
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OtoCodLabel)
                .addGap(161, 161, 161)
                .addComponent(OtoCodTextField)
                .addContainerGap())
            
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OtoCodLabel)
                    .addComponent(OtoCodTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OtoPelCodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OtoPelCodLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(OtoPreCodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(OtoPreCodLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                          .addComponent(OtoCerCodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(OtoCerCodLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(OtoFesCodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addComponent(OtoFesCodLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(OtoEstRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addComponent(OtoEstRegLabel))
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

        GenListLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        GenListLabel.setText("Otorgo");

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
                        .addComponent(GenListLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GenListLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Code for the add button
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        String[] array = new String[jtable1.getColumnCount()];
        array[0] = OtoCodTextField.getText();
        array[1] = OtoPelCodComboBox.getSelectedItem().toString().substring(0,OtoPelCodComboBox.getSelectedItem().toString().indexOf(' ')); 
        array[2] = OtoPreCodComboBox.getSelectedItem().toString().substring(0,OtoPreCodComboBox.getSelectedItem().toString().indexOf(' ')); 
        array[3] = OtoCerCodComboBox.getSelectedItem().toString().substring(0,OtoCerCodComboBox.getSelectedItem().toString().indexOf(' ')); 
        array[4] = OtoFesCodComboBox.getSelectedItem().toString().substring(0,OtoFesCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[5] = returnQuery("premio","PreCod","PreTarCod",array[2]);
        array[6] = returnQuery("pelicula","PelCod","PelNacCod",array[1]);
        array[7] = returnQuery("certamen","CerCod","CerOrgCod",array[3]);
        array[8] = OtoEstRegTextField.getText();
        
        // Send data to the controller to add it to the model
        otoListTableController.addRow(array);
    }//GEN-LAST:event_addButtonActionPerformed

    // Code for the delete button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // otoListTableController.java (LINE 65) and CouseListTableModel.java (LINE 149)
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        String[] array = new String[jtable1.getColumnCount()];
        array[0] = OtoCodTextField.getText();
        array[1] = OtoPelCodComboBox.getSelectedItem().toString().substring(0,OtoPelCodComboBox.getSelectedItem().toString().indexOf(' ')); 
        array[2] = OtoPreCodComboBox.getSelectedItem().toString().substring(0,OtoPreCodComboBox.getSelectedItem().toString().indexOf(' ')); 
        array[3] = OtoCerCodComboBox.getSelectedItem().toString().substring(0,OtoCerCodComboBox.getSelectedItem().toString().indexOf(' ')); 
        array[4] = OtoFesCodComboBox.getSelectedItem().toString().substring(0,OtoFesCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[5] = returnQuery("premio","PreCod","PreTarCod",array[2]);
        array[6] = returnQuery("pelicula","PelCod","PelNacCod",array[1]);
        array[7] = returnQuery("certamen","CerCod","CerOrgCod",array[3]);
        array[8] = OtoEstRegTextField.getText();

        // Send data to the controller to remove it from the model
        otoListTableController.deleteRow(array);
    }//GEN-LAST:event_deleteButtonActionPerformed
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
    
    // Code for the activate button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // otoListTableController.java (LINE 66) and CouseListTableModel.java (LINE 248)
    private void actButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	 // TODO add your handling code here:
        String[] array = new String[jtable1.getColumnCount()];
        array[0] = OtoCodTextField.getText();
        array[1] = OtoPelCodComboBox.getSelectedItem().toString().substring(0,OtoPelCodComboBox.getSelectedItem().toString().indexOf(' ')); 
        array[2] = OtoPreCodComboBox.getSelectedItem().toString().substring(0,OtoPreCodComboBox.getSelectedItem().toString().indexOf(' ')); 
        array[3] = OtoCerCodComboBox.getSelectedItem().toString().substring(0,OtoCerCodComboBox.getSelectedItem().toString().indexOf(' ')); 
        array[4] = OtoFesCodComboBox.getSelectedItem().toString().substring(0,OtoFesCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[5] = returnQuery("premio","PreCod","PreTarCod",array[2]);
        array[6] = returnQuery("pelicula","PelCod","PelNacCod",array[1]);
        array[7] = returnQuery("certamen","CerCod","CerOrgCod",array[3]);
        array[8] = OtoEstRegTextField.getText();

        // Send data to the controller to activate it from the model
        otoListTableController.activateRow(array);
    }//GEN-LAST:event_activateButtonActionPerformed
    
    // Code for the inactivate button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // otoListTableController.java (LINE 71) and CouseListTableModel.java (LINE 268)
    private void inactButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	 // TODO add your handling code here:
        String[] array = new String[jtable1.getColumnCount()];
        array[0] = OtoCodTextField.getText();
        array[1] = OtoPelCodComboBox.getSelectedItem().toString().substring(0,OtoPelCodComboBox.getSelectedItem().toString().indexOf(' ')); 
        array[2] = OtoPreCodComboBox.getSelectedItem().toString().substring(0,OtoPreCodComboBox.getSelectedItem().toString().indexOf(' ')); 
        array[3] = OtoCerCodComboBox.getSelectedItem().toString().substring(0,OtoCerCodComboBox.getSelectedItem().toString().indexOf(' ')); 
        array[4] = OtoFesCodComboBox.getSelectedItem().toString().substring(0,OtoFesCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[5] = returnQuery("premio","PreCod","PreTarCod",array[2]);
        array[6] = returnQuery("pelicula","PelCod","PelNacCod",array[1]);
        array[7] = returnQuery("certamen","CerCod","CerOrgCod",array[3]);
        array[8] = OtoEstRegTextField.getText();

        // Send data to the controller to inactivate it from the model
        otoListTableController.inactivateRow(array);
    }//GEN-LAST:event_inactivateButtonActionPerformed
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	OtoCodTextField.enable();
    	OtoEstRegTextField.enable();
    	OtoPelCodComboBox.setSelectedIndex(0);
    	OtoPreCodComboBox.setSelectedIndex(0);
    	OtoCerCodComboBox.setSelectedIndex(0);
    	OtoFesCodComboBox.setSelectedIndex(0);
    	OtoCodTextField.setText("");
    	OtoEstRegTextField.setText("");
    }
    // Code for the update button
    private void modButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	OtoCodTextField.disable();
    	String[] array = new String[jtable1.getColumnCount()];
    	array[0] = OtoCodTextField.getText();
        array[1] = OtoPelCodComboBox.getSelectedItem().toString().substring(0,OtoPelCodComboBox.getSelectedItem().toString().indexOf(' ')); 
        array[2] = OtoPreCodComboBox.getSelectedItem().toString().substring(0,OtoPreCodComboBox.getSelectedItem().toString().indexOf(' ')); 
        array[3] = OtoCerCodComboBox.getSelectedItem().toString().substring(0,OtoCerCodComboBox.getSelectedItem().toString().indexOf(' ')); 
        array[4] = OtoFesCodComboBox.getSelectedItem().toString().substring(0,OtoFesCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[5] = returnQuery("premio","PreCod","PreTarCod",array[2]);
        array[6] = returnQuery("pelicula","PelCod","PelNacCod",array[1]);
        array[7] = returnQuery("certamen","CerCod","CerOrgCod",array[3]);
        array[8] = OtoEstRegTextField.getText();

        otoListTableController.updateRow(array, jtable1);
        
    }
    
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        String[] array = new String[jtable1.getColumnCount()];
        array[0] = OtoCodTextField.getText();
        array[1] = OtoPelCodComboBox.getSelectedItem().toString().substring(0,OtoPelCodComboBox.getSelectedItem().toString().indexOf(' ')); 
        array[2] = OtoPreCodComboBox.getSelectedItem().toString().substring(0,OtoPreCodComboBox.getSelectedItem().toString().indexOf(' ')); 
        array[3] = OtoCerCodComboBox.getSelectedItem().toString().substring(0,OtoCerCodComboBox.getSelectedItem().toString().indexOf(' ')); 
        array[4] = OtoFesCodComboBox.getSelectedItem().toString().substring(0,OtoFesCodComboBox.getSelectedItem().toString().indexOf(' '));
        array[5] = returnQuery("premio","PreCod","PreTarCod",array[2]);
        array[6] = returnQuery("pelicula","PelCod","PelNacCod",array[1]);
        array[7] = returnQuery("certamen","CerCod","CerOrgCod",array[3]);
        array[8] = OtoEstRegTextField.getText();

        // Send data to the controller to update it in the model
        otoListTableController.updateRow(array, jtable1);
    }//GEN-LAST:event_updateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(OtoListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OtoListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OtoListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OtoListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OtoListGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel GenListLabel;
    private javax.swing.JLabel OtoCodLabel;
    private javax.swing.JTextField OtoCodTextField;
    private javax.swing.JLabel OtoPelCodLabel;
    private javax.swing.JComboBox<String> OtoPelCodComboBox;
    private javax.swing.JLabel OtoPreCodLabel;
    private javax.swing.JComboBox<String> OtoPreCodComboBox;
    private javax.swing.JLabel OtoCerCodLabel;
    private javax.swing.JComboBox<String> OtoCerCodComboBox;
    private javax.swing.JLabel OtoFesCodLabel;
    private javax.swing.JComboBox<String> OtoFesCodComboBox;
    private javax.swing.JLabel OtoEstRegLabel;
    private javax.swing.JTextField OtoEstRegTextField;
   
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton modButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton inactButton;
    private javax.swing.JButton actButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
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
        	
            ResultSet rs1 = statement.executeQuery("SELECT PelCod, PelTitEsp FROM pelicula");
            while (rs1.next()){
            	OtoPelCodComboBox.addItem(rs1.getString(1)+ " - " + rs1.getString(2));
            }
            
            ResultSet rs2 = statement.executeQuery("SELECT PreCod, PreNom FROM premio");
            while (rs2.next()){
            	OtoPreCodComboBox.addItem(rs2.getString(1)+ " - " + rs2.getString(2));
            }
            
            ResultSet rs3 = statement.executeQuery("SELECT CerCod, CerNom FROM certamen");
            while (rs3.next()){
            	OtoCerCodComboBox.addItem(rs3.getString(1)+ " - " + rs3.getString(2));
            }
            
            ResultSet rs4 = statement.executeQuery("SELECT FesCod, FesNom FROM festival");
            while (rs4.next()){
            	OtoFesCodComboBox.addItem(rs4.getString(1)+ " - " + rs4.getString(2));
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
