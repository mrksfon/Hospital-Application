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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Marenda
 */
public class Zvanje implements IEntityCreate, IEntityRead, IEntityUpdate<Integer>, IEntityDelete<Integer>, Serializable {

    private Integer id;
    private String naziv;
    private List<Doktor> doktori;

    public Zvanje(Integer id, String naziv) {
        this.id = id;
        this.naziv = naziv;
        doktori = new ArrayList<>();
    }

    public Zvanje() {
        naziv = "";
        doktori = new ArrayList<>();
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

    public List<Doktor> getDoktori() {
        return doktori;
    }

    public void setDoktori(List<Doktor> doktori) {
        this.doktori = doktori;
    }

    @Override
    public String getTableName() {
        return "zvanje";
    }

    @Override
    public String[] getColumnNamesForInsert() {
        return new String[]{"naziv"};
    }

    @Override
    public String[] getColumnValuesForInsert() {
        return new String[]{"'" + naziv + "'"};
    }

    @Override
    public boolean isIdAutoIncrement() {
        return true;
    }

    @Override
    public void fillAttributes(Object[] values) throws Exception {
        setId(Integer.valueOf(values[0].toString()));
        setNaziv(values[1].toString());
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String[] getColumnNamesForSelect() {
        return new String[]{"zvanje_id", "naziv"};
    }

    @Override
    public String getIdColumnName() {
        return "zvanje_id";
    }

    @Override
    public String[] getUpdateColumnNames() {
        return new String[]{"naziv"};
    }

    @Override
    public String[] getUpdateColumnValues() {
        return new String[]{"'" + naziv + "'"};
    }

    @Override
    public Integer getIdValue() {
        return id;
    }

    @Override
    public String[] getJoins() {
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Zvanje other = (Zvanje) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

}
