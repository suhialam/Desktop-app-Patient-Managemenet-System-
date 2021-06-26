package TableModels;

import entity.Company;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Suhail Alam
 */
public class AllCompaniesTableModel extends AbstractTableModel {

    private Vector<Company> vectorCompanies;

    public AllCompaniesTableModel() {
    }

    public AllCompaniesTableModel(Vector<Company> vectorCompanies) {
        this.vectorCompanies = vectorCompanies;
    }

    @Override
    public int getRowCount() {
        return vectorCompanies.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object object = null;

        switch (columnIndex) {
            case 0:
                object = vectorCompanies.get(rowIndex).getCompanyId();
                break;
            case 1:
                object = vectorCompanies.get(rowIndex).getCompanyName();
                break;
            case 2:
                object = vectorCompanies.get(rowIndex).getAddress();
                break;
            case 3:
                object = vectorCompanies.get(rowIndex).getPhoneNumber();
                break;

        }
        return object;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String columnName = "";

        switch (columnIndex) {
            case 0:
                columnName = "ID";
                break;
            case 1:
                columnName = "Company Name";
                break;
            case 2:
                columnName = "Address";
                break;
            case 3:
                columnName = "Phone Number";
                break;

        }
        return columnName;
    }

}
