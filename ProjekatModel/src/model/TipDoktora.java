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
public class TipDoktora implements IEntityCreate, IEntityRead, IEntityUpdate<Integer>, IEntityDelete<Integer>, Serializable {

    private Integer id;
    private String naziv;

    public TipDoktora() {
    }

    public TipDoktora(Integer id, String naziv) {
        this.id = id;
        this.naziv = naziv;
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
    public String getTableName() {
        return "tip_doktora";
    }

    @Override
    public String getIdColumnName() {
        return "tip_doktora_id";
    }

    @Override
    public String[] getColumnNamesForSelect() {
        return new String[]{"tip_doktora_id", "naziv"};
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
    public String[] getJoins() {
        return null;
    }

    @Override
    public String[] getUpdateColumnNames() {
        return null;
    }

    @Override
    public String[] getUpdateColumnValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getIdValue() {
        return getId();
    }

    @Override
    public int hashCode() {
        int hash = 5;
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

        final TipDoktora other = (TipDoktora) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
