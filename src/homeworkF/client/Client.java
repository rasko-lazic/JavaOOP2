package homeworkF.client;

import homeworkF.server.Product;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client {

    public static void main(String[] args) {
        System.out.println("Client is up!");

        try {
            Socket clientSocket = new Socket("127.0.0.1", 5678);

            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            Object serverResponse = in.readObject();

            ClientWindow app = new ClientWindow((ArrayList<Product>) serverResponse);

            if(serverResponse instanceof ArrayList) {
                System.out.println("Success");
            }

            in.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
