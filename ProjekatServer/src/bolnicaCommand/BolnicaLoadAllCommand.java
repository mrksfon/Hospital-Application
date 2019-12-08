/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolnicaCommand;

import command.AbstractCommand;
import dao.BolnicaDaoImpl;
import dao.IGenericDao;
import db.DBBroker;
import java.util.List;
import model.Bolnica;

/**
 *
 * @author Marenda
 */
public class BolnicaLoadAllCommand extends AbstractCommand{
    public BolnicaLoadAllCommand(){
        
    }
    @Override
    protected void executeOperation() throws Exception {
        IGenericDao<Bolnica> bolnicaDao = new BolnicaDaoImpl(DBBroker.getInstance());
        
        List<Bolnica> bolnice = bolnicaDao.loadAll();
        
        response.setData(bolnice);
    }
    
}
