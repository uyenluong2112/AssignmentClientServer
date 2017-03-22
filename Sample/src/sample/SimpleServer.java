package sample;


// SimpleServer.java: a simple multithreaded chat server program
//it allows chat between multiple clients.
//NOTE: it does not contain any exit code.

import java.net.*;
import java.util.LinkedList;
import java.io.*;
public class SimpleServer {
	static LinkedList<ClientMessInfo> messagqueue=new LinkedList<ClientMessInfo>();
	static LinkedList<Socket> clients=new LinkedList<Socket>();
	
	public  synchronized static void addclients(Socket s)
	{
		clients.add(s);
	}
	public synchronized static void addmessage(ClientMessInfo s)
	{
		messagqueue.add(s);
	}
	public synchronized static ClientMessInfo removemessage()
	{
		return messagqueue.removeFirst();
	}
  public static void main(String args[]) throws IOException {
    // Register service on port 1254
    ServerSocket s = new ServerSocket(1254);
    System.out.println("Server started");
    BroadCastThread bthread=new BroadCastThread();
    bthread.start();
    while(true){
    Socket s1=s.accept(); // Wait and accept a connection
    System.out.println("Server connected to "+s1.getPort());
    addclients(s1);
    new SerClientThread(s1,bthread).start();
     }
    // Get a communication stream associated with the socket
    
    // Close the connection, but not the server socket
   
   
  }
}
