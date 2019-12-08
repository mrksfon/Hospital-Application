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
public class DoktorLoadByIdCommand extends AbstractCommand{
    public DoktorLoadByIdCommand(RequestObject request){
        this.request = request;
    }
    @Override
    protected void executeOperation() throws Exception {
        IGenericDao<Doktor> doktorDao = new DoktorDaoImpl(DBBroker.getInstance());
        
        Integer id = (Integer) request.getData();
        
        System.out.println(id);
        
        Doktor doktor = doktorDao.loadById((Integer) request.getData());
        
        response.setData(doktor);
    }
    
}
