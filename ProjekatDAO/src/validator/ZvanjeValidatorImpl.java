/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import model.Zvanje;

/**
 *
 * @author Marenda
 */
public class ZvanjeValidatorImpl implements IValidator{
    private Zvanje zvanje;

    public ZvanjeValidatorImpl(Zvanje zvanje) {
        this.zvanje = zvanje;
    }
    
    
    @Override
    public void validate() throws Exception {
        if(zvanje == null){
            throw new Exception("Zvanje ne moze biti null");
        }
        
        if(zvanje.getId() != null){
            throw new Exception("Zvanje vec postoji u bazi");
        }
        
        if(zvanje.getNaziv().trim().isEmpty()){
            throw new Exception("Morate uneti naziv zvanja");
        }
    }
    
}
