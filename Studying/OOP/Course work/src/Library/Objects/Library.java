package Library.Objects;

import Library.Objects.Publications.Publication;
import Library.Objects.Register.Register;
import Library.Services.Address;

import java.util.List;

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

    public List<Publication> getPublicationList(){
        return register.getPublicationsList();
    }
}
