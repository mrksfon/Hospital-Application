/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfejsi.IEntityRead;
import java.io.Serializable;

/**
 *
 * @author Marenda
 */
public class VrstaBolnice implements IEntityRead, Serializable {

    private Integer id;
    private String naziv;

    public VrstaBolnice(Integer id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public VrstaBolnice() {
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
    public String[] getJoins() {
        return null;
    }

    @Override
    public String[] getColumnNamesForSelect() {
        return new String[]{
            getIdColumnName(),
            "naziv"
        };
    }

    @Override
    public void fillAttributes(Object[] values) throws Exception {
        setId(Integer.parseInt(values[0].toString()));
        setNaziv(values[1].toString());
    }

    @Override
    public String getTableName() {
        return "vrsta_bolnice";
    }

    @Override
    public String getIdColumnName() {
        return "vrsta_bolnice_id";
    }

    @Override
    public String toString() {
        return naziv;
    }

}
