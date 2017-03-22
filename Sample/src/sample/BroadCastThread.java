package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class BroadCastThread extends Thread{

public BroadCastThread() {
	super();
}

public synchronized void sendMessage()
{
	OutputStream s1out;
	try {
	if(SimpleServer.messagqueue.isEmpty())
	{
		wait();
	} 
	
	
		System.out.println("Got a message");
		ClientMessInfo mess=SimpleServer.removemessage();
	    for(Socket clsocket:SimpleServer.clients)
	    {
	    	
			
			s1out = clsocket.getOutputStream();
				
	    	
	        DataOutputStream dos = new DataOutputStream (s1out);
	        if(clsocket.getPort()!=mess.s.getPort())
	           dos.writeUTF(mess.s.getPort()+":"+mess.message);  
	        
	    }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
public void run()
{
	
	while(true)
	{
		sendMessage();
		}
		
	
	
}

public synchronized void startmessage() {
	// TODO Auto-generated method stub
	notify();
}
}

