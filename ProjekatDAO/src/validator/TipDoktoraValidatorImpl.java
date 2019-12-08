/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import model.TipDoktora;

/**
 *
 * @author Marenda
 */
public class TipDoktoraValidatorImpl implements IValidator{
    private TipDoktora tipDoktora;

    public TipDoktoraValidatorImpl(TipDoktora tipDoktora) {
        this.tipDoktora = tipDoktora;
    }
    
    
    @Override
    public void validate() throws Exception {
        if(tipDoktora == null){
            throw new Exception("Tip doktora ne moze biti null");
        }
        
        if(tipDoktora.getId() != null){
            throw new Exception("Tip doktora je vec kreiran");
        }
        
        if(tipDoktora.getNaziv().trim().length() < 3){
            throw new Exception("Naziv tipa doktora mora imati bar 3 karaktera");
        }
    }
    
}
