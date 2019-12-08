/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import model.Bolnica;

/**
 *
 * @author Marenda
 */
public class BolnicaValidatorImpl implements IValidator{
    private Bolnica bolnica;
    
    public BolnicaValidatorImpl(Bolnica bolnica){
        this.bolnica = bolnica;
    }
    @Override
    public void validate() throws Exception {
        if(bolnica == null){
            throw new Exception("Bolnica ne moze biti null");
        }
        
        if(bolnica.getNaziv().trim().length() < 4){
            throw new Exception("Naziv bolnice mora imati bar 3 karaktera");
        }
        
        if(bolnica.getVrstaBolnice() == null){
            throw new Exception("Morate izabrati vrstu bolnice");
        }
        
        if(bolnica.getVrstaBolnice().getId() == null){
            throw new Exception("Vrsta bolnice mora postojati");
        }
    }
    
}
