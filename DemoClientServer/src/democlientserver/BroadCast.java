/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democlientserver;

import democlientserver.model.Client;
import democlientserver.model.Message;
import democlientserver.model.Room;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.LinkedList;

/**
 *
 * @author admin
 */
public class BroadCast extends Thread{
    
    private LinkedList<Message> listMessage;    
    private Room room;

    public BroadCast(LinkedList<Message> listMessage, Room room) {
        super();
        this.listMessage = listMessage;
        this.room = room;
    }
    public synchronized void sendMessage() {
        OutputStream c1out;
        try {
            if (true) {
                wait();
            }
            System.out.println("Got a message");
            Message mess = listMessage.getLast();
            for (Client client : room.getListClient()) {

                OutputStream clientOS = client.getSocket().getOutputStream();

                DataOutputStream dos = new DataOutputStream(clientOS);
                if (client.getSocket().getPort() != mess.getSocket().getPort()) {
                    dos.writeUTF(mess.getSocket().getPort() + ":" + mess.getMessage());
                }

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void run() {

        while (true) {
            sendMessage();
        }

    }

    public synchronized void startmessage() {
        // TODO Auto-generated method stub
        notify();
    }
}
