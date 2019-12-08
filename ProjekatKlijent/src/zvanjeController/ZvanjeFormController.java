/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zvanjeController;

import enumeration.ZvanjeState;
import gui.KreirajIliIzmeniZvanje;
import gui.PrikazIzabranogZvanja;
import gui.PrikazSvihZvanja;
import java.util.ArrayList;
import java.util.List;
import model.Zvanje;

/**
 *
 * @author Marenda
 */
public class ZvanjeFormController {

    private static ZvanjeFormController instance;
    private List<PrikazSvihZvanja> listaZvanja;

    static {
        instance = new ZvanjeFormController();
    }

    public ZvanjeFormController() {
        listaZvanja = new ArrayList<>();
    }

    public static ZvanjeFormController getInstance() {
        return instance;
    }

    public void openEditZvanjeForm(Zvanje zvanje) {
        KreirajIliIzmeniZvanje kreirajZvanje = new KreirajIliIzmeniZvanje();
        kreirajZvanje.setState(ZvanjeState.UPDATE);
        kreirajZvanje.setValues(zvanje);
        kreirajZvanje.setVisible(true);

    }

    public void zvanjeChanged() {
        for (PrikazSvihZvanja prikazZvanja : listaZvanja) {
            prikazZvanja.popuniTabelu();
        }
    }

    public void openKreirajZvanjeForm() {
        KreirajIliIzmeniZvanje kreirajZvanje = new KreirajIliIzmeniZvanje();
        kreirajZvanje.setState(ZvanjeState.CREATE);
        kreirajZvanje.setVisible(true);
    }

    public void prikaziZvanjaForm() {
        PrikazSvihZvanja prikaz = new PrikazSvihZvanja();
        listaZvanja.add(prikaz);
        prikaz.setVisible(true);
    }

    public void prikaziIzabranoZvanje(Zvanje selektovanoZvanje) throws Exception {
        PrikazIzabranogZvanja prikaz = new PrikazIzabranogZvanja();
        prikaz.setZvanje(selektovanoZvanje);
        prikaz.setVisible(true);
        
    }

    public void zatvoriPrikaz(PrikazSvihZvanja prikaz) {
        listaZvanja.remove(prikaz);
    }
}
