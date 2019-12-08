/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipDoktoraCommand;

import command.AbstractCommand;
import dao.IGenericDao;
import dao.TipDoktoraDaoImpl;
import db.DBBroker;
import model.TipDoktora;
import transfer.request.RequestObject;
import validator.IValidator;
import validator.TipDoktoraValidatorImpl;

/**
 *
 * @author Marenda
 */
public class TipDoktoraCreateCommand extends AbstractCommand{
    public TipDoktoraCreateCommand(RequestObject request){
        this.request = request;
    }
    @Override
    protected void executeOperation() throws Exception {
        IGenericDao<TipDoktora> tipDoktoraDao = new TipDoktoraDaoImpl(DBBroker.getInstance());
        
        try{
            TipDoktora tipDoktora = (TipDoktora) request.getData();
            
            IValidator validator = new TipDoktoraValidatorImpl(tipDoktora);
            
            validator.validate();
            
            TipDoktora sacuvan = tipDoktoraDao.create(tipDoktora);
            response.setData(sacuvan);
        }catch(Exception ex){
            throw new Exception("Greska : "+ex.getMessage());
        }
    }
    
}
