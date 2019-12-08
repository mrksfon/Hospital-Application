/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import db.DBBroker;
import java.sql.SQLException;
import transfer.Status;
import transfer.request.RequestObject;
import transfer.request.ResponseObject;

/**
 *
 * @author Marenda
 */
public abstract class AbstractCommand {

    protected RequestObject request;
    protected ResponseObject response = new ResponseObject("", Status.ERROR, new Exception("NO OPERATION"));

    public final void execute() throws Exception {
        try {
            startTransaction();
            executeOperation();
            commit();
            response.setErrorData(null);
            response.setStatus(Status.SUCCESS);
        } catch (Exception ex) {
            response.setStatus(Status.ERROR);
            response.setErrorData(ex);
            rollback();
        }
    }

    protected abstract void executeOperation() throws Exception;

    private void startTransaction() throws SQLException {
        DBBroker.getInstance().startTransaction();
    }

    private void commit() throws SQLException {
        DBBroker.getInstance().commit();
    }

    private void rollback() throws SQLException {
        DBBroker.getInstance().rollback();
    }

    public ResponseObject getResponseObject() {
        return response;
    }
}
