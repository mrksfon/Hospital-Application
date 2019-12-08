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
public interface IEntityUpdate<IdType> extends IEntity{
    
    public String[] getUpdateColumnNames();
    
    public String[] getUpdateColumnValues();
    
    public String getTableName();
    
    public String getIdColumnName();
    
    public IdType getIdValue();
    
}
