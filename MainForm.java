/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author Suhail Alam
 */
public class MainForm extends javax.swing.JFrame {

    private AddCompanyForm addCompanyForm;
    private UpdateCompanyForm updateCompanyForm;
    private AllCompaniesForm allCompaniesForm;

    private AddMedicineForm addMedicineForm;
    private UpdateMedicineForm updateMedicineForm;
    private AddMedicineDetail addMedicineDetail;

    private RegisterPateintForm registerPatientForm;
    private UpdatePatientForm updatePatientForm;

    private NewPrescriptionForm newPrescriptionForm;
    private PatientHistoryForm patientHistoryForm;

    public MainForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        mnuCompany = new javax.swing.JMenu();
        miAddCompany = new javax.swing.JMenuItem();
        miUpdateCompany = new javax.swing.JMenuItem();
        miAllCompanyList = new javax.swing.JMenuItem();
        mnuMedicine = new javax.swing.JMenu();
        miAddMedicine = new javax.swing.JMenuItem();
        miUpdateMedicine = new javax.swing.JMenuItem();
        miAddMedicineDetail = new javax.swing.JMenuItem();
        mnuPatient = new javax.swing.JMenu();
        miRegisterPatient = new javax.swing.JMenuItem();
        miUpdatePatient = new javax.swing.JMenuItem();
        mnuPrescription = new javax.swing.JMenu();
        miNewPrescription = new javax.swing.JMenuItem();
        miPatientHistory = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Patient Management Form");

        mnuCompany.setText("Company");

        miAddCompany.setText("Add Company");
        miAddCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddCompanyActionPerformed(evt);
            }
        });
        mnuCompany.add(miAddCompany);

        miUpdateCompany.setText("Update Company");
        miUpdateCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miUpdateCompanyActionPerformed(evt);
            }
        });
        mnuCompany.add(miUpdateCompany);

        miAllCompanyList.setText("All Company List");
        miAllCompanyList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAllCompanyListActionPerformed(evt);
            }
        });
        mnuCompany.add(miAllCompanyList);

        jMenuBar1.add(mnuCompany);

        mnuMedicine.setText("Medicine");

        miAddMedicine.setText("Add Medicine");
        miAddMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddMedicineActionPerformed(evt);
            }
        });
        mnuMedicine.add(miAddMedicine);

        miUpdateMedicine.setText("Update Medicine");
        miUpdateMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miUpdateMedicineActionPerformed(evt);
            }
        });
        mnuMedicine.add(miUpdateMedicine);

        miAddMedicineDetail.setText("Add Medicine Detail");
        miAddMedicineDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddMedicineDetailActionPerformed(evt);
            }
        });
        mnuMedicine.add(miAddMedicineDetail);

        jMenuBar1.add(mnuMedicine);

        mnuPatient.setText("Patient");

        miRegisterPatient.setText("Register Patient ");
        miRegisterPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegisterPatientActionPerformed(evt);
            }
        });
        mnuPatient.add(miRegisterPatient);

        miUpdatePatient.setText("Update Patient");
        miUpdatePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miUpdatePatientActionPerformed(evt);
            }
        });
        mnuPatient.add(miUpdatePatient);

        jMenuBar1.add(mnuPatient);

        mnuPrescription.setText("Prescription");

        miNewPrescription.setText("New Prescription");
        miNewPrescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNewPrescriptionActionPerformed(evt);
            }
        });
        mnuPrescription.add(miNewPrescription);

        miPatientHistory.setText("Patient History");
        miPatientHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPatientHistoryActionPerformed(evt);
            }
        });
        mnuPrescription.add(miPatientHistory);

        jMenuBar1.add(mnuPrescription);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 721, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miAddCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddCompanyActionPerformed
        addCompanyForm = new AddCompanyForm();
        this.add(addCompanyForm);
        addCompanyForm.setVisible(true);
    }//GEN-LAST:event_miAddCompanyActionPerformed

    private void miUpdateCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miUpdateCompanyActionPerformed
         updateCompanyForm = new UpdateCompanyForm();
        this.add(updateCompanyForm);
        updateCompanyForm.setVisible(true);
    }//GEN-LAST:event_miUpdateCompanyActionPerformed

    private void miAllCompanyListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAllCompanyListActionPerformed
        allCompaniesForm = new AllCompaniesForm();
        this.add(allCompaniesForm);
        allCompaniesForm.setVisible(true);
    }//GEN-LAST:event_miAllCompanyListActionPerformed

    private void miAddMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddMedicineActionPerformed
        addMedicineForm = new AddMedicineForm();
        this.add(addMedicineForm);
        addMedicineForm.setVisible(true);
    }//GEN-LAST:event_miAddMedicineActionPerformed

    private void miUpdateMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miUpdateMedicineActionPerformed
        updateMedicineForm = new UpdateMedicineForm();
        this.add(updateMedicineForm);
        updateMedicineForm.setVisible(true);
    }//GEN-LAST:event_miUpdateMedicineActionPerformed

    private void miAddMedicineDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddMedicineDetailActionPerformed
        addMedicineDetail = new AddMedicineDetail();
        this.add(addMedicineDetail);
        addMedicineDetail.setVisible(true);
    }//GEN-LAST:event_miAddMedicineDetailActionPerformed

    private void miRegisterPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegisterPatientActionPerformed
        registerPatientForm = new RegisterPateintForm();
        this.add(registerPatientForm);
        registerPatientForm.setVisible(true);
    }//GEN-LAST:event_miRegisterPatientActionPerformed

    private void miUpdatePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miUpdatePatientActionPerformed
        updatePatientForm = new UpdatePatientForm();
        this.add(updatePatientForm);
        updatePatientForm.setVisible(true);
    }//GEN-LAST:event_miUpdatePatientActionPerformed

    private void miNewPrescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNewPrescriptionActionPerformed
        newPrescriptionForm = new NewPrescriptionForm();
        this.add(newPrescriptionForm);
        newPrescriptionForm.setVisible(true);
    }//GEN-LAST:event_miNewPrescriptionActionPerformed

    private void miPatientHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPatientHistoryActionPerformed
        patientHistoryForm = new PatientHistoryForm();
        this.add(patientHistoryForm);
        patientHistoryForm.setVisible(true);
    }//GEN-LAST:event_miPatientHistoryActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem miAddCompany;
    private javax.swing.JMenuItem miAddMedicine;
    private javax.swing.JMenuItem miAddMedicineDetail;
    private javax.swing.JMenuItem miAllCompanyList;
    private javax.swing.JMenuItem miNewPrescription;
    private javax.swing.JMenuItem miPatientHistory;
    private javax.swing.JMenuItem miRegisterPatient;
    private javax.swing.JMenuItem miUpdateCompany;
    private javax.swing.JMenuItem miUpdateMedicine;
    private javax.swing.JMenuItem miUpdatePatient;
    private javax.swing.JMenu mnuCompany;
    private javax.swing.JMenu mnuMedicine;
    private javax.swing.JMenu mnuPatient;
    private javax.swing.JMenu mnuPrescription;
    // End of variables declaration//GEN-END:variables
}
