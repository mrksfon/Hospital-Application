/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolnicaController;

import java.util.ArrayList;
import java.util.List;
import model.Bolnica;
import model.Doktor;
import model.VrstaBolnice;
import session.Session;
import transfer.Operation;
import transfer.Status;
import transfer.request.RequestObject;
import transfer.request.ResponseObject;

/**
 *
 * @author Marenda
 */
public class BolnicaController {

    private List<VrstaBolnice> vrstaBolniceIzBaze;

    public BolnicaController() {

    }

    public void setVrsteBolniceIzBaze(List<VrstaBolnice> vrstaBolniceIzBaze) {
        this.vrstaBolniceIzBaze = vrstaBolniceIzBaze;
    }

    public List<Bolnica> loadAll() throws Exception {
        ResponseObject response = Session.getInstance().sendRequest(new RequestObject(null, Operation.BOLNICA_LOAD_ALL));

        if (response.getStatus() == Status.ERROR) {
            throw response.getErrorData();
        }
        return (List<Bolnica>) response.getData();

    }
    
    public Bolnica save(String naziv,String maticniBroj,String poreskiBroj,String opis,VrstaBolnice vrstaBolnice,List<Doktor> doktori) throws Exception{
        Bolnica b = new Bolnica(0, naziv, maticniBroj, poreskiBroj, opis,vrstaBolnice);
        b.setDoktori(doktori);
        
        ResponseObject response = Session.getInstance().sendRequest(new RequestObject(b, Operation.BOLNICA_KREIRAJ));
        
        if(response.getStatus() == Status.ERROR){
            throw response.getErrorData();
        }
        return (Bolnica) response.getData();
    }
    
    public List<VrstaBolnice> pronadjiVrsteBolnice(String filter){
        if(filter.isEmpty()){
            return vrstaBolniceIzBaze;
        }
        
        List<VrstaBolnice> vrste = new ArrayList<>();
        
        for(VrstaBolnice vb : vrstaBolniceIzBaze){
            if(vb.getNaziv().toLowerCase().contains(filter)){
                vrste.add(vb);
            }
        }
        return vrste;
    }
    
    public Bolnica loadById(Integer id) throws Exception{
        RequestObject requestObject = new RequestObject(id, Operation.BOLNICA_LOAD_BY_ID);
        
        ResponseObject response = Session.getInstance().sendRequest(requestObject);
        
        if(response.getStatus() == Status.ERROR){
            throw response.getErrorData();
        }
        return (Bolnica) response.getData();
    }
}
