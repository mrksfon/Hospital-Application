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
import model.Zvanje;

/**
 *
 * @author Marenda
 */
public class ZvanjeDaoImpl implements IGenericDao<Zvanje>{
    private DBBroker db;
    
    public ZvanjeDaoImpl(DBBroker broker){
        db = broker;
    }
    @Override
    public Zvanje loadById(Integer id) throws Exception {
        Zvanje z = new Zvanje();
        
        LoadSettingsByID<Integer> settings = new LoadSettingsByID<>(Zvanje.class.getCanonicalName(), z.getTableName(), z.getIdColumnName(), id, z.getColumnNamesForSelect());
        return db.loadByID(settings);
    }

    @Override
    public Zvanje create(Zvanje entity) throws Exception {
        try{
            return (Zvanje) db.save(entity);
        }catch(Exception ex){
            throw  ex;
        }
    }

    @Override
    public List<Zvanje> loadAll() throws Exception {
        LoadAllSettings settings = new LoadAllSettings(Zvanje.class.getCanonicalName(), "zvanje", new String[]{"zvanje_id","naziv"});
        return db.loadAll(settings);
    }

    @Override
    public void update(Zvanje entity) throws Exception {
        db.update(entity);
    }

    @Override
    public Zvanje delete(Zvanje entity) throws Exception {
        if(db.delete(entity)){
            return entity;
        }else{
            throw new Exception("Zvanje is not deleted");
        }
    }
    
}
