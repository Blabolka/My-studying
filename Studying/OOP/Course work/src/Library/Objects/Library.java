package Library.Objects;

import Library.Objects.Persons.User;
import Library.Objects.Publications.Publication;
import Library.Objects.Register.PublicationRegister;
import Library.Objects.Register.UserRegister;

import java.util.List;

public class Library {

    private static final String NEXT_LINE = System.lineSeparator();

    private final Address address;
    private final String libraryName;
    private final UserRegister userRegister;
    private final PublicationRegister publicationRegister;

    public Library(String libraryName, Address address){
        this.address = new Address(address);
        this.libraryName = libraryName;
        publicationRegister = new PublicationRegister();
        userRegister = new UserRegister();
    }

    public String getLibraryName(){
        return libraryName;
    }

    public Address getAddress(){
        return address;
    }

    public String getDescription(){
        return  address.getDescription() +
                "Library name: " +getLibraryName() + NEXT_LINE;
    }

    /*--------------------------------------------------------------*/

    public boolean givePublicationToUser(String userId, String publicationId){
        int indexOfUser = userRegister.indexOf(userId);
        int indexOfPublication = publicationRegister.indexOf(publicationId);

        if(indexOfUser == -1 || indexOfPublication == -1){
            return false;
        }

        if(!publicationRegister.getRegister().get(indexOfPublication).isInLibrary()){
            return false;
        }

        userRegister.getRegister().get(indexOfUser).takePublication(publicationId);
        publicationRegister.getRegister().get(indexOfPublication).setIsInLibraryState(false);

        return true;
    }

    /*--------------------------------------------------------------*/

    public void addPublication(Publication publication){
        publicationRegister.add(publication);
    }

    public boolean removePublication(String id){
        return publicationRegister.remove(id);
    }

    public boolean checkIfPublicationExist(Publication publication){
        return publicationRegister.checkIfExist(publication);
    }

    public List<Publication> getPublicationRegister(){
        return publicationRegister.getRegister();
    }

    /*--------------------------------------------------------------*/

    public void addUser(User user){
        userRegister.add(user);
    }

    public boolean removeUser(String id){
        return userRegister.remove(id);
    }

    public boolean checkIfUserExist(User user){
        return userRegister.checkIfExist(user);
    }

    public List<User> getUserRegister(){
        return userRegister.getRegister();
    }

    /*--------------------------------------------------------------*/
}
