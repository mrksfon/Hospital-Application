/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import command.AbstractCommand;
import command.CommandResolver;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.Operation;
import transfer.request.RequestObject;
import transfer.request.ResponseObject;

/**
 *
 * @author Marenda
 */
public class ClientThread extends Thread{
    private final Socket client;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;
    private boolean started;
    
    public ClientThread(Socket client) throws IOException{
        this.client = client;
        out = new ObjectOutputStream(client.getOutputStream());
        in = new ObjectInputStream(client.getInputStream());
        started = true;
    }

    @Override
    public void run() {
        while(started){
            try{
                RequestObject request = (RequestObject) in.readObject();
                
                Operation operation = request.getOperation();
                
                AbstractCommand command = CommandResolver.resolve(operation, request);
                
                command.execute();
                
                ResponseObject response = command.getResponseObject();
                
                out.writeObject(response);
                out.flush();
            }catch(Exception e){
                try {
                    stopClient();
                } catch (IOException ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void stopClient() throws IOException {
        started = false;
        if(client != null){
            client.close();
        }
    }
    
    
}
