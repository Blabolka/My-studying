package Library.Objects;

import Library.Objects.Register.PublicationRegister;
import Library.Objects.Register.UserRegister;
import Library.Services.Address;

public class Library {

    private final String libraryName;
    private final Address address;
    private final PublicationRegister publicationRegister;
    private final UserRegister userRegister;

    public Library(String libraryName, Address address, PublicationRegister publicationRegister, UserRegister userRegister){
        this.libraryName = libraryName;
        this.address = address;
        this.publicationRegister = publicationRegister;
        this.userRegister = userRegister;
    }

    public String getLibraryName(){
        return libraryName;
    }

    public Address getAddress(){
        return address;
    }
}
