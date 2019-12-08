/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Doktor;

/**
 *
 * @author Marenda
 */
public class DoktoriBolnicaTableModel extends AbstractTableModel{
    private List<Doktor> model;
    private final String[] columnNames = {"Ime", "Prezime", "Tip", "Zvanje"};

    public DoktoriBolnicaTableModel(List<Doktor> model) {
        this.model = model;
    }
    
    public DoktoriBolnicaTableModel(){
        model = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return model.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Doktor d = model.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return d.getIme();
            case 1:
                return d.getPrezime();
            case 2:
                return d.getTipDoktora().getNaziv();
            case 3:
                return d.getZvanje().getNaziv();
            default :
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    public Doktor getDoktor(int index) throws Exception{
        if(index < 0 || index >= model.size()){
            throw new Exception("Greska izaberite doktra");
        }
        return model.get(index);
    }
    
    public void dodajDoktora(Doktor doktor) throws Exception{
        proveriVrednostiZaDoktora(doktor);
        model.add(doktor);
        fireTableDataChanged();
    }

    private void proveriVrednostiZaDoktora(Doktor doktor) throws Exception {
        if(doktor.getIme().length() < 3){
            throw new Exception("Ime doktora mora imati bar 3 karaktera");
        }
        if(doktor.getPrezime().length() < 3){
            throw new Exception("Prezime doktora mora imati bar 3 karaktera");
        }
        
        if(doktor.getTipDoktora() == null){
            throw new Exception("Morate izabrani tip doktora");
        }
        
        if(doktor.getZvanje() == null){
            throw new Exception("Morate izabrani zvanje doktora");
        }
    }
    
    public void obrisi(int selectedItem){
        if(selectedItem >= 0 && selectedItem < model.size()){
            model.remove(selectedItem);
            fireTableDataChanged();
        }
    }
    
    public List<Doktor> getDoktori(){
        return model;
    }
    
    
}
