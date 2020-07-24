package Trabajo;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class TraListGUI extends javax.swing.JFrame {

    private JTable jtable1; // The table displayed on the GUI
    private TraListTableController traListTableController = null;

    public TraListGUI() {
        
        // This method creates the labels and text fields on the GUI
        initComponents();
        
        // Creates a controller for the table
        traListTableController = new TraListTableController(this);

        // Add a table JTable to the GUI
        addJTable();

    }
    
    public void addJTable() {
        // Add the data and column names to a JTable
        jtable1 = new JTable(traListTableController.getTableModel());
    
        // Add a ListSelectionListener to the table
        jtable1.getSelectionModel().addListSelectionListener(traListTableController);
        
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
        jtable1.setModel(traListTableController.getTableModel());
    }

    // Set data on the TraNameTextField
    public void setTraTarCodComboBox(String name) {
    	TraTarCodComboBox.setSelectedItem(name);
    }

    // Set data on the TraNumberTextField
    public void setTraNumberTextField(String value) { TraNumberTextField.setText(value); }
    
    // Set data on the TraEstRegTextField
    public void setTraSexCodComboBox(String value) { TraTarCodComboBox.setSelectedItem(value); }
    public void setTraPerCodComboBox(String value) { TraPerCodComboBox.setSelectedItem(value);  }
    public void setTraPelCodComboBox(String value) { TraPelCodComboBox.setSelectedItem(value); }

    public void setTraEstRegTextField(String value) { TraEstRegTextField.setText(value); }

    // Set data on the enrollmentTextField
    

    // Set data on the sTratDateTextField
    

    // Set data on the endDateTextField
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * reTraerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Traerated Code">//Tra-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TraTarCodLabel = new javax.swing.JLabel();
        TraNumberLabel = new javax.swing.JLabel();
        TraEstRegLabel = new javax.swing.JLabel();
        
        TraPerCodLabel = new javax.swing.JLabel();
        TraPerCodComboBox = new javax.swing.JComboBox<String>();
        TraPelCodLabel = new javax.swing.JLabel();
        TraPelCodComboBox = new javax.swing.JComboBox<String>();
        TraTarCodComboBox = new javax.swing.JComboBox<String>();
        TraNumberTextField = new javax.swing.JTextField();
        TraEstRegTextField = new javax.swing.JTextField();
        modButton =new javax.swing.JButton();
        actButton = new javax.swing.JButton();
        inactButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        TraListLabel = new javax.swing.JLabel();
        remplir_Jcomb();
        // Program will terminate when the window is closed
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TraNumberLabel.setText("Codigo:");
        TraTarCodLabel.setText("TrabajoTarea(CODIGO):");
        TraPerCodLabel.setText("TrabajoPersona(CODIGO):");
        TraPelCodLabel.setText("TrabajoPelicula(CODIGO):");

        TraEstRegLabel.setText("Estado del Registro:");
        
        

        // Details for the Add button
        addButton.setText("Adicionar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtoTrationTraformed(evt);
            }
        });

        // Details for the Delete button
        deleteButton.setText("Eliminar");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtoTrationTraformed(evt);
            }
        });
        modButton.setText("Modificar");
        modButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modButtoTrationTraformed(evt);
            }
        });
        actButton.setText("Activar..");
        actButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actButtoTrationTraformed(evt);
            }
        });
        inactButton.setText("Inactivar");
        inactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inactButtoTrationTraformed(evt);
            }
        });
        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtoTrationTraformed(evt);
            }
        });
        exitButton.setText("Salir");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtoTrationTraformed(evt);
            }
        });
        // Details for the Update button
        updateButton.setText("Actualizar");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtoTrationTraformed(evt);
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
                    .addComponent(TraNumberLabel))
                .addGap(147, 147, 147)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TraNumberTextField))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TraTarCodLabel)
                    .addGap(148, 148, 148)
                    .addComponent(TraTarCodComboBox)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TraPerCodLabel)
                    .addGap(148, 148, 148)
                    .addComponent(TraPerCodComboBox)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TraPelCodLabel)
                    .addGap(148, 148, 148)
                    .addComponent(TraPelCodComboBox)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TraEstRegLabel)
                    .addGap(148, 148, 148)
                    .addComponent(TraEstRegTextField)
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
                    .addComponent(TraNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TraNumberLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TraTarCodLabel)
                        .addComponent(TraTarCodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TraPerCodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TraPerCodLabel))
                        .addGap(18, 18, 18)  
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                       .addComponent(TraPelCodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addComponent(TraPelCodLabel))
                   .addGap(18, 18, 18) 
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TraEstRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TraEstRegLabel))
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

        TraListLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        TraListLabel.setText("Tareas");

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
                        .addComponent(TraListLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TraListLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//Tra-END:initComponents

    // Code for the add button
    private void addButtoTrationTraformed(java.awt.event.ActionEvent evt) {//Tra-FIRST:event_addButtoTrationTraformed
        // TODO add your handling code here:
    	String[] tratar= TraTarCodComboBox.getSelectedItem().toString().split(" ");
    	String[] traper= TraPerCodComboBox.getSelectedItem().toString().split(" ");
    	String[] trapel= TraPelCodComboBox.getSelectedItem().toString().split(" ");


        String[] array = new String[jtable1.getColumnCount()];
        array[0] = TraNumberTextField.getText();
        array[1] = tratar[0];
        array[2] = traper[0];
        array[3] = trapel[0];
        array[4] = returnQuery("personaje","PerCod","PerNacCod",array[2]);
        array[5] = returnQuery("pelicula","PelCod","PelNacCod",array[3]);
        array[6] = returnQuery("personaje","PerCod","PerSexCod",array[2]);
        array[7] = TraEstRegTextField.getText();
        
        // Send data to the controller to add it to the model
        traListTableController.addRow(array);
    }//Tra-LAST:event_addButtoTrationTraformed

    // Code for the delete button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // TraListTableController.java (LINE 65) and CouseListTableModel.java (LINE 149)
    private void deleteButtoTrationTraformed(java.awt.event.ActionEvent evt) {//Tra-FIRST:event_deleteButtoTrationTraformed
        // TODO add your handling code here:
    	String[] tratar= TraTarCodComboBox.getSelectedItem().toString().split(" ");
    	String[] traper= TraPerCodComboBox.getSelectedItem().toString().split(" ");
    	String[] trapel= TraPelCodComboBox.getSelectedItem().toString().split(" ");


        String[] array = new String[jtable1.getColumnCount()];
        array[0] = TraNumberTextField.getText();
        array[1] = tratar[0];
        array[2] = traper[0];
        array[3] = trapel[0];
        array[4] = returnQuery("personaje","PerCod","PerNacCod",array[2]);
        array[5] = returnQuery("pelicula","PelCod","PelNacCod",array[3]);
        array[6] = returnQuery("personaje","PerCod","PerSexCod",array[2]);
        array[7] = TraEstRegTextField.getText();
        

        // Send data to the controller to remove it from the model
        traListTableController.deleteRow(array);
    }//Tra-LAST:event_deleteButtoTrationTraformed
    private void exitButtoTrationTraformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
    
    // Code for the activate button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // TraListTableController.java (LINE 66) and CouseListTableModel.java (LINE 248)
    private void actButtoTrationTraformed(java.awt.event.ActionEvent evt) {
    	 // TODO add your handling code here:
    	String[] tratar= TraTarCodComboBox.getSelectedItem().toString().split(" ");
    	String[] traper= TraPerCodComboBox.getSelectedItem().toString().split(" ");
    	String[] trapel= TraPelCodComboBox.getSelectedItem().toString().split(" ");


        String[] array = new String[jtable1.getColumnCount()];
        array[0] = TraNumberTextField.getText();
        array[1] = tratar[0];
        array[2] = traper[0];
        array[3] = trapel[0];
        array[4] = returnQuery("personaje","PerCod","PerNacCod",array[2]);
        array[5] = returnQuery("pelicula","PelCod","PelNacCod",array[3]);
        array[6] = returnQuery("personaje","PerCod","PerSexCod",array[2]);
        array[7] = TraEstRegTextField.getText();
        
        
        // Send data to the controller to activate it from the model
        traListTableController.activateRow(array);
    }//Tra-LAST:event_activateButtoTrationTraformed
    
    // Code for the inactivate button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // TraListTableController.java (LINE 71) and CouseListTableModel.java (LINE 268)
    private void inactButtoTrationTraformed(java.awt.event.ActionEvent evt) {
    	 // TODO add your handling code here:
    	String[] tratar= TraTarCodComboBox.getSelectedItem().toString().split(" ");
    	String[] traper= TraPerCodComboBox.getSelectedItem().toString().split(" ");
    	String[] trapel= TraPelCodComboBox.getSelectedItem().toString().split(" ");


        String[] array = new String[jtable1.getColumnCount()];
        array[0] = TraNumberTextField.getText();
        array[1] = tratar[0];
        array[2] = traper[0];
        array[3] = trapel[0];
        array[4] = returnQuery("personaje","PerCod","PerNacCod",array[2]);
        array[5] = returnQuery("pelicula","PelCod","PelNacCod",array[3]);
        array[6] = returnQuery("personaje","PerCod","PerSexCod",array[2]);
        array[7] = TraEstRegTextField.getText();
        
        
        // Send data to the controller to inactivate it from the model
        traListTableController.inactivateRow(array);
    }//Tra-LAST:event_inactivateButtoTrationTraformed
    
    private void cancelButtoTrationTraformed(java.awt.event.ActionEvent evt) {
    	TraNumberTextField.enable();
    	TraEstRegTextField.enable();
    	TraNumberTextField.setText("");
    	TraEstRegTextField.setText("");
    }
    // Code for the update button
    private void modButtoTrationTraformed(java.awt.event.ActionEvent evt) {
    	TraNumberTextField.disable();
    	String[] tratar= TraTarCodComboBox.getSelectedItem().toString().split(" ");
    	String[] traper= TraPerCodComboBox.getSelectedItem().toString().split(" ");
    	String[] trapel= TraPelCodComboBox.getSelectedItem().toString().split(" ");


        String[] array = new String[jtable1.getColumnCount()];
        array[0] = TraNumberTextField.getText();
        array[1] = tratar[0];
        array[2] = traper[0];
        array[3] = trapel[0];
        array[4] = returnQuery("personaje","PerCod","PerNacCod",array[2]);
        array[5] = returnQuery("pelicula","PelCod","PelNacCod",array[3]);
        array[6] = returnQuery("personaje","PerCod","PerSexCod",array[2]);
        array[7] = TraEstRegTextField.getText();
        
        traListTableController.updateRow(array, jtable1);
        
    }
    
    private void updateButtoTrationTraformed(java.awt.event.ActionEvent evt) {//Tra-FIRST:event_updateButtoTrationTraformed
        // TODO add your handling code here:
    	String[] tratar= TraTarCodComboBox.getSelectedItem().toString().split(" ");
    	String[] traper= TraPerCodComboBox.getSelectedItem().toString().split(" ");
    	String[] trapel= TraPelCodComboBox.getSelectedItem().toString().split(" ");


        String[] array = new String[jtable1.getColumnCount()];
        array[0] = TraNumberTextField.getText();
        array[1] = tratar[0];
        array[2] = traper[0];
        array[3] = trapel[0];
        array[4] = returnQuery("personaje","PerCod","PerNacCod",array[2]);
        array[5] = returnQuery("pelicula","PelCod","PelNacCod",array[3]);
        array[6] = returnQuery("personaje","PerCod","PerSexCod",array[2]);
        array[7] = TraEstRegTextField.getText();
        
        
        // Send data to the controller to update it in the model
        traListTableController.updateRow(array, jtable1);
    }//Tra-LAST:event_updateButtoTrationTraformed

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
            java.util.logging.Logger.getLogger(TraListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TraListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TraListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TraListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TraListGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//Tra-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel TraListLabel;
    private javax.swing.JLabel TraTarCodLabel;
    private javax.swing.JComboBox<String> TraTarCodComboBox;
    private javax.swing.JLabel TraNumberLabel;
    private javax.swing.JTextField TraNumberTextField;
    private javax.swing.JLabel TraEstRegLabel;
    private javax.swing.JTextField TraEstRegTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton modButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton inactButton;
    private javax.swing.JButton actButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel TraPerCodLabel;
    private javax.swing.JComboBox<String> TraPerCodComboBox;
    private javax.swing.JLabel TraPelCodLabel;
    private javax.swing.JComboBox<String> TraPelCodComboBox;
    
    // End of variables declaration//Tra-END:variables
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
            	TraTarCodComboBox.addItem(rs1.getString(1)+" - "+"tarea");
            }
            
            ResultSet rs2 = statement.executeQuery("SELECT PerCod, PerNom FROM personaje");
            while (rs2.next()){
            	TraPerCodComboBox.addItem(rs2.getString(1)+" - "+rs2.getString(2));
            }
            ResultSet rs3 = statement.executeQuery("SELECT PelCod, PelTitEsp FROM pelicula");
            while (rs3.next()){
            	TraPelCodComboBox.addItem(rs3.getString(1)+" - "+rs3.getString(2));
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
