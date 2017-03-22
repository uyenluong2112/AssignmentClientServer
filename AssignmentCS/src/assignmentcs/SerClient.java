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

public class SerClient extends Thread{
   Socket c1;
   BroadCast bthread;
public SerClient(Socket c1, BroadCast bthread) {
	super();
	this.c1 = c1;
	this.bthread=bthread;
}

public void run()
{
	OutputStream c1out;
	
	try {
	while(true){
		
		InputStream c1In = c1.getInputStream();
		
	    DataInputStream dis = new DataInputStream(c1In);
	    String newmess=new String(dis.readUTF());
	    //System.out.println("recieved:"+newmess);
	
	   MyServer.addmessage(new ClientMessInfo(c1,newmess));
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
