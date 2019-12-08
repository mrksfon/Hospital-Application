/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Zvanje;

/**
 *
 * @author Marenda
 */
public class ZvanjeTableModel extends AbstractTableModel{
    private List<Zvanje> zvanja;
    private String[] columns = {"Zvanje id","Naziv"};
    @Override
    public int getRowCount() {
        if(zvanja != null)
            return zvanja.size();
        return 0;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zvanje z = (Zvanje) zvanja.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return z.getId();
            case 1:
                return z.getNaziv();
            default :
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    public void addZvanje(Zvanje z){
        zvanja.add(z);
        fireTableDataChanged();
    }
    
    public void setZvanja(List<Zvanje> lista){
        if(lista != null){
            zvanja = lista;
            fireTableDataChanged();
        }
    }
    
    public Zvanje getZvanje(int selectedRow){
        return zvanja.get(selectedRow);
    }
    
    public void removeZvanje(Integer id){
        for(Zvanje zvanje : zvanja){
            if(zvanje.getId() == id){
                zvanja.remove(zvanje);
                fireTableDataChanged();
                return;
            }
        }
    }
    
    public Integer getSelectedZvanjeId(int selectedRow){
        return zvanja.get(selectedRow).getId();
    }
    
    
    
}
