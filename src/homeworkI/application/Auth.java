package homeworkI.application;

import java.util.ArrayList;

public class Auth {
    private static ArrayList<User> users = null;
    private static String errorMessage;

    public static void initUsers() {
        users = new ArrayList<>();
        users.add(new User("foo", "foo"));
        users.add(new User("bar", "bar"));
        users.add(new User("user", "user"));
        users.add(new User("admin", "admin"));
    }

    public static boolean authenticateUser(String username, String password) {
        errorMessage = "User not found!";
        User foundUser = null;

        for (User user : users) {
            if(user.getUsername().equals(username)) {
                foundUser = user;
                errorMessage = "Wrong password!";
            }
        }

        return foundUser != null && foundUser.checkPassword(password);
    }

    public static String getErrorMessage() {
        return errorMessage;
    }
}
