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
import model.Bolnica;

/**
 *
 * @author Marenda
 */
public class BolnicaDaoImpl implements IGenericDao<Bolnica>{
    
    private DBBroker datastore;
    
   public  BolnicaDaoImpl(DBBroker datastore){
       this.datastore = datastore;
   }

    @Override
    public Bolnica loadById(Integer id) throws Exception {
        Bolnica b = new Bolnica();
        
        LoadSettingsByID<Integer> settings = new LoadSettingsByID<>(Bolnica.class.getCanonicalName(), b.getTableName(), b.getIdColumnName(), id, b.getColumnNamesForSelect());
        settings.joins = b.getJoins();
        
        return datastore.loadByID(settings);
    }

    @Override
    public Bolnica create(Bolnica entity) throws Exception {
        return datastore.save(entity);
    }

    @Override
    public List<Bolnica> loadAll() throws Exception {
        Bolnica b = new Bolnica();
        LoadAllSettings settings = new LoadAllSettings(Bolnica.class.getCanonicalName(), "bolnica", b.getColumnNamesForSelect());
        settings.joins = b.getJoins();
        return datastore.loadAll(settings);
    }
    
    @Override
    public void update(Bolnica entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bolnica delete(Bolnica entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   
   
   
}
