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
public interface IEntityDelete<IdType> extends IEntity{
    public String getTableName();
    
    public String getIdColumnName();
    
    public IdType getIdValue();
    
    
}
