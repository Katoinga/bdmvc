package Proyeccion;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class ProListGUI extends javax.swing.JFrame {

    private JTable jtable1; // The table displayed on the GUI
    private ProListTableController ProListTableController = null;

    public ProListGUI() {
        
        // This method creates the labels and text fields on the GUI
        initComponents();
        
        // Creates a controller for the table
        ProListTableController = new ProListTableController(this);

        // Add a table JTable to the GUI
        addJTable();

    }
    
    public void addJTable() {
        // Add the data and column names to a JTable
        jtable1 = new JTable(ProListTableController.getTableModel());
    
        // Add a ListSelectionListener to the table
        jtable1.getSelectionModel().addListSelectionListener(ProListTableController);
        
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
        jtable1.setModel(ProListTableController.getTableModel());
    }

    // Set data on the ProNameTextField
    

    // Set data on the ProNumberTextField
    public void setProNumberTextField(String value) { ProNumberTextField.setText(value); }
    public void setProFecEstATextField(String value) { ProFecEstATextField.setText(value); }
    public void setProFecEstMTextField(String value) { ProFecEstMTextField.setText(value); }
    public void setProFecEstDTextField(String value) { ProFecEstDTextField.setText(value); }
    public void setProDiaEstTextField(String value) { ProDiaEstTextField.setText(value); }
    public void setProEspTextField(String value) { ProEspTextField.setText(value); }
    public void setProRecTextField(String value) { ProRecTextField.setText(value); }
    public void setProCinCodComboBox(String value) { ProCinCodComboBox.setSelectedItem(value); }
    public void setProSalCodComboBox(String value) { ProSalCodComboBox.setSelectedItem(value); }
    public void setProPelCodComboBox(String value) { ProPelCodComboBox.setSelectedItem(value); }
    public void setProPelNacCodComboBox(String value) { ProPelNacCodComboBox.setSelectedItem(value); }

    // Set data on the ProEstRegTextField
    
    public void setProEstRegTextField(String value) { ProEstRegTextField.setText(value); }

    // Set data on the enrollmentTextField
    

    // Set data on the startDateTextField
    

    // Set data on the endDateTextField
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * reProerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Proerated Code">//Pro-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ProNumberLabel = new javax.swing.JLabel();
        ProEstRegLabel = new javax.swing.JLabel();
        ProFecEstALabel = new javax.swing.JLabel();
        ProFecEstATextField = new javax.swing.JTextField();
        ProFecEstMLabel = new javax.swing.JLabel();
        ProFecEstMTextField = new javax.swing.JTextField();
        ProFecEstDLabel = new javax.swing.JLabel();
        ProFecEstDTextField = new javax.swing.JTextField();
        ProDiaEstLabel = new javax.swing.JLabel();
        ProDiaEstTextField = new javax.swing.JTextField();
        ProEspLabel = new javax.swing.JLabel();
        ProEspTextField = new javax.swing.JTextField();
        ProRecLabel = new javax.swing.JLabel();
        ProRecTextField = new javax.swing.JTextField();
        ProCinCodLabel = new javax.swing.JLabel();
        ProCinCodComboBox = new javax.swing.JComboBox<String>();
        ProSalCodLabel = new javax.swing.JLabel();
        ProSalCodComboBox= new javax.swing.JComboBox<String>();
        ProPelCodLabel = new javax.swing.JLabel();
        ProPelCodComboBox = new javax.swing.JComboBox<String>();
        ProPelNacCodLabel = new javax.swing.JLabel();
        ProPelNacCodComboBox = new javax.swing.JComboBox<String>();
        ProNumberTextField = new javax.swing.JTextField();
        ProEstRegTextField = new javax.swing.JTextField();
        modButton =new javax.swing.JButton();
        actButton = new javax.swing.JButton();
        inactButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        ProListLabel = new javax.swing.JLabel();
        remplir_Jcomb();
        // Program will terminate when the window is closed
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ProNumberLabel.setText("Codigo:");
        ProFecEstALabel.setText("Fecha de estreno anyo:");
        ProFecEstMLabel.setText("Fecha de estreno mes:");
        ProFecEstDLabel.setText("Fecha de estreno dia:");
        ProDiaEstLabel.setText("Dias de estreno(duracion):");
        ProEspLabel.setText("Espectadores:");
        ProRecLabel.setText("Recaudacion:");
        ProCinCodLabel.setText("Cine(CODIGO):");
        ProSalCodLabel.setText("Sala(CODIGO):");
        ProPelCodLabel.setText("Pelicula(CODIGO):");
        ProPelNacCodLabel.setText("Pelicula Nacionalidad(CODIGO):");

        ProEstRegLabel.setText("Estado del Registro:");
        
        

        // Details for the Add button
        addButton.setText("Adicionar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtoProtionProformed(evt);
            }
        });

        // Details for the Delete button
        deleteButton.setText("Eliminar");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtoProtionProformed(evt);
            }
        });
        modButton.setText("Modificar");
        modButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modButtoProtionProformed(evt);
            }
        });
        actButton.setText("Activar..");
        actButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actButtoProtionProformed(evt);
            }
        });
        inactButton.setText("Inactivar");
        inactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inactButtoProtionProformed(evt);
            }
        });
        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtoProtionProformed(evt);
            }
        });
        exitButton.setText("Salir");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtoProtionProformed(evt);
            }
        });
        // Details for the Update button
        updateButton.setText("Actualizar");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtoProtionProformed(evt);
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
                    .addComponent(ProNumberLabel))
                .addGap(147, 147, 147)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ProNumberTextField))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ProFecEstALabel)
                    .addGap(148, 148, 148)
                    .addComponent(ProFecEstATextField)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ProFecEstMLabel)
                    .addGap(148, 148, 148)
                    .addComponent(ProFecEstMTextField)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ProFecEstDLabel)
                    .addGap(148, 148, 148)
                    .addComponent(ProFecEstDTextField)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ProDiaEstLabel)
                    .addGap(148, 148, 148)
                    .addComponent(ProDiaEstTextField)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ProEspLabel)
                    .addGap(148, 148, 148)
                    .addComponent(ProEspTextField)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ProRecLabel)
                    .addGap(148, 148, 148)
                    .addComponent(ProRecTextField)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ProCinCodLabel)
                    .addGap(148, 148, 148)
                    .addComponent(ProCinCodComboBox)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ProSalCodLabel)
                    .addGap(148, 148, 148)
                    .addComponent(ProSalCodComboBox)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ProPelCodLabel)
                    .addGap(148, 148, 148)
                    .addComponent(ProPelCodComboBox)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ProPelNacCodLabel)
                    .addGap(148, 148, 148)
                    .addComponent(ProPelNacCodComboBox)
                    .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ProEstRegLabel)
                    .addGap(148, 148, 148)
                    .addComponent(ProEstRegTextField)
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
                    .addComponent(ProNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProNumberLabel))
                .addGap(18, 18, 18)
                
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ProFecEstATextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ProFecEstALabel))
                    .addGap(18, 18, 18)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ProFecEstMTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ProFecEstMLabel))
                        .addGap(18, 18, 18) 
                  
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ProFecEstDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ProFecEstDLabel))
                            .addGap(18, 18, 18)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ProDiaEstTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ProDiaEstLabel))
                                .addGap(18, 18, 18)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(ProEspTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(ProEspLabel))
                     .addGap(18, 18, 18)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(ProRecTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(ProRecLabel))
                     .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ProCinCodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ProCinCodLabel))
                    .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ProSalCodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ProSalCodLabel))
                    .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ProPelCodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ProPelCodLabel))
                    .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ProPelNacCodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ProPelNacCodLabel))
                    .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ProEstRegTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ProEstRegLabel))
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

        ProListLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        ProListLabel.setText("Prosonajes");

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
                        .addComponent(ProListLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ProListLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//Pro-END:initComponents

    // Code for the add button
    private void addButtoProtionProformed(java.awt.event.ActionEvent evt) {//Pro-FIRST:event_addButtoProtionProformed
        // TODO add your handling code here:
    	String[] procin= ProCinCodComboBox.getSelectedItem().toString().split(" ");
    	String[] prosal= ProSalCodComboBox.getSelectedItem().toString().split(" ");
    	String[] propel= ProPelCodComboBox.getSelectedItem().toString().split(" ");
    	String[] pronac= ProPelNacCodComboBox.getSelectedItem().toString().split(" ");

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = ProNumberTextField.getText();
        array[1] = ProFecEstATextField.getText();
        array[2] = ProFecEstMTextField.getText();
        array[3] = ProFecEstDTextField.getText();
        array[4] = ProDiaEstTextField.getText();
        array[5] = ProEspTextField.getText();
        array[6] = ProRecTextField.getText();
        array[7] = procin[0];
        array[8] = prosal[0];
        array[9] = propel[0];
        array[10] = pronac[0];
        array[11] = ProEstRegTextField.getText();

        
        // Send data to the controller to add it to the model
        ProListTableController.addRow(array);
    }//Pro-LAST:event_addButtoProtionProformed

    // Code for the delete button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // ProListTableController.java (LINE 65) and CouseListTableModel.java (LINE 149)
    private void deleteButtoProtionProformed(java.awt.event.ActionEvent evt) {//Pro-FIRST:event_deleteButtoProtionProformed
        // TODO add your handling code here:
    	String[] procin= ProCinCodComboBox.getSelectedItem().toString().split(" ");
    	String[] prosal= ProSalCodComboBox.getSelectedItem().toString().split(" ");
    	String[] propel= ProPelCodComboBox.getSelectedItem().toString().split(" ");
    	String[] pronac= ProPelNacCodComboBox.getSelectedItem().toString().split(" ");

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = ProNumberTextField.getText();
        array[1] = ProFecEstATextField.getText();
        array[2] = ProFecEstMTextField.getText();
        array[3] = ProFecEstDTextField.getText();
        array[4] = ProDiaEstTextField.getText();
        array[5] = ProEspTextField.getText();
        array[6] = ProRecTextField.getText();
        array[7] = procin[0];
        array[8] = prosal[0];
        array[9] = propel[0];
        array[10] = pronac[0];
        array[11] = ProEstRegTextField.getText();
        // Send data to the controller to remove it from the model
        ProListTableController.deleteRow(array);
    }//Pro-LAST:event_deleteButtoProtionProformed
    private void exitButtoProtionProformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
    
    // Code for the activate button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // ProListTableController.java (LINE 66) and CouseListTableModel.java (LINE 248)
    private void actButtoProtionProformed(java.awt.event.ActionEvent evt) {
    	 // TODO add your handling code here:
    	String[] procin= ProCinCodComboBox.getSelectedItem().toString().split(" ");
    	String[] prosal= ProSalCodComboBox.getSelectedItem().toString().split(" ");
    	String[] propel= ProPelCodComboBox.getSelectedItem().toString().split(" ");
    	String[] pronac= ProPelNacCodComboBox.getSelectedItem().toString().split(" ");

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = ProNumberTextField.getText();
        array[1] = ProFecEstATextField.getText();
        array[2] = ProFecEstMTextField.getText();
        array[3] = ProFecEstDTextField.getText();
        array[4] = ProDiaEstTextField.getText();
        array[5] = ProEspTextField.getText();
        array[6] = ProRecTextField.getText();
        array[7] = procin[0];
        array[8] = prosal[0];
        array[9] = propel[0];
        array[10] = pronac[0];
        array[11] = ProEstRegTextField.getText();
        
        // Send data to the controller to activate it from the model
        ProListTableController.activateRow(array);
    }//Pro-LAST:event_activateButtoProtionProformed
    
    // Code for the inactivate button
    // NEED TO FINISH MAKING THIS. SEE addRow() METHODS IN
    // ProListTableController.java (LINE 71) and CouseListTableModel.java (LINE 268)
    private void inactButtoProtionProformed(java.awt.event.ActionEvent evt) {
    	 // TODO add your handling code here:
    	String[] procin= ProCinCodComboBox.getSelectedItem().toString().split(" ");
    	String[] prosal= ProSalCodComboBox.getSelectedItem().toString().split(" ");
    	String[] propel= ProPelCodComboBox.getSelectedItem().toString().split(" ");
    	String[] pronac= ProPelNacCodComboBox.getSelectedItem().toString().split(" ");

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = ProNumberTextField.getText();
        array[1] = ProFecEstATextField.getText();
        array[2] = ProFecEstMTextField.getText();
        array[3] = ProFecEstDTextField.getText();
        array[4] = ProDiaEstTextField.getText();
        array[5] = ProEspTextField.getText();
        array[6] = ProRecTextField.getText();
        array[7] = procin[0];
        array[8] = prosal[0];
        array[9] = propel[0];
        array[10] = pronac[0];
        array[11] = ProEstRegTextField.getText();
        // Send data to the controller to inactivate it from the model
        ProListTableController.inactivateRow(array);
    }//Pro-LAST:event_inactivateButtoProtionProformed
    
    private void cancelButtoProtionProformed(java.awt.event.ActionEvent evt) {
    	ProNumberTextField.enable();
    	
    	ProEstRegTextField.enable();
    	
    	ProNumberTextField.setText("");
    	ProEstRegTextField.setText("");
    }
    // Code for the update button
    private void modButtoProtionProformed(java.awt.event.ActionEvent evt) {
    	ProNumberTextField.disable();
    	String[] procin= ProCinCodComboBox.getSelectedItem().toString().split(" ");
    	String[] prosal= ProSalCodComboBox.getSelectedItem().toString().split(" ");
    	String[] propel= ProPelCodComboBox.getSelectedItem().toString().split(" ");
    	String[] pronac= ProPelNacCodComboBox.getSelectedItem().toString().split(" ");

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = ProNumberTextField.getText();
        array[1] = ProFecEstATextField.getText();
        array[2] = ProFecEstMTextField.getText();
        array[3] = ProFecEstDTextField.getText();
        array[4] = ProDiaEstTextField.getText();
        array[5] = ProEspTextField.getText();
        array[6] = ProRecTextField.getText();
        array[7] = procin[0];
        array[8] = prosal[0];
        array[9] = propel[0];
        array[10] = pronac[0];
        array[11] = ProEstRegTextField.getText();
        ProListTableController.updateRow(array, jtable1);
        
    }
    
    private void updateButtoProtionProformed(java.awt.event.ActionEvent evt) {//Pro-FIRST:event_updateButtoProtionProformed
        // TODO add your handling code here:
    	String[] procin= ProCinCodComboBox.getSelectedItem().toString().split(" ");
    	String[] prosal= ProSalCodComboBox.getSelectedItem().toString().split(" ");
    	String[] propel= ProPelCodComboBox.getSelectedItem().toString().split(" ");
    	String[] pronac= ProPelNacCodComboBox.getSelectedItem().toString().split(" ");

        String[] array = new String[jtable1.getColumnCount()];
        array[0] = ProNumberTextField.getText();
        array[1] = ProFecEstATextField.getText();
        array[2] = ProFecEstMTextField.getText();
        array[3] = ProFecEstDTextField.getText();
        array[4] = ProDiaEstTextField.getText();
        array[5] = ProEspTextField.getText();
        array[6] = ProRecTextField.getText();
        array[7] = procin[0];
        array[8] = prosal[0];
        array[9] = propel[0];
        array[10] = pronac[0];
        array[11] = ProEstRegTextField.getText();
        
        // Send data to the controller to update it in the model
        ProListTableController.updateRow(array, jtable1);
    }//Pro-LAST:event_updateButtoProtionProformed

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
            java.util.logging.Logger.getLogger(ProListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProListGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//Pro-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel ProListLabel;
    private javax.swing.JLabel ProNumberLabel;
    private javax.swing.JTextField ProNumberTextField;
    private javax.swing.JLabel ProEstRegLabel;
    private javax.swing.JTextField ProEstRegTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton modButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton inactButton;
    private javax.swing.JButton actButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel ProFecEstALabel;
    private javax.swing.JTextField ProFecEstATextField;
    private javax.swing.JLabel ProFecEstMLabel;
    private javax.swing.JTextField ProFecEstMTextField;
    private javax.swing.JLabel ProFecEstDLabel;
    private javax.swing.JTextField ProFecEstDTextField;
    private javax.swing.JLabel ProDiaEstLabel;
    private javax.swing.JTextField ProDiaEstTextField;
    private javax.swing.JLabel ProEspLabel;
    private javax.swing.JTextField ProEspTextField;
    private javax.swing.JLabel ProRecLabel;
    private javax.swing.JTextField ProRecTextField;
    private javax.swing.JLabel ProCinCodLabel;
    private javax.swing.JComboBox<String> ProCinCodComboBox;
    private javax.swing.JLabel ProSalCodLabel;
    private javax.swing.JComboBox<String> ProSalCodComboBox;
    private javax.swing.JLabel ProPelCodLabel;
    private javax.swing.JComboBox<String> ProPelCodComboBox;
    private javax.swing.JLabel ProPelNacCodLabel;
    private javax.swing.JComboBox<String> ProPelNacCodComboBox;
     // End of variables declaration//Pro-END:variables
    
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
        	
            ResultSet rs1 = statement.executeQuery("SELECT CinCod, CinNom FROM cine");

            while (rs1.next()){
            	ProCinCodComboBox.addItem(rs1.getString(1)+" - "+rs1.getString(2));
            }
            
            ResultSet rs2 = statement.executeQuery("SELECT SalCod, SalAfo FROM sala");
            while (rs2.next()){
            	ProSalCodComboBox.addItem(rs2.getString(1)+" - Aforo:"+rs2.getString(2));
            }
            ResultSet rs3 = statement.executeQuery("SELECT PelCod, PelTitEsp FROM pelicula");
            while (rs3.next()){
            	ProPelCodComboBox.addItem(rs3.getString(1)+" - Titulo:"+rs3.getString(2));
            }
            ResultSet rs4 = statement.executeQuery("SELECT NacCod, NacDes FROM nacionalidad");

            while (rs4.next()){
            	ProPelNacCodComboBox.addItem(rs4.getString(1)+" - "+rs4.getString(2));
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
