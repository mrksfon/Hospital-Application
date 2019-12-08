/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zvanjeController;

import java.util.List;
import model.Zvanje;
import session.Session;
import transfer.Operation;
import transfer.Status;
import transfer.request.RequestObject;
import transfer.request.ResponseObject;

/**
 *
 * @author Marenda
 */
public class ZvanjeController {
    
    
    public ZvanjeController(){
        
    }
    
    public Zvanje kreirajZvanje(String naziv)throws Exception{
        Zvanje z = new Zvanje();
        z.setNaziv(naziv);
        RequestObject request = new RequestObject(z, Operation.ZVANJE_CREATE);
        
        ResponseObject response = session.Session.getInstance().sendRequest(request);
        if(response.getStatus() == Status.SUCCESS){
            return (Zvanje) response.getData();
        }else{
            throw response.getErrorData();
        }
    }
    
    public List<Zvanje> loadAll() throws Exception{
        RequestObject request = new RequestObject(null, Operation.ZVANJE_LOAD_ALL);
        
        ResponseObject response = Session.getInstance().sendRequest(request);
        
        if(response.getStatus() == Status.ERROR){
            throw response.getErrorData();
        }
//        System.out.println(response.getData());
        return (List<Zvanje>) response.getData();
    }
    
    public void updateZvanje(Integer id,String naziv) throws Exception{
        Zvanje z = new Zvanje(id,naziv);

        ResponseObject response = Session.getInstance().sendRequest(new RequestObject(z, Operation.ZVANJE_UPDATE));
        
        if(response.getStatus() == Status.ERROR){
            throw response.getErrorData();
        }
    }
    
    public Zvanje deleteZvanje(Integer id ) throws Exception{
        Zvanje zvanjeDelete = new Zvanje();
        zvanjeDelete.setId(id);
        
        RequestObject request = new RequestObject(zvanjeDelete, Operation.ZVANJE_DELETE);
        
        ResponseObject response = Session.getInstance().sendRequest(request);
        
        if(response.getStatus() == Status.ERROR){
            throw response.getErrorData();
        }
        
        return (Zvanje) response.getData();
    }
}
