package sample;

// SimpleClient.java: a simple chat client program
import java.net.*;
import java.io.*;
public class SimpleClient {
  public static void main(String args[]) throws IOException {
    // Open your connection to a server, at port 1254
    Socket s1 = new Socket("localhost",1254);
    new ClientRead(s1).start();
    
    // Get an input file handle from the socket and read the input
    while(true){
    //System.out.println("writing rmessage");
    OutputStream s1out = s1.getOutputStream();
    DataOutputStream dos = new DataOutputStream (s1out);
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String message = in.readLine();
    dos.writeUTF(message);
   
   //s1.close(); 
    
    // When done, just close the connection and exit
    }
  
  }
}
