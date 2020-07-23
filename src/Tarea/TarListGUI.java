package Tarea;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class TarListGUI extends javax.swing.JFrame {

    private JTable jtable1; // The table displayed on the GUI
    private TarListTableController tarListTableController = null;

    public TarListGUI() {
        
        // This method creates the labels and text fields on the GUI
        initComponents();
        
        // Creates a controller for the table
        tarListTableController = new TarListTableController(this);

        // Add a table JTable to the GUI
        addJTable();

    }
    
    public void addJTable() {
        // Add the data and column names to a JTable
        jtable1 = new JTable(tarListTableController.getTableModel());
    
        // Add a ListSelectionListener to the table
        jtable1.getSelectionModel().addListSelectionListener(tarListTableController);
        
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
        jtable1.setModel(tarListTableController.getTableModel());
    }

    // Set data on the TarNameTextField
    public void setTipTarCodComboBox(String value) {
    	TipTarCodComboBox.setSelectedItem(value);
    }

    // Set data on the TarNumberTextField
    public void setTarNumberTextField(String value) { TarNumberTextField.setText(value); }
    
    // Set data on the TarEstRegTextField
    public void setTarSexCodComboBox(String value) {   TarSexCodComboBox.setSelectedItem(value); }

    public void setTarEstRegTextField(String value) { TarEstRegTextField.setText(value); }

    // Set data on the enrollmentTextField
    

    // Set data on the startDateTextField
    

    // Set data on the endDateTextField
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * reTarerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Tarerated Code">//Tar-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TipTarCodLabel = new javax.swing.JLabel();
        TarNumberLabel = new javax.swing.JLabel();
        TarEstRegLabel = new javax.swing.JLabel();
        
        TarSexCodLabel = new javax.swing.JLabel();
        TarSexCodComboBox= new javax.swing.JComboBox<String>();
        
        TipTarCodComboBox = new javax.swing.JComboBox<String>();
        TarNumberTextField = new javax.swing.JTextField();
        TarEstRegTextField = new javax.swing.JTextField();
        modButton =new javax.swing.JButton();
        actButton = new javax.swing.JButton();
        inactButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        TarListLabel = new javax.swing.JLabel();
        remplir_Jcomb();
        // Program will terminate when the window is closed
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TarNumberLabel.setText("Codigo:");
        TipTarCodLabel.setText("TipoTarea(CODIGO):");
        TarSexCodLabel.setText("Genero(CODIGO):");

        TarEstRegLabel.setText("Estado del Registro:");
        
        

        // Details for the Add button
        addButton.setText("Adicionar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtoTartionTarformed(evt);
            }
        });

        // Details for the Delete button
        deleteButton.setText("Eliminar");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtoTartionTarformed(evt);
            }
        });
        modButton.setText("Modificar");
        modButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modButtoTartionTarformed(evt);
            }
        });
        actButton.setText("Activar..");
        actButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actButtoTartionTarformed(evt);
            }
        });
        inactButton.setText("Inactivar");
        inactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inactButtoTartionTarformed(evt);
            }
        });
        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtoTartionTarformed(evt);
            }
        });
        exitButton.setText("Salir");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtoTartionTarformed(evt);
            }
        });
        // Details for the Update button
        updateButton.setText("Actualizar");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtoTartionTarformed(evt);
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
                    .addComponent(TarNumberLabel))
                .addGap(147, 147, 147)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TarNumberTextField))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TipTarCodLabel)
                    .addGap(148, 148, 148)
                    .addComponent(TipTarCodComboBox)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TarSexCodLabel)
                    .addGap(148, 148, 148)
                    .addComponent(TarSexCodComboBox)
                    .addContainerGap())
            
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TarEstRegLabel)
                    .addGap(148, 148, 148)
                    .addComponent(TarEstRegTextField)
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
                    .addComponent(TarNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TarNumberLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TipTarCodLabel)
                        .addComponent(TipTarCodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TarSexCodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TarSexCodLabel))
                        .addGap(18, 18, 18)  
               
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TarEstRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TarEstRegLabel))
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

        TarListLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        TarListLabel.setText("Tareas");

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
                        .addComponent(TarListLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TarListLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//Tar-END:initComponents

    // Code for the add button
    private void addButtoTartionTarformed(java.awt.event.ActionEvent evt) {//Tar-FIRST:event_addButtoTartionTarformed
        // TODO add your handling code here:
    	String[] tiptar= TipTarCodComboBox.getSelectedItem().toString().split(" ");
    	String[] tarsex= TarSexCodComboBox.getSelectedItem().toString().split(" ");
        String[] array = new String[jtable1.getColumnCount()];
        array[0] = TarNumberTextField.getText();
        array[1] = tiptar[0];
        array[2] = tarsex[0];
        array[3] = TarEstRegTextField.getText();
        
        // Send data to the controller to add it to the model
        tarListTableController.addRow(array);
    }//Tar-LAST:event_addButtoTartionTarformed

    // Code for the delete button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // TarListTableController.java (LINE 65) and CouseListTableModel.java (LINE 149)
    private void deleteButtoTartionTarformed(java.awt.event.ActionEvent evt) {//Tar-FIRST:event_deleteButtoTartionTarformed
        // TODO add your handling code here:
    	String[] tiptar= TipTarCodComboBox.getSelectedItem().toString().split(" ");
    	String[] tarsex= TarSexCodComboBox.getSelectedItem().toString().split(" ");
        String[] array = new String[jtable1.getColumnCount()];
        array[0] = TarNumberTextField.getText();
        array[1] = tiptar[0];
        array[2] = tarsex[0];
        array[3] = TarEstRegTextField.getText();
        

        // Send data to the controller to remove it from the model
        tarListTableController.deleteRow(array);
    }//Tar-LAST:event_deleteButtoTartionTarformed
    private void exitButtoTartionTarformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
    
    // Code for the activate button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // TarListTableController.java (LINE 66) and CouseListTableModel.java (LINE 248)
    private void actButtoTartionTarformed(java.awt.event.ActionEvent evt) {
    	 // TODO add your handling code here:
    	String[] tiptar= TipTarCodComboBox.getSelectedItem().toString().split(" ");
    	String[] tarsex= TarSexCodComboBox.getSelectedItem().toString().split(" ");
        String[] array = new String[jtable1.getColumnCount()];
        array[0] = TarNumberTextField.getText();
        array[1] = tiptar[0];
        array[2] = tarsex[0];
        array[3] = TarEstRegTextField.getText();
        
        
        // Send data to the controller to activate it from the model
        tarListTableController.activateRow(array);
    }//Tar-LAST:event_activateButtoTartionTarformed
    
    // Code for the inactivate button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // TarListTableController.java (LINE 71) and CouseListTableModel.java (LINE 268)
    private void inactButtoTartionTarformed(java.awt.event.ActionEvent evt) {
    	 // TODO add your handling code here:
    	String[] tiptar= TipTarCodComboBox.getSelectedItem().toString().split(" ");
    	String[] tarsex= TarSexCodComboBox.getSelectedItem().toString().split(" ");
        String[] array = new String[jtable1.getColumnCount()];
        array[0] = TarNumberTextField.getText();
        array[1] = tiptar[0];
        array[2] = tarsex[0];
        array[3] = TarEstRegTextField.getText();
        
        
        // Send data to the controller to inactivate it from the model
        tarListTableController.inactivateRow(array);
    }//Tar-LAST:event_inactivateButtoTartionTarformed
    
    private void cancelButtoTartionTarformed(java.awt.event.ActionEvent evt) {
    	TarNumberTextField.enable();
    	TarEstRegTextField.enable();
    	TarNumberTextField.setText("");
    	TarEstRegTextField.setText("");
    }
    // Code for the update button
    private void modButtoTartionTarformed(java.awt.event.ActionEvent evt) {
    	TarNumberTextField.disable();
    	String[] tiptar= TipTarCodComboBox.getSelectedItem().toString().split(" ");
    	String[] tarsex= TarSexCodComboBox.getSelectedItem().toString().split(" ");
        String[] array = new String[jtable1.getColumnCount()];
        array[0] = TarNumberTextField.getText();
        array[1] = tiptar[0];
        array[2] = tarsex[0];
        array[3] = TarEstRegTextField.getText();
        
        tarListTableController.updateRow(array, jtable1);
        
    }
    
    private void updateButtoTartionTarformed(java.awt.event.ActionEvent evt) {//Tar-FIRST:event_updateButtoTartionTarformed
        // TODO add your handling code here:
    	String[] tiptar= TipTarCodComboBox.getSelectedItem().toString().split(" ");
    	String[] tarsex= TarSexCodComboBox.getSelectedItem().toString().split(" ");
        String[] array = new String[jtable1.getColumnCount()];
        array[0] = TarNumberTextField.getText();
        array[1] = tiptar[0];
        array[2] = tarsex[0];
        array[3] = TarEstRegTextField.getText();
        
        
        // Send data to the controller to update it in the model
        tarListTableController.updateRow(array, jtable1);
    }//Tar-LAST:event_updateButtoTartionTarformed

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
            java.util.logging.Logger.getLogger(TarListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TarListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TarListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TarListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TarListGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//Tar-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel TarListLabel;
    private javax.swing.JLabel TipTarCodLabel;
    private javax.swing.JComboBox<String> TipTarCodComboBox;
    private javax.swing.JLabel TarNumberLabel;
    private javax.swing.JTextField TarNumberTextField;
    private javax.swing.JLabel TarEstRegLabel;
    private javax.swing.JTextField TarEstRegTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton modButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton inactButton;
    private javax.swing.JButton actButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel TarSexCodLabel;
    private javax.swing.JComboBox<String> TarSexCodComboBox;
    // End of variables declaration//Tar-END:variables
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
        	
            ResultSet rs1 = statement.executeQuery("SELECT TipTarCod, TipTarDes FROM tipo_tarea");

            while (rs1.next()){
            	TipTarCodComboBox.addItem(rs1.getString(1)+" - "+rs1.getString(2));
            }
            
            ResultSet rs2 = statement.executeQuery("SELECT SexCod, SexNom FROM sexo");
            while (rs2.next()){
            	TarSexCodComboBox.addItem(rs2.getString(1)+" - "+rs2.getString(2));
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
