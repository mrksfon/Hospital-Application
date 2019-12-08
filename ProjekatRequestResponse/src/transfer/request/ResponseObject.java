/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.request;

import java.io.Serializable;
import transfer.Status;

/**
 *
 * @author Marenda
 */
public class ResponseObject implements Serializable{
    private Object data;
    private Status status;
    private Exception errorData;

    public ResponseObject(Object data, Status status, Exception errorData) {
        this.data = data;
        this.status = status;
        this.errorData = errorData;
    }

    public ResponseObject() {
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Exception getErrorData() {
        return errorData;
    }

    public void setErrorData(Exception errorData) {
        this.errorData = errorData;
    }
    
    
}
