/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Bolnica;

/**
 *
 * @author Marenda
 */
public class BolnicaTableModel extends AbstractTableModel{
    private List<Bolnica> bolnice;
    private String[] colNames = {"Naziv","Maticni broj","Poreski broj","Opis","Vrsta bolnice"};
    
    public BolnicaTableModel(List<Bolnica> bolnice){
        this.bolnice = bolnice;
    }
    
    @Override
    public int getRowCount() {
        return bolnice.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Bolnica b = bolnice.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return b.getNaziv();
            case 1:
                return b.getMaticniBroj();
            case 2:
                return b.getPoreskiBroj();
            case 3:
                return b.getOpis();
            case 4:
                return b.getVrstaBolnice().getNaziv();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }
    
    public Bolnica getSelectedBolnica(int selectedIndex) throws Exception{
        if(selectedIndex >= 0 && selectedIndex < bolnice.size()){
            return bolnice.get(selectedIndex);
        }
        throw new Exception("Doslo je do greske prilikom selektiranja bolnice");
    }
    
    
    
}
