package homeworkG.graphics;

import homeworkG.data.City;
import homeworkG.events.CitySelect;
import homeworkG.events.CountrySelect;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WeatherWindow extends JFrame{
    private ArrayList<String> countryList;
    private ArrayList<City> cityList;
    private JComboBox countryCombo;
    private JComboBox cityCombo;
    private JTextArea response;

    public WeatherWindow() {
        this.setTitle("Weather App");
        this.setLayout(null);
        this.setSize(400, 800);

        this.initData();
        this.initElements();

        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initData() {
        countryList = new ArrayList<>();
        cityList = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/homeworkG/data/CountryData.csv"));
            String line = br.readLine();

            while(line != null) {
                countryList.add(line);
                line = br.readLine();
            }

            br = new BufferedReader(new FileReader("src/homeworkG/data/CityData.csv"));
            line = br.readLine();
            String[] split = {};
            City newCity;

            while(line != null) {
                split = line.split(",");
                newCity = new City(split[0], split[1]);
                cityList.add(newCity);
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initElements() {
        countryCombo = new JComboBox(countryList.toArray());
        countryCombo.setEditable(false);
        countryCombo.setBounds(10,0,360, 50);
        this.add(countryCombo);

        cityCombo = new JComboBox();
        cityCombo.setEditable(false);
        cityCombo.setBounds(10,70,360, 50);
        this.add(cityCombo);

        response = new JTextArea();
        response.setBounds(10, 140, 360, 600);
        response.setLineWrap(true);
        response.setWrapStyleWord(true);
        this.add(response);

        countryCombo.addActionListener(new CountrySelect(countryCombo, cityCombo, cityList));
        cityCombo.addActionListener(new CitySelect(countryCombo, cityCombo, response));
    }
}
