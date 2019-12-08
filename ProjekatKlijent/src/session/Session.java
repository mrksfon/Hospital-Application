/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.request.RequestObject;
import transfer.request.ResponseObject;

/**
 *
 * @author Marenda
 */
public class Session {

    private static Session instance;
    private Socket socket;
    private boolean connected;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    private Session() {
        connected = false;
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public void connect(String host, int port) throws IOException {
        socket = new Socket(host, port);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
        connected = true;
    }

    public synchronized ResponseObject sendRequest(RequestObject request) throws Exception {
        if (!connected) {
            throw new Exception("Konekcija sa serverom nije uspostavljena");
        }

        try {
            out.writeObject(request);
            out.flush();
        } catch (Exception ex) {
            throw new Exception("Greska prilikom slanja zahteva serveru" + ex.getMessage());
        }
        return (ResponseObject) in.readObject();
    }

}
