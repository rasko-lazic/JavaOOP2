package homeworkF.client;

import homeworkF.server.Product;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        System.out.println("Client is up!");

        try {
            Socket clientSocket = new Socket("127.0.0.1", 5678);

            ClientWindow app = new ClientWindow(clientSocket);

//            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
