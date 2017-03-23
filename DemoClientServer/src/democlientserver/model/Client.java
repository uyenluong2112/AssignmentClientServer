/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democlientserver.model;

import java.net.Socket;
import java.util.LinkedList;

/**
 *
 * @author admin
 */
public class Client {
    private Socket socket;
    private Room inRoom;  

    public Client(Socket socket, Room inRoom) {
        this.socket = socket;
        this.inRoom = inRoom;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Room getInRoom() {
        return inRoom;
    }

    public void setInRoom(Room inRoom) {
        this.inRoom = inRoom;
    }
    
    
}
