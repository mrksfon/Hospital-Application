/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doktorCommand;

import command.AbstractCommand;
import dao.DoktorDaoImpl;
import dao.IGenericDao;
import db.DBBroker;
import model.Doktor;

/**
 *
 * @author Marenda
 */
public class DoktorLoadAllCommand extends AbstractCommand{
    
    @Override
    protected void executeOperation() throws Exception {
        IGenericDao<Doktor> doktorDao = new DoktorDaoImpl(DBBroker.getInstance());
        
        response.setData(doktorDao.loadAll());
    }
    
}
