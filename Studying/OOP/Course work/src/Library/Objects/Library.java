package Library.Objects;

import Library.Objects.Publications.Publication;
import Library.Objects.Register.Register;
import Library.Services.Address;

import java.util.List;

public class Library {
    private final String libraryName;
    private final Address address;
    private final Register register;

    public Library(String libraryName, String country, String city, String street, String houseNumber){
        this.libraryName = libraryName;
        address = new Address(country, city, street, houseNumber);
        register = new Register();
    }

    public void add(Publication publication){
        register.addWithChecking(publication);
    }

    public Publication delete(String title){
        return register.deletePublication(title);
    }

    public List<Publication> getPublicationList(){
        return register.getPublicationsList();
    }
}
