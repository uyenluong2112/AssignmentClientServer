/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democlientserver.model;

import java.net.Socket;

/**
 *
 * @author admin
 */
public class Message {
    
    private Socket socket;
    private String message;

    public Message(Socket socket, String message) {
        this.socket = socket;
        this.message = message;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
       
}
