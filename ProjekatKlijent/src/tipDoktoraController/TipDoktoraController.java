/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipDoktoraController;

import java.util.List;
import model.TipDoktora;
import session.Session;
import transfer.Operation;
import transfer.Status;
import transfer.request.RequestObject;
import transfer.request.ResponseObject;

/**
 *
 * @author Marenda
 */
public class TipDoktoraController {
    public TipDoktoraController(){
        
    }
    
    public TipDoktora create(String naziv) throws Exception{
        TipDoktora tipDoktora = new TipDoktora();
        tipDoktora.setNaziv(naziv);
        
        ResponseObject response = session.Session.getInstance().sendRequest(new RequestObject(tipDoktora, Operation.TIP_DOKTORA_CREATE));
        
        if(response.getStatus() == Status.ERROR){
            throw response.getErrorData();
        }
        return (TipDoktora) response.getData();
    }
    
    public List<TipDoktora> loadAll() throws Exception{
        ResponseObject response = Session.getInstance().sendRequest(new RequestObject(null, Operation.TIP_DOKTORA_LOAD_ALL));
        
        if(response.getStatus() == Status.ERROR){
            throw response.getErrorData();
        }
        
        return (List<TipDoktora>) response.getData();
    }
    
    public TipDoktora delete(TipDoktora izabranTip) throws Exception{
        RequestObject requestObject = new RequestObject(izabranTip, Operation.TIP_DOKTORA_DELETE);
        
        ResponseObject response = Session.getInstance().sendRequest(requestObject);
        
        if(response.getStatus() == Status.ERROR){
            throw response.getErrorData();
        }
        return (TipDoktora) response.getData();
    }
}
