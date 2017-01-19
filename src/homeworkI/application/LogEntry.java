package homeworkI.application;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogEntry implements Serializable {
    private static ArrayList<LogEntry> logList = new ArrayList<>();
    private String username;
    private String status;
    private String date;

    public LogEntry(String u, String s) {
        username = u;
        status = s;
        setCurrentDate();
    }

    public String getUsername() {
        return username;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    private void setCurrentDate() {
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        Date time = new Date();

        date = format.format(time);
    }

    public void persist() {
        try {
            FileInputStream fileIn = new FileInputStream("tmp/log.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            logList = (ArrayList<LogEntry>) in.readObject();

            fileIn.close();
            in.close();
        } catch (FileNotFoundException e) {
            File file = new File("tmp/log.ser");
            try {
                file.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        logList.add(this);

        try {
            FileOutputStream fileOut = new FileOutputStream("tmp/log.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(logList);

            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Username: " + username + " Status: " + status;
    }
}
