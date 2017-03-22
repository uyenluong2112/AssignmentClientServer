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
    Socket c1 = new Socket("localhost",1456);
    new ClientRead(c1).start();
    
    
    while(true){
    OutputStream c1out =c1.getOutputStream();
    DataOutputStream dos = new DataOutputStream (c1out);
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String message = in.readLine();
    dos.writeUTF(message);
   
    }
  
  }
}
