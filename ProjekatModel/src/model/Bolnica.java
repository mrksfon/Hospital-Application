/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfejsi.IEntityCreate;
import interfejsi.IEntityRead;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Marenda
 */
public class Bolnica implements IEntityCreate, IEntityRead, Serializable {

    private Integer id;
    private String naziv;
    private String maticniBroj;
    private String poreskiBroj;
    private String opis;
    private VrstaBolnice vrstaBolnice;
    private List<Doktor> doktori = new ArrayList<>();

    public Bolnica(Integer id, String naziv, String maticniBroj, String poreskiBroj, String opis, VrstaBolnice vrstaBolnice) {
        this.id = id;
        this.naziv = naziv;
        this.maticniBroj = maticniBroj;
        this.poreskiBroj = poreskiBroj;
        this.opis = opis;
        this.vrstaBolnice = vrstaBolnice;
    }

    public Bolnica(Integer id, String naziv, String maticniBroj, String poreskiBroj, String opis) {
        this.id = id;
        this.naziv = naziv;
        this.maticniBroj = maticniBroj;
        this.poreskiBroj = poreskiBroj;
        this.opis = opis;
    }

    public Bolnica() {
        vrstaBolnice = new VrstaBolnice();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public String getPoreskiBroj() {
        return poreskiBroj;
    }

    public void setPoreskiBroj(String poreskiBroj) {
        this.poreskiBroj = poreskiBroj;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public VrstaBolnice getVrstaBolnice() {
        return vrstaBolnice;
    }

    public void setVrstaBolnice(VrstaBolnice vrstaBolnice) {
        this.vrstaBolnice = vrstaBolnice;
    }

    public List<Doktor> getDoktori() {
        return doktori;
    }

    public void setDoktori(List<Doktor> doktori) {
        this.doktori = doktori;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String[] getColumnNamesForSelect() {
        return new String[]{
            "bolnica_id",
            getTableName() + ".naziv AS bNaziv ",
            "maticni_broj",
            "poreski_broj",
            "opis",
            vrstaBolnice.getTableName() + "." + vrstaBolnice.getIdColumnName(),
            vrstaBolnice.getTableName() + "." + vrstaBolnice.getColumnNamesForSelect()[1] + " AS vrstaBolniceNaziv "
        };
    }

    @Override
    public void fillAttributes(Object[] values) throws Exception {
        setId(Integer.parseInt(values[0].toString()));
        setNaziv(values[1].toString());
        setMaticniBroj(values[2].toString());
        setPoreskiBroj(values[3].toString());
        setOpis(values[4].toString());
        setVrstaBolnice(new VrstaBolnice(Integer.valueOf(values[5].toString()), values[6].toString()));
    }

    @Override
    public String[] getJoins() {
        return new String[]{
            " JOIN " + vrstaBolnice.getTableName() + " ON " + vrstaBolnice.getTableName() + "." + vrstaBolnice.getIdColumnName() + " = bolnica.vrsta_bolnice_fk"
        };
    }

    @Override
    public int hashCode() {
        int hash = 6;
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
        final Bolnica other = (Bolnica) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "bolnica";
    }

    @Override
    public String getIdColumnName() {
        return "bolnica_id";
    }

    @Override
    public String[] getColumnNamesForInsert() {
        return new String[]{
            "naziv",
            "maticni_broj",
            "poreski_broj",
            "opis",
            "vrsta_bolnice_fk"
        };
    }

    @Override
    public String[] getColumnValuesForInsert() {
        return new String[]{
            "'" + naziv + "'",
            "'" + maticniBroj + "'",
            "'" + poreskiBroj+ "'",
            "'" + opis + "'",
            vrstaBolnice.getId() + ""
        };
    }

    @Override
    public boolean isIdAutoIncrement() {
        return true;
    }
    
    public void dodajDoktora(Doktor doktor){
        doktori.add(doktor);
    }
    

}
