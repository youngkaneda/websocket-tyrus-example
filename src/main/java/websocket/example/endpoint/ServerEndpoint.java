/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websocket.example.endpoint;

import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

/**
 *
 * @author kuuhaku
 */
@javax.websocket.server.ServerEndpoint(value = "/home")
public class ServerEndpoint {
    
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("connected to session " + session.getId());
    }
    
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("from client: " + message);
        System.out.println("from: session " + session.getId());
        session.getBasicRemote().sendText("message received!");
    }
    
    @OnClose
    public void onClose(Session session) {
        System.out.println("closing connection with session " + session.getId());
    }
}
