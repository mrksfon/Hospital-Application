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
import transfer.request.RequestObject;

/**
 *
 * @author Marenda
 */
public class DoktorDeleteCommand extends AbstractCommand {

    public DoktorDeleteCommand(RequestObject request) {
        this.request = request;
    }

    @Override
    protected void executeOperation() throws Exception {
        IGenericDao<Doktor> doktorDao = new DoktorDaoImpl(DBBroker.getInstance());
        
        try{
            Doktor doktorZaBrisanje = (Doktor) request.getData();
            doktorDao.delete(doktorZaBrisanje);
            
            response.setData(doktorZaBrisanje);
        }catch(Exception ex){
            throw ex;
        }
        
        
    }

}
