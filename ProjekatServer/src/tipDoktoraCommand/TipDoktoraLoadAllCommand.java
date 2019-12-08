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

/**
 *
 * @author Marenda
 */
public class TipDoktoraLoadAllCommand extends AbstractCommand{

    @Override
    protected void executeOperation() throws Exception {
        IGenericDao<TipDoktora> tipDoktraDao = new TipDoktoraDaoImpl(DBBroker.getInstance());
        
        try{
            response.setData(tipDoktraDao.loadAll());
        }catch(Exception ex){
            throw new Exception("Greska prilikom ucitavanja tipa doktora");
        }
    }
    
}
