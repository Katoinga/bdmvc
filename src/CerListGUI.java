
import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class CerListGUI extends javax.swing.JFrame {

    private JTable jtable1; // The table displayed on the GUI
    private CerListTableController cerListTableController = null;

    public CerListGUI() {

        // This method creates the labels and text fields on the GUI
        initComponents();

        // Creates a controller for the table
        cerListTableController = new CerListTableController(this);

        // Add a table JTable to the GUI
        addJTable();

    }

    public void addJTable() {
        // Add the data and column names to a JTable
        jtable1 = new JTable(cerListTableController.getTableModel());

        // Add a ListSelectionListener to the table
        jtable1.getSelectionModel().addListSelectionListener(cerListTableController);

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
        jtable1.setModel(cerListTableController.getTableModel());
    }

    // Set data on the GenNameTextField
    public void setGenNameTextField(String name) {   GenNameTextField.setText(name);     }

    // Set data on the GenNumberTextField
    public void setGenNumberTextField(String value) { GenNumberTextField.setText(value); }

    // Set data on the GenCerFesCodTextField
    public void setGenCerFesCodTextField(String value) { GenCerFesCodTextField.setText(value); }

    // Set data on the GenTipTarSexCodTextField
    public void setGenCerOrgCodTextField(String value) { GenCerOrgCodTextField.setText(value); }

    // Set data on the GenTipTarSexCodTextField
    public void setGenCerEstRegTextField(String value) { GenCerEstRegTextField.setText(value); }
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
        GenNameLabel = new javax.swing.JLabel();
        GenNumberLabel = new javax.swing.JLabel();
        GenCerFesCodLabel = new javax.swing.JLabel();
        GenCerOrgCodLabel = new javax.swing.JLabel();
        GenCerEstRegLabel = new javax.swing.JLabel();

        GenNameTextField = new javax.swing.JTextField();
        GenNumberTextField = new javax.swing.JTextField();
        GenCerFesCodTextField = new javax.swing.JTextField();
        GenCerOrgCodTextField = new javax.swing.JTextField();
        GenCerEstRegTextField = new javax.swing.JTextField();

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
        GenNumberLabel.setText("Codigo:");
        GenNameLabel.setText("Nombre:");
        GenCerFesCodLabel.setText("Codigo de Festival: ");
        GenCerOrgCodLabel.setText("Codigo de Organizacion: ");
        GenCerEstRegLabel.setText("Estado del Registro: ");

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
                    .addComponent(GenNumberLabel))
                .addGap(147, 147, 147)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GenNumberTextField))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(GenCerFesCodLabel)
                    .addGap(161, 161, 161)
                    .addComponent(GenCerFesCodTextField)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(GenCerOrgCodLabel)
                    .addGap(161, 161, 161)
                    .addComponent(GenCerOrgCodTextField)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(GenCerEstRegLabel)
                    .addGap(161, 161, 161)
                    .addComponent(GenCerEstRegTextField)
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
                .addComponent(GenNameLabel)
                .addGap(161, 161, 161)
                .addComponent(GenNameTextField)
                .addContainerGap())

        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GenNameLabel)
                    .addComponent(GenNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GenNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GenNumberLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(GenCerFesCodTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(GenCerFesCodLabel))
                    .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                          .addComponent(GenCerOrgCodTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(GenCerOrgCodLabel))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(GenCerEstRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addComponent(GenCerEstRegLabel))
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
        GenListLabel.setText("Certamen");

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
        array[0] = GenNameTextField.getText();
        array[1] = GenNumberTextField.getText();
        array[2] = GenCerFesCodTextField.getText();
        array[3] = GenCerOrgCodTextField.getText();
        array[4] = GenCerEstRegTextField.getText();

        // Send data to the controller to add it to the model
        cerListTableController.addRow(array);
    }//GEN-LAST:event_addButtonActionPerformed

    // Code for the delete button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // cerListTableController.java (LINE 65) and CouseListTableModel.java (LINE 149)
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        String[] array = new String[jtable1.getColumnCount()];
        array[0] = GenNameTextField.getText();
        array[1] = GenNumberTextField.getText();
        array[2] = GenCerFesCodTextField.getText();
        array[3] = GenCerOrgCodTextField.getText();
        array[4] = GenCerEstRegTextField.getText();

        // Send data to the controller to remove it from the model
        cerListTableController.deleteRow(array);
    }//GEN-LAST:event_deleteButtonActionPerformed
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    // Code for the activate button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // cerListTableController.java (LINE 66) and CouseListTableModel.java (LINE 248)
    private void actButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	 // TODO add your handling code here:
        String[] array = new String[jtable1.getColumnCount()];
        array[0] = GenNameTextField.getText();
        array[1] = GenNumberTextField.getText();
        array[2] = GenCerFesCodTextField.getText();
        array[3] = GenCerOrgCodTextField.getText();
        array[4] = GenCerEstRegTextField.getText();

        // Send data to the controller to activate it from the model
        cerListTableController.activateRow(array);
    }//GEN-LAST:event_activateButtonActionPerformed

    // Code for the inactivate button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // cerListTableController.java (LINE 71) and CouseListTableModel.java (LINE 268)
    private void inactButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	 // TODO add your handling code here:
        String[] array = new String[jtable1.getColumnCount()];
        array[0] = GenNameTextField.getText();
        array[1] = GenNumberTextField.getText();
        array[2] = GenCerFesCodTextField.getText();
        array[3] = GenCerOrgCodTextField.getText();
        array[4] = GenCerEstRegTextField.getText();

        // Send data to the controller to inactivate it from the model
        cerListTableController.inactivateRow(array);
    }//GEN-LAST:event_inactivateButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	GenNumberTextField.enable();
    	GenNameTextField.enable();
    	GenCerFesCodTextField.enable();
    	GenCerOrgCodTextField.enable();
    	GenCerEstRegTextField.enable();

    	GenNameTextField.setText("");
    	GenNumberTextField.setText("");
    	GenCerFesCodTextField.setText("");
    	GenCerOrgCodTextField.setText("");
    	GenCerEstRegTextField.setText("");
    }
    // Code for the update button
    private void modButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	GenNumberTextField.disable();
    	String[] array = new String[jtable1.getColumnCount()];
        array[0] = GenNameTextField.getText();
        array[1] = GenNumberTextField.getText();
        array[2] = GenCerFesCodTextField.getText();
        array[3] = GenCerOrgCodTextField.getText();
        array[4] = GenCerEstRegTextField.getText();

        cerListTableController.updateRow(array, jtable1);

    }

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        String[] array = new String[jtable1.getColumnCount()];
        array[0] = GenNameTextField.getText();
        array[1] = GenNumberTextField.getText();
        array[2] = GenCerFesCodTextField.getText();
        array[3] = GenCerOrgCodTextField.getText();
        array[4] = GenCerEstRegTextField.getText();

        // Send data to the controller to update it in the model
        cerListTableController.updateRow(array, jtable1);
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
            java.util.logging.Logger.getLogger(FesListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FesListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FesListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FesListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FesListGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel GenListLabel;
    private javax.swing.JLabel GenNameLabel;
    private javax.swing.JTextField GenNameTextField;
    private javax.swing.JLabel GenNumberLabel;
    private javax.swing.JTextField GenNumberTextField;
    private javax.swing.JLabel GenCerFesCodLabel;
    private javax.swing.JTextField GenCerFesCodTextField;
    private javax.swing.JLabel GenCerOrgCodLabel;
    private javax.swing.JTextField GenCerOrgCodTextField;
    private javax.swing.JLabel GenCerEstRegLabel;
    private javax.swing.JTextField GenCerEstRegTextField;
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

}
