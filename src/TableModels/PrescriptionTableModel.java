/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModels;

import entity.Prescription;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Suhail Alam
 */
public class PrescriptionTableModel extends AbstractTableModel {

    private Vector<Prescription> vectorPrescription;

    public PrescriptionTableModel() {
    }

    public PrescriptionTableModel(Vector<Prescription> vectorPrescription) {
        this.vectorPrescription = vectorPrescription;
    }

    @Override
    public int getRowCount() {
        if (vectorPrescription != null) {
            return vectorPrescription.size();
        } else {
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object object = null;
        switch (columnIndex) {
            case 0:
                object = vectorPrescription.get(rowIndex).getMedicine().getCompany().getCompanyName();
                break;
            case 1:
                object = vectorPrescription.get(rowIndex).getMedicine().getMedicineName();
                break;
            case 2:
                object = vectorPrescription.get(rowIndex).getMedicine().getPacking();
                break;
            case 3:
                object = vectorPrescription.get(rowIndex).getQuantity();
                break;
            case 4:
                object = vectorPrescription.get(rowIndex).getDosage();
                break;
            case 5:
                object = vectorPrescription.get(rowIndex).getPrescriptionDate();
                break;

        }
        return object;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String columnName = "";

        switch (columnIndex) {
            case 0:
                columnName = "Company";
                break;

            case 1:
                columnName = "Medicine";
                break;
            case 2:
                columnName = "Packing";
                break;
            case 3:
                columnName = "Quantity";
                break;
            case 4:
                columnName = "Dosage";
                break;
            case 5:
                columnName = "Date";
                break;

        }
        return columnName;

    }
}
