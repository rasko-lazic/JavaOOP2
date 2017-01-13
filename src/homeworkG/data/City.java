package homeworkG.data;

public class City implements Comparable<City> {
    private String name;
    private String country;

    public City(String n, String c) {
        name = n;
        country = c;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String toString() {
        return name;
    }

    @Override
    public int compareTo(City o) {
        return this.name.compareTo(o.name);
    }
}
