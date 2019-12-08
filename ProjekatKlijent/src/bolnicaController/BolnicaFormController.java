/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolnicaController;

import gui.KreirajBolnicu;
import gui.PrikazIzabraneBolnice;
import gui.PrikazSvihBolnica;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marenda
 */
public class BolnicaFormController {

    private static BolnicaFormController instance;
    private List<PrikazSvihBolnica> formeZaPrikaz;
    private List<PrikazIzabraneBolnice> bolniceZaPrikaz;

    private BolnicaFormController() {
        formeZaPrikaz = new ArrayList<>();
        bolniceZaPrikaz = new ArrayList<>();
    }

    public static BolnicaFormController getInstance() {
        if (instance == null) {
            instance = new BolnicaFormController();
        }
        return instance;
    }
    
    public void prikaziFormuZaPrikazSvih(){
        PrikazSvihBolnica prikaz = new PrikazSvihBolnica();
        prikaz.setVisible(true);
        formeZaPrikaz.add(prikaz);
    }
    
    public void prikaziFormuZaKreiranjeBolnica(){
        KreirajBolnicu kreiraj = new KreirajBolnicu();
        kreiraj.setVisible(true);
    }
   
    public void prikaziIzabranuBolnicu(Integer id) throws Exception{
        PrikazIzabraneBolnice prikazIzabrane = new PrikazIzabraneBolnice();
        prikazIzabrane.setId(id);
        prikazIzabrane.setVisible(true);
        bolniceZaPrikaz.add(prikazIzabrane);
    }
    
    public synchronized void bolnicaChanged(){
        for(PrikazSvihBolnica prikaz : formeZaPrikaz){
            prikaz.initForma();
        }
    }
    
    public synchronized void izabranaBolnicaChanged(){
        for (PrikazIzabraneBolnice bolnica : bolniceZaPrikaz) {
            bolnica.osvezi();
        }
    }
    
    
}
