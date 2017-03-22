/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentcs;

import java.net.*;
import java.util.LinkedList;
import java.io.*;
public class MyServer {
	static LinkedList<ClientMessInfo> messagqueue=new LinkedList<ClientMessInfo>();
	static LinkedList<Socket> clients=new LinkedList<Socket>();
	
	public  synchronized static void addclients(Socket c)
	{
		clients.add(c);
	}
	public synchronized static void addmessage(ClientMessInfo c)
	{
		messagqueue.add(c);
	}
	public synchronized static ClientMessInfo removemessage()
	{
		return messagqueue.removeFirst();
	}
  public static void main(String args[]) throws IOException {
    // Register service on port 1254
    ServerSocket c = new ServerSocket(1456);
    System.out.println("Server started");
    BroadCast bthread=new BroadCast();
    bthread.start();
    while(true){
    Socket c1=c.accept(); // Wait and accept a connection
    System.out.println("Server connected to "+c1.getPort());
    addclients(c1);
    new SerClient(c1,bthread).start();
     }
      
   
  }
}
