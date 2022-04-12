/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import TableModels.PrescriptionTableModel;
import entity.Patient;
import entity.PatientService;
import entity.Prescription;
import java.awt.Font;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import services.CommonServices;

/**
 *
 * @author Suhail Alam
 */
public class PatientHistoryForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form PatientHistory
     */
    private CommonServices commonServices;
    private PatientService patientService;
    private Vector<Patient> vectorPatients;

    public PatientHistoryForm() {
        initComponents();
       
        commonServices = new CommonServices();
        patientService = new PatientService();
        vectorPatients = commonServices.getVectorPatients();
       
        DefaultComboBoxModel modelPatients = new DefaultComboBoxModel(vectorPatients);
        cmbSelectPatient.setModel(modelPatients);
        
    } 
       /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSearchPatient = new javax.swing.JTextField();
        cmbSelectPatient = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPatientHistory = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Patient history form");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Search Patient");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Select patient");

        txtSearchPatient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchPatientKeyReleased(evt);
            }
        });

        cmbSelectPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelectPatientActionPerformed(evt);
            }
        });

        tbPatientHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Company", "Medicine", "Packing", "Quantity", "Dosage", "Date"
            }
        ));
        jScrollPane1.setViewportView(tbPatientHistory);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbSelectPatient, 0, 155, Short.MAX_VALUE)
                    .addComponent(txtSearchPatient))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSearchPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbSelectPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(192, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchPatientKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchPatientKeyReleased
        String patientName = txtSearchPatient.getText();

        vectorPatients = commonServices.getVectorPatients(patientName);

        DefaultComboBoxModel modelPatients = new DefaultComboBoxModel(vectorPatients);
        cmbSelectPatient.setModel(modelPatients);
    }//GEN-LAST:event_txtSearchPatientKeyReleased

    private void cmbSelectPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelectPatientActionPerformed
   Patient patient = (Patient) cmbSelectPatient.getSelectedItem();
        
        Vector<Prescription> vectorPrescription =  patientService.getPatientHistory(patient);
        PrescriptionTableModel model = new PrescriptionTableModel(vectorPrescription);
        tbPatientHistory.setModel(model);
        
        Font font = new Font("Arial", 10, 16);
        tbPatientHistory.setFont(font);
        
        tbPatientHistory.setRowHeight(35);
    }//GEN-LAST:event_cmbSelectPatientActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbSelectPatient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPatientHistory;
    private javax.swing.JTextField txtSearchPatient;
    // End of variables declaration//GEN-END:variables
}