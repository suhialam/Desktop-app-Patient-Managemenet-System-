/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Company;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.SQLQueryUtil;

/**
 *
 * @author Suhail Alam
 */
public class CompanyService {

    public void registerCompany(Company company) {
        //System.out.println(company.getCompanyName());

        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        String query = "insert into companies(company_name, address, phone_number)"
                + " values('" + company.getCompanyName() + "','"
                + company.getAddress() + "','" + company.getPhoneNumber()
                + "');";

        System.out.println(query);

        try {
            sql.executeUpdate(query);
            sql.commit();
            JOptionPane.showMessageDialog(null, "company saved successfully.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }
      
    }

    public void updateCompany(Company company) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        String query = "UPDATE `companies` SET `company_name` = '" + company.getCompanyName() + "', `address` = '"
                + company.getAddress() + "' , `phone_number`='" + company.getPhoneNumber() +"' WHERE `company_id`=" +
                company.getCompanyId()+";";
        System.out.println(query);
        try{
            sql.executeUpdate(query);
            sql.commit();
            JOptionPane.showMessageDialog(null, "Company Updated Successfully");
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            sql.disconnect();
        }

    }
}
