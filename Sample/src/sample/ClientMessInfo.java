package sample;

import java.net.Socket;

public class ClientMessInfo {
  Socket s;
  //String name;
  String message;
	public ClientMessInfo(Socket s, String message) {
		super();
		this.s = s;
		//this.name = name;
		this.message = message;
	}
}
