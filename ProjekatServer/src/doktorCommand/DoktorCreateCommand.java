/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doktorCommand;

import command.AbstractCommand;
import dao.DoktorDaoImpl;
import dao.IGenericDao;
import dao.TipDoktoraDaoImpl;
import dao.ZvanjeDaoImpl;
import db.DBBroker;
import model.Doktor;
import model.TipDoktora;
import model.Zvanje;
import transfer.request.RequestObject;
import validator.DoktorValidatorImpl;

/**
 *
 * @author Marenda
 */
public class DoktorCreateCommand extends AbstractCommand{
    public DoktorCreateCommand(RequestObject request){
        this.request = request;
    }
    @Override
    protected void executeOperation() throws Exception {
        try{
            Doktor doktor = (Doktor) request.getData();
            new DoktorValidatorImpl(doktor).validate();
            
            IGenericDao<Doktor> doktorDao = new DoktorDaoImpl(DBBroker.getInstance());
            IGenericDao<Zvanje> zvanjeDao = new ZvanjeDaoImpl(DBBroker.getInstance());
            IGenericDao<TipDoktora> tipDoktoraDao = new TipDoktoraDaoImpl(DBBroker.getInstance());
            
            Zvanje zvanje = zvanjeDao.loadById(doktor.getZvanje().getId());
            
            if(zvanje == null){
                throw new Exception("Zvanje ne postoji");
            }
            
            TipDoktora tipDoktora = tipDoktoraDao.loadById(doktor.getTipDoktora().getId());
            
            if(tipDoktora == null){
                throw new Exception("Tip doktora ne postoji");
            }
            
            Doktor kreiranDoktor = doktorDao.create(doktor);
            
            response.setData(kreiranDoktor);
        }catch(Exception ex){
            throw new Exception("Greska : " + ex.getMessage());
        }
    }
    
}
