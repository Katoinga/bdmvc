package Personaje;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;


import javax.swing.*;

public class PerListGUI extends javax.swing.JFrame {

    private JTable jtable1; // The table displayed on the GUI
    private PerListTableController perListTableController = null;

    public PerListGUI() {
        
        // This method creates the labels and text fields on the GUI
        initComponents();
        
        // Creates a controller for the table
        perListTableController = new PerListTableController(this);

        // Add a table JTable to the GUI
        addJTable();

    }
    
    public void addJTable() {
        // Add the data and column names to a JTable
        jtable1 = new JTable(perListTableController.getTableModel());
    
        // Add a ListSelectionListener to the table
        jtable1.getSelectionModel().addListSelectionListener(perListTableController);
        
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
        jtable1.setModel(perListTableController.getTableModel());
    }

    // Set data on the PerNameTextField
    public void setPerNameTextField(String name) {
        PerNameTextField.setText(name);
    }

    // Set data on the PerNumberTextField
    public void setPerNumberTextField(String value) { PerNumberTextField.setText(value); }
    
    // Set data on the PerEstRegTextField
    public void setPerNacTextField(String value) { PerNacTextField.setText(value); }
    public void setPerNacCodComboBox(String value) { PerNacCodComboBox.setSelectedItem(value); }
    public void setPerSexCodComboBox(String value) { PerSexCodComboBox.setSelectedItem(value); }

    public void setPerEstRegTextField(String value) { PerEstRegTextField.setText(value); }

    // Set data on the enrollmentTextField
    

    // Set data on the startDateTextField
    

    // Set data on the endDateTextField
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * rePererated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Pererated Code">//Per-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PerNameLabel = new javax.swing.JLabel();
        PerNumberLabel = new javax.swing.JLabel();
        PerEstRegLabel = new javax.swing.JLabel();
        PerNacLabel = new javax.swing.JLabel();
        PerNacTextField = new javax.swing.JTextField();
        PerNacCodLabel = new javax.swing.JLabel();
        PerNacCodComboBox = new javax.swing.JComboBox<String>();
        PerSexCodLabel = new javax.swing.JLabel();
        PerSexCodComboBox = new javax.swing.JComboBox<String>();
        PerNameTextField = new javax.swing.JTextField();
        PerNumberTextField = new javax.swing.JTextField();
        PerEstRegTextField = new javax.swing.JTextField();
        modButton =new javax.swing.JButton();
        actButton = new javax.swing.JButton();
        inactButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        PerListLabel = new javax.swing.JLabel();
        remplir_Jcomb();
        // Program will terminate when the window is closed
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PerNumberLabel.setText("Codigo:");
        PerNameLabel.setText("Nombre:");
        PerNacLabel.setText("Nacimiento:");
        PerNacCodLabel.setText("Nacionalidad(CODIGO):");
        PerSexCodLabel.setText("Genero:");

        PerEstRegLabel.setText("Estado del Registro:");
        
        

        // Details for the Add button
        addButton.setText("Adicionar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtoPertionPerformed(evt);
            }
        });

        // Details for the Delete button
        deleteButton.setText("Eliminar");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtoPertionPerformed(evt);
            }
        });
        modButton.setText("Modificar");
        modButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modButtoPertionPerformed(evt);
            }
        });
        actButton.setText("Activar..");
        actButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actButtoPertionPerformed(evt);
            }
        });
        inactButton.setText("Inactivar");
        inactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inactButtoPertionPerformed(evt);
            }
        });
        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtoPertionPerformed(evt);
            }
        });
        exitButton.setText("Salir");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtoPertionPerformed(evt);
            }
        });
        // Details for the Update button
        updateButton.setText("Actualizar");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtoPertionPerformed(evt);
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
                    .addComponent(PerNumberLabel))
                .addGap(147, 147, 147)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PerNumberTextField))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PerNacLabel)
                    .addGap(148, 148, 148)
                    .addComponent(PerNacTextField)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PerNacCodLabel)
                    .addGap(148, 148, 148)
                    .addComponent(PerNacCodComboBox)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PerSexCodLabel)
                    .addGap(148, 148, 148)
                    .addComponent(PerSexCodComboBox)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PerEstRegLabel)
                    .addGap(148, 148, 148)
                    .addComponent(PerEstRegTextField)
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
                .addComponent(PerNameLabel)
                .addGap(161, 161, 161)
                .addComponent(PerNameTextField)
                .addContainerGap())
            
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PerNameLabel)
                    .addComponent(PerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PerNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PerNumberLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PerNacTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PerNacLabel))
                    .addGap(18, 18, 18)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PerNacCodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PerNacCodLabel))
                        .addGap(18, 18, 18)  
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(PerSexCodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PerSexCodLabel))
                            .addGap(18, 18, 18) 
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PerEstRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PerEstRegLabel))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PerListLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        PerListLabel.setText("Personajes");

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
                        .addComponent(PerListLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PerListLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//Per-END:initComponents

    // Code for the add button
    private void addButtoPertionPerformed(java.awt.event.ActionEvent evt) {//Per-FIRST:event_addButtoPertionPerformed
        // TODO add your handling code here:
    	String[] pernac= PerNacCodComboBox.getSelectedItem().toString().split(" ");
    	String[] persex= PerSexCodComboBox.getSelectedItem().toString().split(" ");

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = PerNameTextField.getText();
        array[1] = PerNumberTextField.getText();
        array[2] = PerNacTextField.getText();
        array[3] = pernac[0];
        array[4] = persex[0];

        array[5] = PerEstRegTextField.getText();
        
        // Send data to the controller to add it to the model
        perListTableController.addRow(array);
    }//Per-LAST:event_addButtoPertionPerformed

    // Code for the delete button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // PerListTableController.java (LINE 65) and CouseListTableModel.java (LINE 149)
    private void deleteButtoPertionPerformed(java.awt.event.ActionEvent evt) {//Per-FIRST:event_deleteButtoPertionPerformed
        // TODO add your handling code here:
    	String[] pernac= PerNacCodComboBox.getSelectedItem().toString().split(" ");
    	String[] persex= PerSexCodComboBox.getSelectedItem().toString().split(" ");

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = PerNameTextField.getText();
        array[1] = PerNumberTextField.getText();
        array[2] = PerNacTextField.getText();
        array[3] = pernac[0];
        array[4] = persex[0];

        array[5] = PerEstRegTextField.getText();
        // Send data to the controller to remove it from the model
        perListTableController.deleteRow(array);
    }//Per-LAST:event_deleteButtoPertionPerformed
    private void exitButtoPertionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
    
    // Code for the activate button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // PerListTableController.java (LINE 66) and CouseListTableModel.java (LINE 248)
    private void actButtoPertionPerformed(java.awt.event.ActionEvent evt) {
    	 // TODO add your handling code here:
    	String[] pernac= PerNacCodComboBox.getSelectedItem().toString().split(" ");
    	String[] persex= PerSexCodComboBox.getSelectedItem().toString().split(" ");

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = PerNameTextField.getText();
        array[1] = PerNumberTextField.getText();
        array[2] = PerNacTextField.getText();
        array[3] = pernac[0];
        array[4] = persex[0];

        array[5] = PerEstRegTextField.getText();
        
        // Send data to the controller to activate it from the model
        perListTableController.activateRow(array);
    }//Per-LAST:event_activateButtoPertionPerformed
    
    // Code for the inactivate button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // PerListTableController.java (LINE 71) and CouseListTableModel.java (LINE 268)
    private void inactButtoPertionPerformed(java.awt.event.ActionEvent evt) {
    	 // TODO add your handling code here:
    	String[] pernac= PerNacCodComboBox.getSelectedItem().toString().split(" ");
    	String[] persex= PerSexCodComboBox.getSelectedItem().toString().split(" ");

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = PerNameTextField.getText();
        array[1] = PerNumberTextField.getText();
        array[2] = PerNacTextField.getText();
        array[3] = pernac[0];
        array[4] = persex[0];

        array[5] = PerEstRegTextField.getText();
        
        // Send data to the controller to inactivate it from the model
        perListTableController.inactivateRow(array);
    }//Per-LAST:event_inactivateButtoPertionPerformed
    
    private void cancelButtoPertionPerformed(java.awt.event.ActionEvent evt) {
    	PerNumberTextField.enable();
    	PerNameTextField.enable();
    	PerEstRegTextField.enable();
    	PerNameTextField.setText("");
    	PerNumberTextField.setText("");
    	PerEstRegTextField.setText("");
    	PerNacTextField.setText("");
    }
    // Code for the update button
    private void modButtoPertionPerformed(java.awt.event.ActionEvent evt) {
    	PerNumberTextField.disable();
    	String[] pernac= PerNacCodComboBox.getSelectedItem().toString().split(" ");
    	String[] persex= PerSexCodComboBox.getSelectedItem().toString().split(" ");

    	String[] array = new String[jtable1.getColumnCount()];
    	array[0] = PerNameTextField.getText();
        array[1] = PerNumberTextField.getText();
        array[2] = PerNacTextField.getText();
        array[3] = pernac[0];
        array[4] = persex[0];

        array[5] = PerEstRegTextField.getText();
        perListTableController.updateRow(array, jtable1);
        
    }
    
    private void updateButtoPertionPerformed(java.awt.event.ActionEvent evt) {//Per-FIRST:event_updateButtoPertionPerformed
        // TODO add your handling code here:
    	String[] pernac= PerNacCodComboBox.getSelectedItem().toString().split(" ");
    	String[] persex= PerSexCodComboBox.getSelectedItem().toString().split(" ");

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = PerNameTextField.getText();
        array[1] = PerNumberTextField.getText();
        array[2] = PerNacTextField.getText();
        array[3] = pernac[0];
        array[4] = persex[0];

        array[5] = PerEstRegTextField.getText();
        // Send data to the controller to update it in the model
        perListTableController.updateRow(array, jtable1);
    }//Per-LAST:event_updateButtoPertionPerformed

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
            java.util.logging.Logger.getLogger(PerListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerListGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//Per-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel PerListLabel;
    private javax.swing.JLabel PerNameLabel;
    private javax.swing.JTextField PerNameTextField;
    private javax.swing.JLabel PerNumberLabel;
    private javax.swing.JTextField PerNumberTextField;
    private javax.swing.JLabel PerEstRegLabel;
    private javax.swing.JTextField PerEstRegTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton modButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton inactButton;
    private javax.swing.JButton actButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel PerNacLabel;
    private javax.swing.JTextField PerNacTextField;
    private javax.swing.JLabel PerNacCodLabel;
    private javax.swing.JLabel PerSexCodLabel;
    
    private javax.swing.JComboBox<String> PerNacCodComboBox;
    private javax.swing.JComboBox<String> PerSexCodComboBox;
    // End of variables declaration//Per-END:variables
    
    
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
        	
            ResultSet rs1 = statement.executeQuery("SELECT NacCod, NacDes FROM nacionalidad");

            while (rs1.next()){
            	PerNacCodComboBox.addItem(rs1.getString(1)+" - "+rs1.getString(2));
            }
            
            ResultSet rs2 = statement.executeQuery("SELECT SexCod, SexNom FROM sexo");
            while (rs2.next()){
            	PerSexCodComboBox.addItem(rs2.getString(1)+" - "+rs2.getString(2));
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
}
