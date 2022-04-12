package services;

import entity.Company;
import entity.Medicine;
import entity.Patient;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import sun.security.rsa.RSACore;
import util.SQLQueryUtil;

/**
 *
 * @author Suhail Alam
 */
public class CommonServices {

    public Vector<Company> getVectorCompanies() {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        String query = "select * from companies order by company_name ASC;";
        Company company;
        Vector<Company> vectorCompanies = new Vector<>();

        ResultSet resultSet;

        try {
            resultSet = sql.executeQuery(query);

            while (resultSet.next()) {
                company = new Company();

                company.setCompanyId(resultSet.getInt("company_id"));
                company.setCompanyName(resultSet.getString("company_name"));
                company.setAddress(resultSet.getString("address"));
                company.setPhoneNumber(resultSet.getString("phone_number"));

                //company.setPhoneNumber(resultSet.getString(3));
                vectorCompanies.add(company);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }

        return vectorCompanies;
    }

    public Vector<Medicine> getCompanyMedicines(Company company) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        String query = "select * from medicine where company_id="
                + company.getCompanyId() + ";";
        System.out.println(query);
        Medicine medicine;
        Vector<Medicine> vectorMedicine = new Vector<>();
        ResultSet resultSet;
        try {
            resultSet = sql.executeQuery(query);
            while (resultSet.next()) {
                medicine = new Medicine();
                medicine.setMedicineId(resultSet.getInt("medicine_id"));
                medicine.setMedicineName(resultSet.getString("medicine_name"));

                medicine.setCompany(company);

                vectorMedicine.add(medicine);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }
        return vectorMedicine;
    }

    public Vector<Patient> getVectorPatients() {

    
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        String query = "SELECT * FROM `patient` ORDER BY `patient_name` ASC;";
        Patient patient;
        Vector<Patient> vectorPatient = new Vector<>();
        ResultSet resultSet;

        try {
            resultSet = sql.executeQuery(query);
            while (resultSet.next()) {
                patient = new Patient();
                patient.setPatientId(resultSet.getInt("patient_id"));
                patient.setPatientName(resultSet.getString("patient_name"));
                patient.setFatherName(resultSet.getString("father_name"));
                patient.setAddress(resultSet.getString("address"));
                patient.setPhoneNumber(resultSet.getString("phone_number"));

                vectorPatient.add(patient);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }
        return vectorPatient;
    }
    public Vector<Patient> getVectorPatients(String patientName) {

    
        SQLQueryUtil sql = new SQLQueryUtil();  
        sql.connect(false);

       String query = "SELECT * FROM `patient` WHERE `patient_name` like('"
                + patientName +  "%') ORDER BY `patient_name` ASC;";
        Patient patient;
        Vector<Patient> vectorPatient = new Vector<>();
        ResultSet resultSet;

        try {
            resultSet = sql.executeQuery(query);
            while (resultSet.next()) {
                patient = new Patient();
                patient.setPatientId(resultSet.getInt("patient_id"));
                patient.setPatientName(resultSet.getString("patient_name"));
                patient.setFatherName(resultSet.getString("father_name"));
                patient.setAddress(resultSet.getString("address"));
                patient.setPhoneNumber(resultSet.getString("phone_number"));

                vectorPatient.add(patient);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }
        return vectorPatient;
    }
    
    public Vector<String> getMedicinePacking(Medicine medicine){
    SQLQueryUtil sql = new SQLQueryUtil();
    sql.connect(false);
    
    String query = "SELECT * FROM `medicine_detail` WHERE `medicine_id` = " + medicine.getMedicineId()+";";
    
    Vector<String> vectorPacking = new Vector<>();
    ResultSet resultSet;
    
     try {
            resultSet = sql.executeQuery(query);
            while(resultSet.next()) {
                vectorPacking.add(resultSet.getString("packing"));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }
        
        return vectorPacking;
    }   
}
