package websocket.example;

import java.util.Scanner;
import javax.websocket.DeploymentException;
import org.glassfish.tyrus.server.Server;
import websocket.example.endpoint.ServerEndpoint;

/**
 * Hello world!
 *
 */
public class ServerLoader {

    public static void main(String[] args) throws DeploymentException {
        Server server = new Server("127.0.0.1", 8025, "/websockets", ServerEndpoint.class);
        server.start();
        System.out.println("Press enter key to stop server.");
        new Scanner(System.in).nextLine();
        server.stop();
    }
}
