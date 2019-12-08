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
import model.Doktor;

/**
 *
 * @author Marenda
 */
public class DoktorDaoImpl implements IGenericDao<Doktor>{
    private DBBroker datastore;
    
    public DoktorDaoImpl(DBBroker datastore){
        this.datastore = datastore;
    }

    @Override
    public Doktor loadById(Integer id) throws Exception {
        Doktor d = new Doktor();
        LoadSettingsByID<Integer> settings = new LoadSettingsByID<>(Doktor.class.getCanonicalName(), d.getTableName(), d.getIdColumnName(), id, d.getColumnNamesForSelect());
        settings.joins = d.getJoins();
        return datastore.<Doktor>loadByID(settings);
    }

    @Override
    public Doktor create(Doktor entity) throws Exception {
        return datastore.save(entity);
    }

    @Override
    public List<Doktor> loadAll() throws Exception {
        Doktor d = new Doktor();
        LoadAllSettings settings = new LoadAllSettings(Doktor.class.getCanonicalName(), d.getTableName(), d.getColumnNamesForSelect());
        settings.joins = d.getJoins();
        return datastore.<Doktor>loadAll(settings);
    }

    @Override
    public void update(Doktor entity) throws Exception {
        datastore.update(entity);
    }

    @Override
    public Doktor delete(Doktor entity) throws Exception {
        if(datastore.delete(entity)){
            return entity;
        }else{
            throw new Exception("Greska prilikom brisanja doktora");
        }
    }
    
    
}
