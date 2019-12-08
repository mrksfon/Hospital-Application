/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zvanjeCommand;

import command.AbstractCommand;
import dao.IGenericDao;
import dao.ZvanjeDaoImpl;
import db.DBBroker;
import model.Zvanje;
import transfer.request.RequestObject;

/**
 *
 * @author Marenda
 */
public class ZvanjeUpdateCommand extends AbstractCommand{
    public ZvanjeUpdateCommand(RequestObject request){
        this.request = request;
    }
    @Override
    protected void executeOperation() throws Exception {
        IGenericDao<Zvanje> zvanjeDao = new ZvanjeDaoImpl(DBBroker.getInstance());
//        System.out.println("dosao ovde");
        try{
            zvanjeDao.update((Zvanje) request.getData());
            
            response.setData(null);
        }catch(Exception ex){
            throw new Exception("Greska prilikom azuriranja zvanja");
        }
    }
    
}
