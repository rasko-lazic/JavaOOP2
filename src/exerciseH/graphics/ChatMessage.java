package exerciseH.graphics;

import java.io.Serializable;

public class ChatMessage implements Serializable{
    private String name;
    private String message;

    public ChatMessage(String n, String m) {
        name = n;
        message = m;
    }

    @Override
    public String toString() {
        return name + ": " + message;
    }
}
