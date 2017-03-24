/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democlientserver;

import democlientserver.model.Client;
import democlientserver.model.Message;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SerClient extends Thread {

    Client client;
    BroadCast bthread;

    public SerClient(Client client, BroadCast bthread) {
        super();
        this.client = client;
        this.bthread = bthread;
    }

    public void run() {
        OutputStream c1out;

        try {
            while (true) {

                InputStream c1In = client.getSocket().getInputStream();

                DataInputStream dis = new DataInputStream(c1In);
                String newmess = new String(dis.readUTF());
                //System.out.println("recieved:"+newmess);

                client.getInRoom().pushMessage(client.getInRoom().getListMessage(),new Message(client.getSocket(), newmess));
                bthread.startmessage();
                Thread.sleep(10);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
