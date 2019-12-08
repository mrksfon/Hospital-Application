/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import db.DBBroker;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Marenda
 */
public class ServerController {
    private Server server;
    
    public ServerController(){
        
    }
    
    public void start(int port) throws Exception{
        try{
            if(!DBBroker.getInstance().isConnected()){
                DBBroker.getInstance().connect();
//                System.out.println("Povezan sa bazom");
            }
        }catch(Exception e){
            throw new Exception("Nije moguce povezati se sa bazom" + e.getMessage());
        }
        if(server == null || !server.isStarted()){
            server = new Server(port);
            server.start();
            
            return;
        }
        
        throw new IOException("Server je vec pokrenut na portu : "+server.getPort());
    }
    
    public void stop() throws IOException{
        try{
            if(DBBroker.getInstance().isConnected()){
                DBBroker.getInstance().disconnect();
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        if(server != null && server.isStarted()){
            server.stopServer();
            server = null;
        }
    }
    
    public int getPort(){
        return server.getPort();
    }
}
