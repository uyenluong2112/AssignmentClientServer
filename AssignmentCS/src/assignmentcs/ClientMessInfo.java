/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentcs;

import java.net.Socket;

public class ClientMessInfo {
    Socket c;
    String message;
    public ClientMessInfo(Socket c, String message) {
		super();
		this.c = c;
		//this.name = name;
		this.message = message;
    }
}
