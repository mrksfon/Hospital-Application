/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfejsi.IEntity;
import java.util.List;

/**
 *
 * @author Marenda
 */
public interface IGenericDao<T extends IEntity> {

    public T loadById(Integer id) throws Exception;

    public T create(T entity) throws Exception;

    public List<T> loadAll() throws Exception;

    public void update(T entity) throws Exception;

    public T delete(T entity) throws Exception;
}
