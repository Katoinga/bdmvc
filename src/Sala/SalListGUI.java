package Sala;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class SalListGUI extends javax.swing.JFrame {

    private JTable jtable1; // The table displayed on the GUI
    private SalListTableController salListTableController = null;

    public SalListGUI() {
        
        // This method creates the labels and text fields on the GUI
        initComponents();
        
        // Creates a controller for the table
        salListTableController = new SalListTableController(this);

        // Add a table JTable to the GUI
        addJTable();

    }
    
    public void addJTable() {
        // Add the data and column names to a JTable
        jtable1 = new JTable(salListTableController.getTableModel());
    
        // Add a ListSelectionListener to the table
        jtable1.getSelectionModel().addListSelectionListener(salListTableController);
        
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
        jtable1.setModel(salListTableController.getTableModel());
    }

    // Set data on the SalNameTextField
    public void setSalAfoTextField(String name) {
        SalAfoTextField.setText(name);
    }

    // Set data on the SalNumberTextField
    public void setSalNumberTextField(String value) { SalNumberTextField.setText(value); }
    
    // Set data on the SalEstRegTextField
    public void setSalCinCodComboBox(String value) { SalCinCodComboBox.setSelectedItem(value);}

    public void setSalEstRegTextField(String value) { SalEstRegTextField.setText(value); }

    // Set data on the enrollmentTextField
    

    // Set data on the startDateTextField
    

    // Set data on the endDateTextField
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * reSalerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Salerated Code">//Sal-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        SalAfoLabel = new javax.swing.JLabel();
        SalNumberLabel = new javax.swing.JLabel();
        SalEstRegLabel = new javax.swing.JLabel();
        
        SalCinCodLabel = new javax.swing.JLabel();
        SalCinCodComboBox = new javax.swing.JComboBox<String>();
        
        SalAfoTextField = new javax.swing.JTextField();
        SalNumberTextField = new javax.swing.JTextField();
        SalEstRegTextField = new javax.swing.JTextField();
        modButton =new javax.swing.JButton();
        actButton = new javax.swing.JButton();
        inactButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        SalListLabel = new javax.swing.JLabel();
        remplir_Jcomb();
        // Program will terminate when the window is closed
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SalNumberLabel.setText("Codigo:");
        SalAfoLabel.setText("Aforo:");
        SalCinCodLabel.setText("Cine(CODIGO):");

        SalEstRegLabel.setText("Estado del Registro:");
        
        

        // Details for the Add button
        addButton.setText("Adicionar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtoSaltionSalformed(evt);
            }
        });

        // Details for the Delete button
        deleteButton.setText("Eliminar");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtoSaltionSalformed(evt);
            }
        });
        modButton.setText("Modificar");
        modButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modButtoSaltionSalformed(evt);
            }
        });
        actButton.setText("Activar..");
        actButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actButtoSaltionSalformed(evt);
            }
        });
        inactButton.setText("Inactivar");
        inactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inactButtoSaltionSalformed(evt);
            }
        });
        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtoSaltionSalformed(evt);
            }
        });
        exitButton.setText("Salir");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtoSaltionSalformed(evt);
            }
        });
        // Details for the Update button
        updateButton.setText("Actualizar");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtoSaltionSalformed(evt);
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
                    .addComponent(SalNumberLabel))
                .addGap(147, 147, 147)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SalNumberTextField))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(SalAfoLabel)
                    .addGap(148, 148, 148)
                    .addComponent(SalAfoTextField)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(SalCinCodLabel)
                    .addGap(148, 148, 148)
                    .addComponent(SalCinCodComboBox)
                    .addContainerGap())
            
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(SalEstRegLabel)
                    .addGap(148, 148, 148)
                    .addComponent(SalEstRegTextField)
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
                    .addComponent(SalNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SalNumberLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SalAfoLabel)
                        .addComponent(SalAfoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SalCinCodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SalCinCodLabel))
                        .addGap(18, 18, 18)  
               
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SalEstRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SalEstRegLabel))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SalListLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        SalListLabel.setText("Salas");

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
                        .addComponent(SalListLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SalListLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//Sal-END:initComponents

    // Code for the add button
    private void addButtoSaltionSalformed(java.awt.event.ActionEvent evt) {//Sal-FIRST:event_addButtoSaltionSalformed
        // TODO add your handling code here:
    	String[] salcin= SalCinCodComboBox.getSelectedItem().toString().split(" ");

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = SalNumberTextField.getText();
        array[1] = SalAfoTextField.getText();
        array[2] = salcin[0];
        array[3] = SalEstRegTextField.getText();
        
        // Send data to the controller to add it to the model
        salListTableController.addRow(array);
    }//Sal-LAST:event_addButtoSaltionSalformed

    // Code for the delete button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // SalListTableController.java (LINE 65) and CouseListTableModel.java (LINE 149)
    private void deleteButtoSaltionSalformed(java.awt.event.ActionEvent evt) {//Sal-FIRST:event_deleteButtoSaltionSalformed
        // TODO add your handling code here:
    	String[] salcin= SalCinCodComboBox.getSelectedItem().toString().split(" ");

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = SalNumberTextField.getText();
        array[1] = SalAfoTextField.getText();
        array[2] = salcin[0];
        array[3] = SalEstRegTextField.getText();
        

        // Send data to the controller to remove it from the model
        salListTableController.deleteRow(array);
    }//Sal-LAST:event_deleteButtoSaltionSalformed
    private void exitButtoSaltionSalformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
    
    // Code for the activate button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // SalListTableController.java (LINE 66) and CouseListTableModel.java (LINE 248)
    private void actButtoSaltionSalformed(java.awt.event.ActionEvent evt) {
    	 // TODO add your handling code here:
    	String[] salcin= SalCinCodComboBox.getSelectedItem().toString().split(" ");

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = SalNumberTextField.getText();
        array[1] = SalAfoTextField.getText();
        array[2] = salcin[0];
        array[3] = SalEstRegTextField.getText();
        
        
        // Send data to the controller to activate it from the model
        salListTableController.activateRow(array);
    }//Sal-LAST:event_activateButtoSaltionSalformed
    
    // Code for the inactivate button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // SalListTableController.java (LINE 71) and CouseListTableModel.java (LINE 268)
    private void inactButtoSaltionSalformed(java.awt.event.ActionEvent evt) {
    	 // TODO add your handling code here:
    	String[] salcin= SalCinCodComboBox.getSelectedItem().toString().split(" ");

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = SalNumberTextField.getText();
        array[1] = SalAfoTextField.getText();
        array[2] = salcin[0];
        array[3] = SalEstRegTextField.getText();
        
        
        // Send data to the controller to inactivate it from the model
        salListTableController.inactivateRow(array);
    }//Sal-LAST:event_inactivateButtoSaltionSalformed
    
    private void cancelButtoSaltionSalformed(java.awt.event.ActionEvent evt) {
    	SalNumberTextField.enable();
    	SalEstRegTextField.enable();
    	SalNumberTextField.setText("");
    	SalEstRegTextField.setText("");
    }
    // Code for the update button
    private void modButtoSaltionSalformed(java.awt.event.ActionEvent evt) {
    	SalNumberTextField.disable();
    	String[] salcin= SalCinCodComboBox.getSelectedItem().toString().split(" ");

    	String[] array = new String[jtable1.getColumnCount()];
    	array[0] = SalNumberTextField.getText();
        array[1] = SalAfoTextField.getText();
        array[2] = salcin[0];
        array[3] = SalEstRegTextField.getText();
        
        salListTableController.updateRow(array, jtable1);
        
    }
    
    private void updateButtoSaltionSalformed(java.awt.event.ActionEvent evt) {//Sal-FIRST:event_updateButtoSaltionSalformed
        // TODO add your handling code here:
    	String[] salcin= SalCinCodComboBox.getSelectedItem().toString().split(" ");

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = SalNumberTextField.getText();
        array[1] = SalAfoTextField.getText();
        array[2] = salcin[0];
        array[3] = SalEstRegTextField.getText();
        
        
        // Send data to the controller to update it in the model
        salListTableController.updateRow(array, jtable1);
    }//Sal-LAST:event_updateButtoSaltionSalformed

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
            java.util.logging.Logger.getLogger(SalListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalListGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//Sal-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel SalListLabel;
    private javax.swing.JLabel SalAfoLabel;
    private javax.swing.JTextField SalAfoTextField;
    private javax.swing.JLabel SalNumberLabel;
    private javax.swing.JTextField SalNumberTextField;
    private javax.swing.JLabel SalEstRegLabel;
    private javax.swing.JTextField SalEstRegTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton modButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton inactButton;
    private javax.swing.JButton actButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel SalCinCodLabel;
    private javax.swing.JComboBox<String> SalCinCodComboBox;

    // End of variables declaration//Sal-END:variables
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
        	
            ResultSet rs1 = statement.executeQuery("SELECT CinCod, CinNom FROM cine");

            while (rs1.next()){
            	SalCinCodComboBox.addItem(rs1.getString(1)+" - "+rs1.getString(2));
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
