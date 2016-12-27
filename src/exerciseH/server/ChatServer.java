package exerciseH.server;

import exerciseH.client.ChatClientThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5678);
            System.out.println("Server is up!");
            ChatServerWindow chatWindow = new ChatServerWindow();

            while (true) {
                Socket connectionSocket = serverSocket.accept();
                new ChatClientThread(connectionSocket, chatWindow);

                if(false) {
                    break;
                }
            }

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
