/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentcs;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class BroadCast extends Thread {

    public BroadCast() {
        super();
    }

    public synchronized void sendMessage() {
        OutputStream c1out;
        try {
            if (MyServer.messagqueue.isEmpty()) {
                wait();
            }

            System.out.println("Got a message");
            ClientMessInfo mess = MyServer.removemessage();
            for (Socket clsocket : MyServer.clients) {

                c1out = clsocket.getOutputStream();

                DataOutputStream dos = new DataOutputStream(c1out);
                if (clsocket.getPort() != mess.c.getPort()) {
                    dos.writeUTF(mess.c.getPort() + ":" + mess.message);
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
