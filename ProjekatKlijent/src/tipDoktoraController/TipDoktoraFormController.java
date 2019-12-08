/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipDoktoraController;

import gui.KreirajTipDoktora;
import gui.PrikazSvihTipovaDoktora;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marenda
 */
public class TipDoktoraFormController {

    private static TipDoktoraFormController instance;

    private List<PrikazSvihTipovaDoktora> formeZaPrikaz;

    private TipDoktoraFormController() {
        formeZaPrikaz = new ArrayList<>();
    }

    public static TipDoktoraFormController getInstance() {
        if (instance == null) {
            instance = new TipDoktoraFormController();
        }
        return instance;
    }
    
    public void prikaziFormuZaKreirajne(){
        KreirajTipDoktora kreiraj = new KreirajTipDoktora();
        kreiraj.setVisible(true);
    }
    
    public void prikaziSveTipoveDoktora(){
        PrikazSvihTipovaDoktora prikaz = new PrikazSvihTipovaDoktora();
        prikaz.setVisible(true);
        formeZaPrikaz.add(prikaz);
    }
    
    public void tipDoktoraChanged(){
        for(PrikazSvihTipovaDoktora prikaz : formeZaPrikaz){
            prikaz.initForma();
        }
    }
    
    public void zatvoriFormuZaPrikaz(PrikazSvihTipovaDoktora forma){
        formeZaPrikaz.remove(forma);
    }

}
