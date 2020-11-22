package Library.Objects;

import Library.Objects.Persons.User;
import Library.Objects.Publications.Publication;
import Library.Objects.Register.PublicationRegister;
import Library.Objects.Register.UserRegister;
import Library.Services.Address;

import java.util.List;

public class Library {
    private final String libraryName;
    private final Address address;
    private final PublicationRegister publicationRegister;
    private final UserRegister userRegister;

    public Library(String libraryName, String country, String city, String street, String houseNumber){
        this.libraryName = libraryName;
        address = new Address(country, city, street, houseNumber);
        publicationRegister = new PublicationRegister();
        userRegister = new UserRegister();
    }

    public boolean addPublication(Publication publication){
        return publicationRegister.add(publication);
    }

    public Publication deletePublication(String title){
        return publicationRegister.delete(title);
    }

    public boolean addUser(User user){
        return userRegister.add(user);
    }

    public User deleteUser(String id){
        return userRegister.delete(id);
    }

    public List<Publication> getPublicationList(){
        return publicationRegister.getPublicationsList();
    }

    public String getLibraryName(){
        return libraryName;
    }

    public Address getAddress(){
        return address;
    }
}
