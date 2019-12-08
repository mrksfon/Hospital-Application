/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrstaBolniceController;

import java.util.List;
import model.VrstaBolnice;
import session.Session;
import transfer.Operation;
import transfer.request.RequestObject;
import transfer.request.ResponseObject;

/**
 *
 * @author Marenda
 */
public class VrstaBolniceController {
    public VrstaBolniceController(){
        
    }
    
    public List<VrstaBolnice> loadAll() throws Exception{
        ResponseObject response = Session.getInstance().sendRequest(new RequestObject(null,Operation.VRSTA_BOLNICE_LOAD_ALL));
        
        if(response.getErrorData() != null){
            throw response.getErrorData();
        }
        
        return (List<VrstaBolnice>) response.getData();
    }
}
