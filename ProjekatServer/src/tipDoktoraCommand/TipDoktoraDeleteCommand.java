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

/**
 *
 * @author Marenda
 */
public class TipDoktoraDeleteCommand extends AbstractCommand{
    public TipDoktoraDeleteCommand(RequestObject request){
        this.request = request;
    }
    @Override
    protected void executeOperation() throws Exception {
        IGenericDao<TipDoktora> tipDoktoraDao = new TipDoktoraDaoImpl(DBBroker.getInstance());
        
        try{
            TipDoktora obrisan = tipDoktoraDao.delete((TipDoktora) request.getData());
            response.setData(obrisan);
        }catch(Exception ex){
            throw new Exception("Greska : " + ex.getMessage());
        }
    }
    
}
