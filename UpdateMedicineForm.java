/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entity.Company;
import entity.Medicine;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import services.CommonServices;
import services.MedicineService;

/**
 *
 * @author Suhail Alam
 */
public class UpdateMedicineForm extends javax.swing.JInternalFrame {
    CommonServices commonServices;
    MedicineService medicineService;
    /**
     * Creates new form UpdateMedicine
     */
    public UpdateMedicineForm() {
        initComponents();
        commonServices = new CommonServices();
        medicineService = new MedicineService();
        
        Vector<Company> vectorCompanies = commonServices.getVectorCompanies();
        
        DefaultComboBoxModel modelCompanies = new DefaultComboBoxModel(vectorCompanies);
        cmbCompanies.setModel(modelCompanies);
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
        jLabel3 = new javax.swing.JLabel();
        cmbCompanies = new javax.swing.JComboBox<>();
        cmbSelectMedicine = new javax.swing.JComboBox<>();
        txtMedicineName = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Update Medicine Form");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Select Company");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Select Medicine");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Medicine Name");

        cmbCompanies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCompaniesActionPerformed(evt);
            }
        });

        cmbSelectMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelectMedicineActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cmbCompanies, 0, 191, Short.MAX_VALUE)
                        .addComponent(cmbSelectMedicine, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMedicineName))
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbCompanies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbSelectMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMedicineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCompaniesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCompaniesActionPerformed
      Company company = (Company) cmbCompanies.getSelectedItem();
         Vector<Medicine> vectorMedicine = commonServices.getCompanyMedicines(company);
        
         DefaultComboBoxModel modelMedicine = new DefaultComboBoxModel(vectorMedicine);
         cmbSelectMedicine.setModel(modelMedicine);
    }//GEN-LAST:event_cmbCompaniesActionPerformed

    private void cmbSelectMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelectMedicineActionPerformed
      Medicine medicine = (Medicine) cmbSelectMedicine.getSelectedItem();
      txtMedicineName .setText(medicine.getMedicineName());
    }//GEN-LAST:event_cmbSelectMedicineActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
     if(txtMedicineName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Empty data can not be updated.");
        } else {
            Medicine medicine = (Medicine) cmbSelectMedicine.getSelectedItem();
            medicine.setMedicineName(txtMedicineName.getText());
            
            medicineService.updateMedicine(medicine);
            txtMedicineName.setText("");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbCompanies;
    private javax.swing.JComboBox<String> cmbSelectMedicine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtMedicineName;
    // End of variables declaration//GEN-END:variables
}