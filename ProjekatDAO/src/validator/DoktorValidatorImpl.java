/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import model.Doktor;

/**
 *
 * @author Marenda
 */
public class DoktorValidatorImpl implements IValidator{
    private Doktor doktor;
    
    public DoktorValidatorImpl(Doktor doktor){
        this.doktor = doktor;
    }
    @Override
    public void validate() throws Exception {
        if(doktor == null){
            throw new Exception("Doktor ne moze biti null");
        }
        
        if(doktor.getBolnica() == null){
            throw new Exception("Morate izabrati bolnicu za doktora");
        }
        
        if(doktor.getZvanje() == null){
            throw new Exception("Morati izabrati zvanje za doktora");
        }
        
        if(doktor.getIme() == null){
            throw new Exception("Doktor mora imati ime");
        }
        
        if(doktor.getPrezime() == null){
            throw new Exception("Doktor mora imati prezime");
        }
        
        if(doktor.getIme().trim().length() < 3){
            throw new Exception("Ime doktora mora imati bar 3 karaktera");
        }
        
        if(doktor.getPrezime().trim().length() < 3){
            throw new Exception("Prezime doktora mora imati bar 3 karaktera");
        }
    }
    
}
