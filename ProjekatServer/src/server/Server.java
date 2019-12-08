/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import client.ClientThread;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Marenda
 */
public class Server extends Thread {

    private final ServerSocket serverSocket;
    private final int port;

    private boolean started;
    private final ClientThread[] clients;
    private final int maxClients = 10;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        this.port = port;
        started = true;
        clients = new ClientThread[maxClients];
    }

    @Override
    public void run() {
        while (started) {
            try {
                Socket clientSocket = serverSocket.accept();

                int emptyIndex = getFirstEmptySlotIndex();
                if (emptyIndex < maxClients) {
                    try {
                        ClientThread clientThread = new ClientThread(clientSocket);
                        clients[emptyIndex] = clientThread;
                        clientThread.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                started = false;
                try {
                    serverSocket.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private int getFirstEmptySlotIndex() {
        for(int i = 0; i < clients.length;i++){
            if(clients[i] == null){
                return i;
            }
        }
        return clients.length + 1;
    }
    
    public boolean isStarted(){
        return isAlive();
    }
    
    public void stopServer() throws IOException{
        started = false;
        removeClients();
        serverSocket.close();
    }

    private void removeClients() {
        for(int i = 0;i < clients.length;i++){
            if(clients[i] != null){
                try{
                    clients[i].stopClient();
                }catch(IOException e){
                    System.out.println("Greskas prilikom brisanja klijenta iz niza");
                    e.printStackTrace();
                }
            }
        }
    }
    
    public int getPort(){
        return port;
    }

}
