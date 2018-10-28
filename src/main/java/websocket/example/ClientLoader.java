/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websocket.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import websocket.example.endpoint.ClientEndpoint;

/**
 *
 * @author kuuhaku
 */
public class ClientLoader {

    private static String ENDPOINT = "ws://127.0.0.1:8025/websockets/home";

    public static void main(String[] args) throws URISyntaxException, DeploymentException, IOException {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        Session session = container.connectToServer(ClientEndpoint.class, new URI(ENDPOINT));
        session.getAsyncRemote().sendText("hello there!");
        System.out.println("Press enter key to stop client.");
        new Scanner(System.in).nextLine();
        session.close();
    }
}
