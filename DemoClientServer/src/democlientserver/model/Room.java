/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democlientserver.model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Room {
    private String passcode;
    private List<Client> listClient;
    private LinkedList<Message> listMessage;

    public Room(String passcode, List<Client> listClient, LinkedList<Message> listMessage) {
        this.passcode = passcode;
        this.listClient = listClient;
        this.listMessage = listMessage;
    }

    public LinkedList<Message> getListMessage() {
        return listMessage;
    }

    public void setListMessage(LinkedList<Message> listMessage) {
        this.listMessage = listMessage;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public List<Client> getListClient() {
        return listClient;
    }

    public void setListClient(List<Client> listClient) {
        this.listClient = listClient;
    }
    
   
    public synchronized void addClient(List<Client> listClient, Client client){
        listClient.add(client);
    }

    public void pushMessage(LinkedList<Message> listMessage, Message message) {
        listMessage.add(message);
    }
            
}
