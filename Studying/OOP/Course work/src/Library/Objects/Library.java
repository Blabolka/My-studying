package Library.Objects;

import Library.Objects.Publications.Publication;
import Library.Services.Address;

public class Library {
    private String name;
    private Address address;
    private Register register;

    public Library(String name, String country, String city, String street, String houseNumber){
        this.name = name;
        address = new Address(country, city, street, houseNumber);
        register = new Register();
    }

    public void add(Publication publication){
        register.addWithChecking(publication);
    }


}
