package exerciseH.client;

import exerciseH.graphics.ChatMessage;
import exerciseH.server.ChatServerWindow;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ChatClientThread extends Thread {
    private Socket connectionSocket;
    private ChatServerWindow chatWindow;

    public ChatClientThread(Socket s, ChatServerWindow c) {
        connectionSocket = s;
        chatWindow = c;
        System.out.println("Thread is up!");
        start();
    }

    public void run() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(connectionSocket.getOutputStream());
            out.writeObject("Hello new client!!!");
            ObjectInputStream in = new ObjectInputStream(connectionSocket.getInputStream());

            while (true) {
                ChatMessage clientMessage = (ChatMessage) in.readObject();
                chatWindow.appendToChat(clientMessage);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
