/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.TipDoktora;

/**
 *
 * @author Marenda
 */
public class TipDoktoraTableModel extends AbstractTableModel {

    private List<TipDoktora> tipoviDoktora;
    private final String[] colNames = {"ID", "NAZIV"};

    public TipDoktoraTableModel(List<TipDoktora> tipoviDoktora) {
        this.tipoviDoktora = tipoviDoktora;
    }

    @Override
    public int getRowCount() {
        if (tipoviDoktora == null) {
            return 0;
        }
        return tipoviDoktora.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TipDoktora td = tipoviDoktora.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return td.getId();
            case 1:
                return td.getNaziv();
            default :
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }
    
    public TipDoktora get(int selectedIndex){
        return tipoviDoktora.get(selectedIndex);
    }
    
    

}
