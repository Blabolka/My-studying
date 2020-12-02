package Library.Services;

public class Address {

    private static final String NEXT_LINE = System.lineSeparator();

    private String country;
    private String city;
    private String street;
    private String houseNumber;

    public Address(String country, String city, String street, String houseNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getDescription(){
        return  "Country: " +getCountry() + NEXT_LINE +
                "City: " +getCity() + NEXT_LINE +
                "Street: " +getStreet() + NEXT_LINE +
                "House number: " +getHouseNumber() + NEXT_LINE;
    }
}
