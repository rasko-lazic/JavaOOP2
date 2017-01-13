package homeworkH.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ButterflyParser {
    private static final String PATH = "src/homeworkH/assets/";

    public String parseTitle(String butterflyName) {
        String title = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH + butterflyName + ".txt"));
            title = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return title;
    }

    public String parseCaption(String butterflyName) {
        String caption = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH + butterflyName + ".txt"));
            String line = br.readLine();

            while(line != null) {
                caption += line;
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return caption;
    }

}
