package homeworkI.application;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;

    public User(String u, String p) {
        username = u;
        password = p;
    }

    public String getUsername() {
        return username;
    }

    public String toString() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
