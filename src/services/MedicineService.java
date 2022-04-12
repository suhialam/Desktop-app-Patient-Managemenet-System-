package services;

import entity.Company;
import entity.Medicine;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.SQLQueryUtil;

/**
 *
 * @author Suhail Alam//String query = "insert into medicine(medicine_name, company_id)"
                + " values('" + medicine.getMedicineName() + "',"
                + medicine.getCompany().getCompanyId() + ");";
        System.out.println(query);
 */
public class MedicineService {
    
    public void registerMedicine(Medicine medicine){
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
       
        String query = "insert into medicine(medicine_name, company_id)" +"values('" + medicine.getMedicineName() +
                "',"+ medicine.getCompany().getCompanyId() + ");";
        System.out.println(query);
        
        try{
            sql.executeUpdate(query);
            sql.commit();
            JOptionPane.showMessageDialog(null," medicine added succesfully");
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            sql.disconnect();
        }
    }
      
    public void updateMedicine(Medicine medicine) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        
        String query = "update medicine set medicine_name='" + medicine.getMedicineName() 
                + "' where medicine_id=" + medicine.getMedicineId() + ";";
        System.out.println(query);
        
        try{
            sql.executeUpdate(query);
            sql.commit();
            JOptionPane.showMessageDialog(null, "Medicine Added Successfully");
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            sql.disconnect();
        }
    }
  public void addMedicineDetail(Medicine medicine) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        
        String query = "update medicine set medicine_id='" + medicine.getMedicineId()
                + "' packing =" + medicine.getPacking()+ ";";
        System.out.println(query);
        
        try{
            sql.executeUpdate(query);
            sql.commit();
            JOptionPane.showMessageDialog(null, "Medicine Added Successfully");
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            sql.disconnect();
        }
  
}
  public void saveMedicineDetail(Medicine medicine) throws SQLException{
      SQLQueryUtil sql = new SQLQueryUtil();
      sql.connect(false);
      
      String query = "insert into medicine_detail(medicine_id , packing)"
              + "values("+ medicine.getMedicineId()+",'" + medicine.getPacking()+"');";
      System.out.println(query);
      
      try{
          sql.executeUpdate(query);
          sql.commit();
          JOptionPane.showMessageDialog(null,"Medicine Detail Added Successfully");
      }catch(SQLException ex){
          ex.printStackTrace();
      }finally{
          sql.disconnect();
      }
      
  }
}