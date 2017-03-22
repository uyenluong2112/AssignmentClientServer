package sample;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientRead extends Thread {
   Socket s1;

  public ClientRead(Socket s1) {
	super();
	this.s1 = s1;
  }
  public void run()
  {
	  try {
		  InputStream s1In;
	  while(true)
	  {
		 
		
			s1In = s1.getInputStream();
		   
		    DataInputStream dis = new DataInputStream(s1In);
		    String st = new String (dis.readUTF());
		    System.out.println(st);
		    //dis.close();
	  }
	  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
}
