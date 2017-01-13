package homeworkG.events;

import homeworkG.data.City;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class CitySelect implements ActionListener{
    private JComboBox countryCombo;
    private JComboBox cityCombo;
    private JTextArea response;

    public CitySelect(JComboBox co, JComboBox ci, JTextArea r) {
        countryCombo = co;
        cityCombo = ci;
        response = r;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String country = (String) countryCombo.getSelectedItem();
        String countryCode = country.split(",")[1];

        City city = (City) cityCombo.getSelectedItem();
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + city.getName() + "," + countryCode + "@&appid=62d8b162423b1d767e1641b71a56b4b7";

        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
