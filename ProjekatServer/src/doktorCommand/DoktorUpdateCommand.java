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
import validator.DoktorValidatorImpl;
import validator.IValidator;

/**
 *
 * @author Marenda
 */
public class DoktorUpdateCommand extends AbstractCommand {

    public DoktorUpdateCommand(RequestObject request) {
        this.request = request;
    }

    @Override
    protected void executeOperation() throws Exception {
        IGenericDao<Doktor> doktorDao = new DoktorDaoImpl(DBBroker.getInstance());
        
        try{
            
            doktorDao.update((Doktor) request.getData());
            System.out.println((Doktor) request.getData());
            response.setData(null);
        }catch(Exception ex){
            throw ex;
        }
    }

}
