/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBBroker;
import db.settings.LoadAllSettings;
import db.settings.LoadSettingsByID;
import java.util.List;
import model.TipDoktora;

/**
 *
 * @author Marenda
 */
public class TipDoktoraDaoImpl implements IGenericDao<TipDoktora> {

    private DBBroker datastore;

    public TipDoktoraDaoImpl(DBBroker datastore) {
        this.datastore = datastore;
    }

    @Override
    public TipDoktora loadById(Integer id) throws Exception {
        TipDoktora td = new TipDoktora();
        LoadSettingsByID<Integer> settings = new LoadSettingsByID<>(TipDoktora.class.getCanonicalName(), td.getTableName(), td.getIdColumnName(), id, td.getColumnNamesForSelect());
        return datastore.<TipDoktora>loadByID(settings);
    }

    @Override
    public TipDoktora create(TipDoktora entity) throws Exception {
        return datastore.<TipDoktora>save(entity);
    }

    @Override
    public List<TipDoktora> loadAll() throws Exception {
        TipDoktora td = new TipDoktora();
        LoadAllSettings settings = new LoadAllSettings(td.getClass().getCanonicalName(), td.getTableName(), td.getColumnNamesForSelect());
        return datastore.loadAll(settings);
    }

    @Override
    public void update(TipDoktora entity) throws Exception {
        datastore.update(entity);
    }

    @Override
    public TipDoktora delete(TipDoktora entity) throws Exception {
        if(datastore.delete(entity)){
            return entity;
        }else{
            throw new Exception("Greska prilikom brisanja tipa rukovodioca");
        }
    }

}
