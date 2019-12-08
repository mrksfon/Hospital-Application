/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zvanjeCommand;

import command.AbstractCommand;
import dao.IGenericDao;
import dao.ZvanjeDaoImpl;
import db.DBBroker;
import model.Zvanje;
import transfer.request.RequestObject;
import validator.IValidator;
import validator.ZvanjeValidatorImpl;

/**
 *
 * @author Marenda
 */
public class ZvanjeCreateCommand extends AbstractCommand {

    public ZvanjeCreateCommand(RequestObject request) {
        this.request = request;
    }

    @Override
    protected void executeOperation() throws Exception {
        try {
            Zvanje zvanje = (Zvanje) request.getData();

            IValidator validatorZvanje = new ZvanjeValidatorImpl(zvanje);
            validatorZvanje.validate();
            IGenericDao<Zvanje> zvanjeDao = new ZvanjeDaoImpl(DBBroker.getInstance());
            
            Zvanje created = zvanjeDao.create(zvanje);
            response.setData(created);
        }catch(Exception ex){
            throw new Exception("Gresja prilikom cuvanja zvanja" + ex.getMessage());
        }
    }

}
