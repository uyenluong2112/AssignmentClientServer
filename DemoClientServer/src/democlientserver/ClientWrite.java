/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democlientserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author admin
 */
public class ClientWrite extends Thread {

    Socket c1;

    public ClientWrite(Socket c1) {
        super();
        this.c1 = c1;
    }

    public void run() {
        try {
            OutputStream c1out;
            DataOutputStream dos;
            BufferedReader in;

            while (true) {
//                System.out.print(c1.getLocalPort() + ": ");
                c1out = c1.getOutputStream();
                dos = new DataOutputStream(c1out);
                in = new BufferedReader(new InputStreamReader(System.in));

                String message = in.readLine();
                dos.writeUTF(message);

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
