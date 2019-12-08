/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrstaBolniceCommand;

import command.AbstractCommand;
import dao.IGenericDao;
import dao.VrstaBolniceDaoImpl;
import db.DBBroker;
import model.VrstaBolnice;

/**
 *
 * @author Marenda
 */
public class VrstaBolniceLoadAllCommand extends AbstractCommand{

    @Override
    protected void executeOperation() throws Exception {
        IGenericDao<VrstaBolnice> vrstaBolniceDao = new VrstaBolniceDaoImpl(DBBroker.getInstance());
        
        response.setData(vrstaBolniceDao.loadAll());
    }
    
}
