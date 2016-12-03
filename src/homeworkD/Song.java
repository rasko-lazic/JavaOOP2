package homeworkD;

import java.io.Serializable;

public class Song implements Serializable{

    private String title;
    private String artist;
    private int duration;

    public Song(String t, String a, int d) {
        title = t;
        artist = a;
        duration = d;
    }

    public String toString() {
        return artist + " - " + title + " [" + duration + "]";
    }
}
