/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfejsi.IEntityCreate;
import interfejsi.IEntityDelete;
import interfejsi.IEntityRead;
import interfejsi.IEntityUpdate;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Marenda
 */
public class Doktor implements IEntityCreate, IEntityRead, IEntityUpdate<Integer>, IEntityDelete<Integer>, Serializable {

    private Integer id;
    private String ime;
    private String prezime;
    private Bolnica bolnica;
    private Zvanje zvanje;
    private TipDoktora tipDoktora;

    public Doktor(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public Doktor() {
        tipDoktora = new TipDoktora();
        zvanje = new Zvanje();
        bolnica = new Bolnica();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Bolnica getBolnica() {
        return bolnica;
    }

    public void setBolnica(Bolnica bolnica) {
        this.bolnica = bolnica;
    }

    public Zvanje getZvanje() {
        return zvanje;
    }

    public void setZvanje(Zvanje zvanje) {
        this.zvanje = zvanje;
    }

    public TipDoktora getTipDoktora() {
        return tipDoktora;
    }

    public void setTipDoktora(TipDoktora tipDoktora) {
        this.tipDoktora = tipDoktora;
    }

    @Override
    public String[] getColumnNamesForInsert() {
        return new String[]{"ime", "prezime", "bolnica_fk", "tip_doktora_fk", "zvanje_fk"};
    }

    @Override
    public String[] getColumnValuesForInsert() {
        return new String[]{
            "'" + ime + "'",
            "'" + prezime + "'",
            bolnica.getId() + "",
            tipDoktora.getId() + "",
            zvanje.getId() + ""
        };
    }

    @Override
    public boolean isIdAutoIncrement() {
        return true;
    }

    @Override
    public String getTableName() {
        return "doktor";
    }

    @Override
    public String getIdColumnName() {
        return "doktor_id";
    }

    @Override
    public String[] getColumnNamesForSelect() {
        String[] tipDoktoraColNames = tipDoktora.getColumnNamesForSelect();
        String[] bolnicaColNames = bolnica.getColumnNamesForSelect();

        return new String[]{
            "doktor_id",
            "ime",
            "prezime",
            tipDoktora.getTableName() + "." + tipDoktoraColNames[0] + " AS tip_doktora_id ",
            tipDoktora.getTableName() + "." + tipDoktoraColNames[1] + " AS naziv_tipa_doktora ",
            zvanje.getTableName() + "." + zvanje.getColumnNamesForSelect()[0] + " AS zvanje_id ",
            zvanje.getTableName() + "." + zvanje.getColumnNamesForSelect()[1] + " AS naziv_zvanja ",
            bolnica.getTableName() + "." + bolnicaColNames[0] + " AS bolnica_id ",
            bolnicaColNames[1],
            bolnica.getTableName() + "." + bolnicaColNames[2] + " AS bolnica_mat_br ",
            bolnica.getTableName() + "." + bolnicaColNames[3] + " AS bolnica_por_br ",
            bolnica.getTableName() + "." + bolnicaColNames[4] + " AS bolnica_opis "
        };
    }

    @Override
    public void fillAttributes(Object[] values) throws Exception {
        setId(Integer.valueOf(values[0].toString()));
        setIme(values[1].toString());
        setPrezime(values[2].toString());
        setTipDoktora(new TipDoktora(Integer.valueOf(values[3].toString()), values[4].toString()));
        setZvanje(new Zvanje(Integer.valueOf(values[5].toString()), values[6].toString()));
        setBolnica(new Bolnica(Integer.valueOf(values[7].toString()), values[8].toString(), values[9].toString(), values[10].toString(), values[11].toString()));
    }

    @Override
    public String[] getJoins() {
        return new String[]{
            " JOIN " + tipDoktora.getTableName() + " ON " + (tipDoktora.getTableName() + "." + tipDoktora.getIdColumnName()) + " = tip_doktora_fk",
            " JOIN " + zvanje.getTableName() + " ON " + (zvanje.getTableName() + "." + zvanje.getIdColumnName()) + " = " + "zvanje_fk",
            " JOIN " + bolnica.getTableName() + " ON " + (bolnica.getTableName() + "." + bolnica.getIdColumnName()) + "=" + "bolnica_fk",};
    }

    @Override
    public String toString() {
        return ime + " " + prezime + " " + ((bolnica.getNaziv() != null) ? bolnica.getNaziv() : "");
    }

    @Override
    public int hashCode() {
        int hash = 9;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Doktor other = (Doktor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String[] getUpdateColumnNames() {
        return new String[]{"ime","prezime","bolnica_fk","tip_doktora_fk","zvanje_fk"};
    }

    @Override
    public String[] getUpdateColumnValues() {
        return new String[]{
            "'" + ime + "'",
            "'" + prezime + "'",
            bolnica.getId() + "",
            tipDoktora.getId() + "",
            zvanje.getId() + ""
        };
    }

    @Override
    public Integer getIdValue() {
        return id;
    }
    
    

}
