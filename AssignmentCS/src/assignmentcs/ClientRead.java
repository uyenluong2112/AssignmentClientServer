/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentcs;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientRead extends Thread {
   Socket c1;

  public ClientRead(Socket c1) {
	super();
	this.c1 = c1;
  }
  public void run()
  {
	  try {
		  InputStream c1In;
	  while(true)
	  {
		 
		
			c1In = c1.getInputStream();
		   
		    DataInputStream dis = new DataInputStream(c1In);
		    String st = new String (dis.readUTF());
		    System.out.println(st);
	  }
	  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
}
