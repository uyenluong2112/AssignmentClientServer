/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentcs;

import assignmentcs.model.Client;
import assignmentcs.model.Message;
import assignmentcs.model.Room;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class FilterClientToRoom extends Thread {

    private Client connected;
    private Server server;

    public FilterClientToRoom(Server server, Client connected) {
        this.connected = connected;
        this.server = server;
    }

    public void run() {
        InputStream c1In = null;
        try {
            c1In = connected.getSocket().getInputStream();
            DataInputStream dis = new DataInputStream(c1In);
            String newmess = new String(dis.readUTF());
            if (newmess.contains("JPUB")) {
                server.publicRoom.getListClient().add(connected);
                System.out.print(connected.getSocket().getPort() + " connected to public room");
                new BroadCast(server.publicRoom.getListMessage(), server.publicRoom).start();

            } else if (newmess.contains("JPRIV")) {
                String passCode = newmess.split(" ")[1];
                for (Room room : server.privateListRoom) {
                    if (room.getPasscode() == passCode) {
                        room.getListClient().add(connected);
                        connected.setInRoom(room);
                        new BroadCast(room.getListMessage(), room).start();
                        break;
                    }
                }
                System.out.print(connected.getSocket().getPort() + " connected to private room");
            } else if (newmess.contains("CREATE")) {
                String passCode = newmess.split(" ")[1];
                Room newRoom = new Room(passCode, new LinkedList<Client>(), new LinkedList<Message>());
                newRoom.getListClient().add(connected);
                server.privateListRoom.add(newRoom);
                new BroadCast(newRoom.getListMessage(), newRoom).start();
                System.out.print(connected.getSocket().getPort() + " create a private room");
            }
            this.stop();
        } catch (IOException ex) {
            Logger.getLogger(FilterClientToRoom.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                c1In.close();
            } catch (IOException ex) {
                Logger.getLogger(FilterClientToRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
