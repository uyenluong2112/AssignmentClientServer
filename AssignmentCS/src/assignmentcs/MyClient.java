/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentcs;

import java.net.*;
import java.io.*;

public class MyClient {

    public static void main(String args[]) throws IOException {
        // Open connection at port 1456
        Socket c1 = new Socket("localhost", 1456);
        new ClientRead(c1).start();

        new ClientWrite(c1).start();
    }
}
