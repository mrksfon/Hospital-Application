/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolnicaCommand;

import command.AbstractCommand;
import dao.BolnicaDaoImpl;
import dao.DoktorDaoImpl;
import dao.IGenericDao;
import db.DBBroker;
import java.util.List;
import model.Bolnica;
import model.Doktor;
import transfer.request.RequestObject;

/**
 *
 * @author Marenda
 */
public class BolnicaLoadByIdCommand extends AbstractCommand{
    
    public BolnicaLoadByIdCommand(RequestObject request){
        this.request = request;
    }

    @Override
    protected void executeOperation() throws Exception {
        try{
            Integer id = (Integer) request.getData();
            
            IGenericDao<Bolnica> bolnicaDao = new BolnicaDaoImpl(DBBroker.getInstance());
            IGenericDao<Doktor> doktorDao = new DoktorDaoImpl(DBBroker.getInstance());
            
            Bolnica bolnica = bolnicaDao.loadById(id);
            
            List<Doktor> doktori = doktorDao.loadAll();
            
            for(Doktor doktor : doktori){
                if(doktor.getBolnica().equals(bolnica)){
                    bolnica.dodajDoktora(doktor);
                }
            }
            response.setData(bolnica);
        }catch(Exception ex){
            throw ex;
        }
    }
    
}
