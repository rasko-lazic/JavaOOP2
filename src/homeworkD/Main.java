package homeworkD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main() throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        System.out.println("How many songs would you like to have in your compilation?");
        try {
            input = buffer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int length = Integer.parseInt(input);
        Compilation comp = new Compilation(length);

        while(! input.equals("X")) {
            System.out.println("A - add song; D - delete song; S - save compilation; R - show compilation;");


            input = buffer.readLine();


            switch (input) {
                case "A":
                    System.out.print("Song title: ");
                    String title = buffer.readLine();
                    System.out.print("Song artist: ");
                    String artist = buffer.readLine();
                    System.out.print("Song duration: ");
                    input = buffer.readLine();
                    int duration = Integer.parseInt(input);

                    Song s = new Song(title, artist, duration);

                    comp.addSong(s);
                    break;

                case "D":
                    System.out.print("Song index: ");
                    input = buffer.readLine();
                    int index = Integer.parseInt(input);

                    comp.removeSong(index);
                    break;

                case "S":
                    comp.saveCompilation();
                    break;

                case "R":
                    comp.showCompilation();
                    break;

                case "X":
                    System.out.println("Compilation creator is closed.");

                default:
                    System.out.println("Please select on of the available options.");
            }
        }
    }
}
