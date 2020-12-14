package Library.Objects;

public class Address {

    private static final String NEXT_LINE = System.lineSeparator();

    private final String country;
    private final String city;
    private final String street;
    private final String houseNumber;

    public Address(String country, String city, String street, String houseNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public Address(Address address){
        country = address.getCountry();
        city = address.getCity();
        street = address.getStreet();
        houseNumber = address.getHouseNumber();
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
