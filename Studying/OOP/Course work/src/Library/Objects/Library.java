package Library.Objects;

import Library.Objects.Register.PublicationRegister;
import Library.Services.Address;

public class Library {

    private static final String NEXT_LINE = System.lineSeparator();

    private final String libraryName;
    private final Address address;
    private final PublicationRegister publicationRegister;

    public Library(String libraryName, Address address, PublicationRegister publicationRegister){
        this.libraryName = libraryName;
        this.address = address;
        this.publicationRegister = publicationRegister;
    }

    public String getLibraryName(){
        return libraryName;
    }

    public Address getAddress(){
        return address;
    }

    public String printDescription(){
        return  address.getDescription() +
                "Library name: " +getLibraryName() + NEXT_LINE;
    }
}
