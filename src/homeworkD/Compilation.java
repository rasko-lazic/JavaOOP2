package homeworkD;

import java.io.*;

public class Compilation implements Serializable {

    private Song[] songList;
    private transient int totalDuration;

    public Compilation(int l) {
        songList = new Song[l];

//        this.saveCompilation();
    }

    public Song[] getSongList() {
        return songList;
    }

    public boolean addSong(Song s) {
        for(int i = 0; i < songList.length; i++) {
            if(songList[i] == null) {
                songList[i] = s;
                totalDuration += s.getDuration();
                return true;
            }
        }

        return false;
    }

    public void removeSong(int i) {
        totalDuration -= songList[i].getDuration();
        songList[i] = null;
    }

    public void saveCompilation() {
        try {
            FileOutputStream fileOut = new FileOutputStream("tmp/compilation.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("Compilation is saved.");
        } catch(IOException i) {
            i.printStackTrace();
        }
    }

    public void showCompilation() {
        Compilation compilation;

        try {
            FileInputStream fileIn = new FileInputStream("tmp/compilation.bin");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            compilation = (Compilation) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException i) {
            i.printStackTrace();
            return;
        } catch(ClassNotFoundException c) {
            c.printStackTrace();
            return;
        }

        totalDuration = 0;

        for(int i = 0; i < compilation.getSongList().length; i++) {
            if(compilation.getSongList()[i] != null) {
                System.out.println(compilation.getSongList()[i]);
                totalDuration += compilation.getSongList()[i].getDuration();
            }
        }

        System.out.println("Total duration: " + totalDuration);
    }
}
