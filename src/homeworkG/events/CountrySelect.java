package homeworkG.events;

import homeworkG.data.City;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class CountrySelect implements ActionListener{
    private JComboBox countryCombo;
    private JComboBox cityCombo;
    private ArrayList<City> cityList;

    public CountrySelect(JComboBox c, JComboBox cc, ArrayList cl) {
        countryCombo = c;
        cityCombo = cc;
        cityList = cl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedCountry = (String) countryCombo.getSelectedItem();
        String countryName = selectedCountry.split(",")[0];

        ArrayList<City> filteredCities = new ArrayList<>();

        for (City city : cityList) {
            if(countryName.equals(city.getCountry())) {
                filteredCities.add(city);
            }
        }

        Collections.sort(filteredCities);

        cityCombo.setModel(new DefaultComboBoxModel(filteredCities.toArray()));
    }
}
