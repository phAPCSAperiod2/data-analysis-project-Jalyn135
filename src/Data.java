/**
 * Represents one row from the World Indicators dataset.
 * Stores a country's name, its CO2 emissions, and the year.
 */
public class Data {

    private String country;
    private double emissions;
    private int year;

    /**
     * Constructs a Data object.
     * @param country the country's name
     * @param emissions the CO2 emissions value
     * @param year the year of the data
     */
    public Data(String country, double emissions, int year) {
        this.country = country;
        this.emissions = emissions;
        this.year = year;
    }

    /** @return the country name */
    public String getCountry() {
        return country;
    }

    /** @return the CO2 emissions */
    public double getEmissions() {
        return emissions;
    }

    /** @return the year */
    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return country + " | Emissions: " + emissions + " | Year: " + year;
    }
}
