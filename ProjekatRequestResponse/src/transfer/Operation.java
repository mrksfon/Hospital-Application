/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

/**
 *
 * @author Marenda
 */
public enum Operation {
    ZVANJE_CREATE,
    ZVANJE_LOAD_ALL,
    ZVANJE_UPDATE,
    ZVANJE_DELETE,
    
    DOKTOR_CREATE,
    DOKTOR_LOAD_ALL,
    DOKTOR_LOAD_BY_ID,
    DOKTOR_UPDATE,
    DOKTOR_DELETE,
    
    BOLNICA_LOAD_ALL,
    BOLNICA_KREIRAJ,
    BOLNICA_LOAD_BY_ID,
    
    TIP_DOKTORA_LOAD_ALL,
    TIP_DOKTORA_CREATE,
    TIP_DOKTORA_DELETE,
    
    VRSTA_BOLNICE_LOAD_ALL
    
    
}
