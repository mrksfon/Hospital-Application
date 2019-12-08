/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zvanjeCommand;

import command.AbstractCommand;
import dao.DoktorDaoImpl;
import dao.IGenericDao;
import dao.ZvanjeDaoImpl;
import db.DBBroker;
import java.util.List;
import model.Doktor;
import model.Zvanje;

/**
 *
 * @author Marenda
 */
public class ZvanjeLoadAllCommand extends AbstractCommand{

    @Override
    protected void executeOperation() throws Exception {
        IGenericDao<Zvanje> zvanjeDao = new ZvanjeDaoImpl(DBBroker.getInstance());
        
        List<Zvanje> zvanja = zvanjeDao.loadAll();
        
        IGenericDao<Doktor> doktorDao = new DoktorDaoImpl(DBBroker.getInstance());
        List<Doktor> doktori = doktorDao.loadAll();
        
        for(Zvanje z : zvanja){
            for(Doktor d : doktori){
                if(d.getZvanje().equals(z)){
                    z.getDoktori().add(d);
                }
            }
        }
        response.setData(zvanja);
        
    }
    
}
