package Premio;

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

public class PreListGUI extends javax.swing.JFrame {

    private JTable jtable1; // The table displayed on the GUI
    private PreListTableController preListTableController = null;

    public PreListGUI() {
        
        // This method creates the labels and text fields on the GUI
        initComponents();
        
        // Creates a controller for the table
        preListTableController = new PreListTableController(this);

        // Add a table JTable to the GUI
        addJTable();

    }
    
    public void addJTable() {
        // Add the data and column names to a JTable
        jtable1 = new JTable(preListTableController.getTableModel());
    
        // Add a ListSelectionListener to the table
        jtable1.getSelectionModel().addListSelectionListener(preListTableController);
        
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
        jtable1.setModel(preListTableController.getTableModel());
    }

    // Set data on the PreNameTextField
    public void setPreNameTextField(String name) {
        PreNameTextField.setText(name);
    }

    // Set data on the PreNumberTextField
    public void setPreNumberTextField(String value) { PreNumberTextField.setText(value); }
    
    // Set data on the PreEstRegTextField
    public void setPreTarCodComboBox(String value) { PreTarCodComboBox.setSelectedItem(value); }

    public void setPreEstRegTextField(String value) { PreEstRegTextField.setText(value); }

    // Set data on the enrollmentTextField
    

    // Set data on the startDateTextField
    

    // Set data on the endDateTextField
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * rePreerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Preerated Code">//Pre-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PreNameLabel = new javax.swing.JLabel();
        PreNumberLabel = new javax.swing.JLabel();
        PreEstRegLabel = new javax.swing.JLabel();
        
        PreTarCodLabel = new javax.swing.JLabel();
        PreTarCodComboBox = new javax.swing.JComboBox<String>();
        
        PreNameTextField = new javax.swing.JTextField();
        PreNumberTextField = new javax.swing.JTextField();
        PreEstRegTextField = new javax.swing.JTextField();
        modButton =new javax.swing.JButton();
        actButton = new javax.swing.JButton();
        inactButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        PreListLabel = new javax.swing.JLabel();
        remplir_Jcomb();
        // Program will terminate when the window is closed
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PreNumberLabel.setText("Codigo:");
        PreNameLabel.setText("Nombre:");
        PreTarCodLabel.setText("Tarea(CODIGO):");

        PreEstRegLabel.setText("Estado del Registro:");
        
        

        // Details for the Add button
        addButton.setText("Adicionar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtoPretionPreformed(evt);
            }
        });

        // Details for the Delete button
        deleteButton.setText("Eliminar");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtoPretionPreformed(evt);
            }
        });
        modButton.setText("Modificar");
        modButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modButtoPretionPreformed(evt);
            }
        });
        actButton.setText("Activar..");
        actButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actButtoPretionPreformed(evt);
            }
        });
        inactButton.setText("Inactivar");
        inactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inactButtoPretionPreformed(evt);
            }
        });
        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtoPretionPreformed(evt);
            }
        });
        exitButton.setText("Salir");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtoPretionPreformed(evt);
            }
        });
        // Details for the Update button
        updateButton.setText("Actualizar");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtoPretionPreformed(evt);
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
                    .addComponent(PreNumberLabel))
                .addGap(147, 147, 147)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PreNumberTextField))
                .addContainerGap())
            
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PreTarCodLabel)
                    .addGap(148, 148, 148)
                    .addComponent(PreTarCodComboBox)
                    .addContainerGap())
            
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PreEstRegLabel)
                    .addGap(148, 148, 148)
                    .addComponent(PreEstRegTextField)
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
                .addComponent(PreNameLabel)
                .addGap(161, 161, 161)
                .addComponent(PreNameTextField)
                .addContainerGap())
            
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PreNameLabel)
                    .addComponent(PreNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PreNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PreNumberLabel))
                .addGap(18, 18, 18)
                
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PreTarCodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PreTarCodLabel))
                        .addGap(18, 18, 18)  
                  
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PreEstRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PreEstRegLabel))
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

        PreListLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        PreListLabel.setText("Presonajes");

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
                        .addComponent(PreListLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PreListLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//Pre-END:initComponents

    // Code for the add button
    private void addButtoPretionPreformed(java.awt.event.ActionEvent evt) {//Pre-FIRST:event_addButtoPretionPreformed
        // TODO add your handling code here:
    	String[] pretar= PreTarCodComboBox.getSelectedItem().toString().split(" ");

        String[] array = new String[jtable1.getColumnCount()+1];
        array[0] = PreNameTextField.getText();
        array[1] = PreNumberTextField.getText();
        array[2] = pretar[0];
        array[3] = PreEstRegTextField.getText();
        
        // Send data to the controller to add it to the model
        preListTableController.addRow(array);
    }//Pre-LAST:event_addButtoPretionPreformed

    // Code for the delete button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // PreListTableController.java (LINE 65) and CouseListTableModel.java (LINE 149)
    private void deleteButtoPretionPreformed(java.awt.event.ActionEvent evt) {//Pre-FIRST:event_deleteButtoPretionPreformed
        // TODO add your handling code here:
    	String[] pretar= PreTarCodComboBox.getSelectedItem().toString().split(" ");

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = PreNameTextField.getText();
        array[1] = PreNumberTextField.getText();
        array[2] = pretar[0];
        array[3] = PreEstRegTextField.getText();
        // Send data to the controller to remove it from the model
        preListTableController.deleteRow(array);
    }//Pre-LAST:event_deleteButtoPretionPreformed
    private void exitButtoPretionPreformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
    
    // Code for the activate button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // PreListTableController.java (LINE 66) and CouseListTableModel.java (LINE 248)
    private void actButtoPretionPreformed(java.awt.event.ActionEvent evt) {
    	 // TODO add your handling code here:
    	String[] pretar= PreTarCodComboBox.getSelectedItem().toString().split(" ");

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = PreNameTextField.getText();
        array[1] = PreNumberTextField.getText();
        array[2] = pretar[0];
        array[3] = PreEstRegTextField.getText();
        // Send data to the controller to activate it from the model
        preListTableController.activateRow(array);
    }//Pre-LAST:event_activateButtoPretionPreformed
    
    // Code for the inactivate button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // PreListTableController.java (LINE 71) and CouseListTableModel.java (LINE 268)
    private void inactButtoPretionPreformed(java.awt.event.ActionEvent evt) {
    	 // TODO add your handling code here:
    	String[] pretar= PreTarCodComboBox.getSelectedItem().toString().split(" ");

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = PreNameTextField.getText();
        array[1] = PreNumberTextField.getText();
        array[2] = pretar[0];
        array[3] = PreEstRegTextField.getText();
        // Send data to the controller to inactivate it from the model
        preListTableController.inactivateRow(array);
    }//Pre-LAST:event_inactivateButtoPretionPreformed
    
    private void cancelButtoPretionPreformed(java.awt.event.ActionEvent evt) {
    	PreNumberTextField.enable();
    	PreNameTextField.enable();
    	PreEstRegTextField.enable();
    	PreNameTextField.setText("");
    	PreNumberTextField.setText("");
    	PreEstRegTextField.setText("");
    }
    // Code for the update button
    private void modButtoPretionPreformed(java.awt.event.ActionEvent evt) {
    	PreNumberTextField.disable();
    	String[] pretar= PreTarCodComboBox.getSelectedItem().toString().split(" ");

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = PreNameTextField.getText();
        array[1] = PreNumberTextField.getText();
        array[2] = pretar[0];
        array[3] = PreEstRegTextField.getText();
        preListTableController.updateRow(array, jtable1);
        
    }
    
    private void updateButtoPretionPreformed(java.awt.event.ActionEvent evt) {//Pre-FIRST:event_updateButtoPretionPreformed
        // TODO add your handling code here:
    	String[] pretar= PreTarCodComboBox.getSelectedItem().toString().split(" ");

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = PreNameTextField.getText();
        array[1] = PreNumberTextField.getText();
        array[2] = pretar[0];
        array[3] = PreEstRegTextField.getText();
        // Send data to the controller to update it in the model
        preListTableController.updateRow(array, jtable1);
    }//Pre-LAST:event_updateButtoPretionPreformed

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
            java.util.logging.Logger.getLogger(PreListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PreListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PreListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PreListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PreListGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//Pre-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel PreListLabel;
    private javax.swing.JLabel PreNameLabel;
    private javax.swing.JTextField PreNameTextField;
    private javax.swing.JLabel PreNumberLabel;
    private javax.swing.JTextField PreNumberTextField;
    private javax.swing.JLabel PreEstRegLabel;
    private javax.swing.JTextField PreEstRegTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton modButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton inactButton;
    private javax.swing.JButton actButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton updateButton;
    
    private javax.swing.JLabel PreTarCodLabel;
    
    private javax.swing.JComboBox<String> PreTarCodComboBox;
    // End of variables declaration//Pre-END:variables
    
    
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
        	
            ResultSet rs1 = statement.executeQuery("SELECT TarCod FROM tarea");

            while (rs1.next()){
            	PreTarCodComboBox.addItem(rs1.getString(1)+" Tarea");
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
