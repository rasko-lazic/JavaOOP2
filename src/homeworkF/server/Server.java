package homeworkF.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private static ArrayList<Product> productList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Server is up!");
        productList.add(new Product("Bread", 42.0, 5));
        productList.add(new Product("Milk", 62.0, 2));
        productList.add(new Product("Cheese", 112.0, 3));
        productList.add(new Product("Cookies", 12.0, 7));

        try {
            ServerSocket portListener = new ServerSocket(5678);
            Socket socketConnection = portListener.accept();

            ObjectOutputStream out = new ObjectOutputStream(socketConnection.getOutputStream());
            out.writeObject(productList);

            while(true) {

            }

            out.close();
            socketConnection.close();
            portListener.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
