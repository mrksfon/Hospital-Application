/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.request;

import java.io.Serializable;
import transfer.Operation;

/**
 *
 * @author Marenda
 */
public class RequestObject implements Serializable{
   private Object data;
   private Operation operation;

    public RequestObject(Object data, Operation operation) {
        this.data = data;
        this.operation = operation;
    }

    public RequestObject() {
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
   
   
}
