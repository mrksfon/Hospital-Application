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
import dao.TipDoktoraDaoImpl;
import dao.VrstaBolniceDaoImpl;
import dao.ZvanjeDaoImpl;
import db.DBBroker;
import java.util.List;
import model.Bolnica;
import model.Doktor;
import model.TipDoktora;
import model.VrstaBolnice;
import model.Zvanje;
import transfer.request.RequestObject;
import validator.BolnicaValidatorImpl;

/**
 *
 * @author Marenda
 */
public class BolnicaCreateCommand extends AbstractCommand{
    public BolnicaCreateCommand(RequestObject request){
        this.request = request;
    }
    @Override
    protected void executeOperation() throws Exception {
        try{
            Bolnica bolnica = (Bolnica) request.getData();
            List<Doktor> doktori = bolnica.getDoktori();
            
            new BolnicaValidatorImpl(bolnica).validate();
            
            IGenericDao<Bolnica> bolnicaDao = new BolnicaDaoImpl(DBBroker.getInstance());
            IGenericDao<VrstaBolnice> vrstaBolniceDao = new VrstaBolniceDaoImpl(DBBroker.getInstance());
            IGenericDao<Zvanje> zvanjeDao = new ZvanjeDaoImpl(DBBroker.getInstance());
            IGenericDao<TipDoktora> tipDoktoraDao = new TipDoktoraDaoImpl(DBBroker.getInstance());
            IGenericDao<Doktor> doktorDao = new DoktorDaoImpl(DBBroker.getInstance());
            
            VrstaBolnice vb = vrstaBolniceDao.loadById(bolnica.getVrstaBolnice().getId());
            
            if(vb == null){
                throw new Exception("Vrsta bolnice ne postoji");
            }
            
            new BolnicaValidatorImpl(bolnica).validate();
            
            Bolnica kreiranaBolnica = bolnicaDao.create(bolnica);
            
            for(Doktor doktor : doktori){
                doktor.setBolnica(kreiranaBolnica);
                TipDoktora tipDoktora = tipDoktoraDao.loadById(doktor.getTipDoktora().getId());
                
                if(tipDoktora == null){
                    throw new Exception("Tip doktora " + doktor.getTipDoktora().getNaziv() + " ne postoji");
                }
                Zvanje zvanje = zvanjeDao.loadById(doktor.getZvanje().getId());
                
                if(zvanje == null){
                    throw new Exception("Zvanje : "+ doktor.getZvanje().getNaziv() + " ne postoji");
                }
                
                Doktor kreiranDoktor = doktorDao.create(doktor);
                kreiranaBolnica.dodajDoktora(kreiranDoktor);
            }
            response.setData(kreiranaBolnica);
        }catch(Exception e){
            throw new Exception("Greska : "+e.getMessage());
        }
    }
    
}
