package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SerClientThread extends Thread{
   Socket s1;
   BroadCastThread bthread;
public SerClientThread(Socket s1, BroadCastThread bthread) {
	super();
	this.s1 = s1;
	this.bthread=bthread;
}

public void run()
{
	OutputStream s1out;
	
	try {
	while(true){
		
		InputStream s1In = s1.getInputStream();
		
	    DataInputStream dis = new DataInputStream(s1In);
	    String newmess=new String(dis.readUTF());
	    //System.out.println("recieved:"+newmess);
	
	   SimpleServer.addmessage(new ClientMessInfo(s1,newmess));
	   bthread.startmessage();
	   Thread.sleep(10);
	    
		
	}
		//s1out = s1.getOutputStream();
	
    //DataOutputStream dos = new DataOutputStream (s1out);
    
    
    
    // Send a string!
    //dos.writeUTF("Hi there");
    //System.out.println(dis.readUTF()+" :"+s1.getPort());
    //dos.close();
    //s1out.close();
    
    //s1.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
   
}
