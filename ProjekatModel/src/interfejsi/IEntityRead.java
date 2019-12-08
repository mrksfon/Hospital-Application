/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfejsi;

/**
 *
 * @author Marenda
 */
public interface IEntityRead extends IEntity{
    
    public String[] getJoins();
    
    public String[] getColumnNamesForSelect();
    
    public void fillAttributes(Object[] values) throws Exception;
    
}
