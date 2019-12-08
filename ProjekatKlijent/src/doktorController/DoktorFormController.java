/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doktorController;

import enumeration.DoktorState;
import gui.KreirajIzmeniDoktora;
import gui.PrikaziSveDoktore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marenda
 */
public class DoktorFormController {

    private static DoktorFormController instance;
    private List<PrikaziSveDoktore> listaPrikaz;

    private DoktorFormController() {
        listaPrikaz = new ArrayList<>();
    }

    public static DoktorFormController getInstance() {
        if (instance == null) {
            instance = new DoktorFormController();
        }
        return instance;
    }
    
    public void openCreateDoctorForm() throws Exception{
        KreirajIzmeniDoktora createDoctor = new KreirajIzmeniDoktora();
        createDoctor.setVisible(true);
    }
    
    public void openPrikazDoktora(){
        PrikaziSveDoktore prikaz = new PrikaziSveDoktore();
        prikaz.setVisible(true);
        listaPrikaz.add(prikaz);
    }
    
    public void zatvoriPrikazSvihDoktora(PrikaziSveDoktore forma){
        for(PrikaziSveDoktore prikazSvihDoktora : listaPrikaz){
            if(prikazSvihDoktora == forma){
                listaPrikaz.remove(forma);
                return;
            }
        }
    }
    
    public void openUpdateDoctorForm(Integer id) throws Exception{
        KreirajIzmeniDoktora izmeni = new KreirajIzmeniDoktora();
        izmeni.setState(DoktorState.IZMENI);
        izmeni.setValues(id);
        izmeni.setVisible(true);
    }
    public void doktorChanged(){
        for(PrikaziSveDoktore prikazSvihDoktora  : listaPrikaz){
            prikazSvihDoktora.osvezi();
        }
    }
    
    

    
}
