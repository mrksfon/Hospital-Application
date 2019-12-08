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
import model.VrstaBolnice;

/**
 *
 * @author Marenda
 */
public class VrstaBolniceDaoImpl implements IGenericDao<VrstaBolnice>{
    private DBBroker datastore;
    
    public VrstaBolniceDaoImpl(DBBroker datastore){
        this.datastore = datastore;
    }
    @Override
    public VrstaBolnice loadById(Integer id) throws Exception {
        VrstaBolnice vb = new VrstaBolnice();
        LoadSettingsByID<Integer> settings = new LoadSettingsByID<>(VrstaBolnice.class.getCanonicalName(), vb.getTableName(), vb.getIdColumnName(), id, vb.getColumnNamesForSelect());
        return datastore.loadByID(settings);
    }

    @Override
    public VrstaBolnice create(VrstaBolnice entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VrstaBolnice> loadAll() throws Exception {
        VrstaBolnice vb = new VrstaBolnice();
        LoadAllSettings settings = new LoadAllSettings(VrstaBolnice.class.getCanonicalName(), vb.getTableName(), vb.getColumnNamesForSelect());
        return datastore.loadAll(settings);
    }

    @Override
    public void update(VrstaBolnice entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VrstaBolnice delete(VrstaBolnice entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
