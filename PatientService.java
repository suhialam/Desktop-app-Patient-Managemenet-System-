package entity;

import entity.Patient;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import entity.Patient;
import java.sql.ResultSet;
import java.util.Vector;
import util.SQLQueryUtil;

/**
 *
 * @author Suhail Alam
 */
public class PatientService {

    public void registerPatient(Patient patient) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        String query = "INSERT INTO `patient`(`patient_name`, `father_name`, `address`, `phone_number`)"
                + " VALUES ('"
                + patient.getPatientName() + "','"
                + patient.getFatherName() + "','"
                + patient.getAddress() + "','"
                + patient.getPhoneNumber() + "')";
        System.out.println(query);

        try {
            int rowsAffected = sql.executeUpdate(query);
            if (rowsAffected > 0) {
                sql.commit();
                JOptionPane.showMessageDialog(null, "Patient Registered Succesfully");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }
    }

    public void updatePatient(Patient patient) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        String query = "UPDATE `patient` SET `patient_name`='"
                + patient.getPatientName() + "',"
                + "`father_name` = '" + patient.getFatherName() + "',"
                + "`address`='" + patient.getAddress() + "',"
                + "`phone_number` = '" + patient.getPhoneNumber() + "' "
                + " WHERE `patient_id`=" + patient.getPatientId() + ";";

        try {
            int rowsAffected = sql.executeUpdate(query);
            if (rowsAffected == 1) {
                sql.commit();
                JOptionPane.showMessageDialog(null, "Patient Updated Successfully");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();

        }

    }

    public void saveNewPrescription(Patient patient, Vector<Prescription> vectorPrescription) {

        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        int size = vectorPrescription.size();
        int i = 0;
        int medicineDetailId = 0;

        String queryFind;
        String queryInsert;
        ResultSet resultSet;
        try {
            for (i = 0; i < size; i++) {
                queryFind = "SELECT * FROM `medicine_detail` WHERE "
                        + "`medicine_id`=" + vectorPrescription.get(i).getMedicine().getMedicineId()
                        + " AND `packing`='" + vectorPrescription.get(i).getMedicine().getPacking() + "';";
                System.out.println(queryFind);

                resultSet = sql.executeQuery(queryFind);
                resultSet.next();

                medicineDetailId = resultSet.getInt("medicine_detail_id");

                queryInsert = "INSERT INTO `patient_history`(`patient_id`, "
                        + "`medicine_detail_id`, `quantity`, `dosage`, "
                        + "`prescription_date`) VALUES "
                        + "(" + patient.getPatientId() + ","
                        + medicineDetailId + ","
                        + vectorPrescription.get(i).getQuantity() + ",'"
                        + vectorPrescription.get(i).getDosage() + "','"
                        + vectorPrescription.get(i).getPrescriptionDate() + "');";
                sql.executeUpdate(queryInsert);
            }
            sql.commit();
            JOptionPane.showMessageDialog(null, "Patient Prescription Saved Sucessfully");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }
    }

    public Vector<Prescription> getPatientHistory(Patient patient) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        Vector<Prescription> vectorPrescription = new Vector<>();

        Prescription prescription;
        Medicine medicine;
        Company company;

        String query = "SELECT * FROM `companies` AS `c`, `medicine` AS `m`,"
                + "`medicine_detail` AS `md`, `patient` AS `p`, "
                + "`patient_history` AS `ph` WHERE "
                + "`c`.`company_id` = `m`.`company_id` AND "
                + "`m`.`medicine_id`=`md`.`medicine_id` AND "
                + "`md`.`medicine_detail_id` = `ph`.`medicine_detail_id` AND "
                + "`ph`.`patient_id` = " + patient.getPatientId()
                + " AND `p`.`patient_id` = " + patient.getPatientId() + " ORDER BY `ph`.`prescription_date` DESC;";
        try {
            ResultSet resultSet = sql.executeQuery(query);

            while (resultSet.next()) {
                prescription = new Prescription();
                medicine = new Medicine();
                company = new Company();

                company.setCompanyId(resultSet.getInt("company_id"));
                company.setCompanyName(resultSet.getString("company_name"));

                medicine.setMedicineName(resultSet.getString("medicine_name"));
                medicine.setPacking(resultSet.getString("packing"));
                medicine.setCompany(company);

                prescription.setMedicine(medicine);
                prescription.setQuantity(resultSet.getInt("quantity"));
                prescription.setDosage(resultSet.getString("dosage"));
                prescription.setPrescriptionDate(resultSet.getString("prescription_date"));

                vectorPrescription.add(prescription);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }
        return vectorPrescription;
    }

}
