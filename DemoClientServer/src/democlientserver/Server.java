/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democlientserver;

import democlientserver.model.Client;
import democlientserver.model.Message;
import democlientserver.model.Room;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Server {

    Room publicRoom;
    LinkedList<Message> messagePublicRoom;
    LinkedList<Room> privateListRoom;

    public Server() {
        publicRoom = new Room(null, new LinkedList<Client>(),new LinkedList<Message>());
        privateListRoom = new LinkedList<Room>();
    }

    public void Start(int port) {
        try {
            ServerSocket c = new ServerSocket(port);
            System.out.println("Server started");           

            while (true) {
                Socket c1 = c.accept(); // Wait and accept a connection
                System.out.println("Server connected to " + c1.getPort());
                new FilterClientToRoom(this, new Client(c1, null)).start();
            }

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
