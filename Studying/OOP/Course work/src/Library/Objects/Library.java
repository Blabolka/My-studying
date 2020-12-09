package Library.Objects;

import Library.Objects.Persons.User;
import Library.Objects.Publications.Publication;
import Library.Services.Address;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private static final String NEXT_LINE = System.lineSeparator();

    private final Address address;
    private final String libraryName;
    private final List<User> userRegister;
    private final List<Publication> publicationRegister;

    public Library(String libraryName, Address address){
        this.address = address;
        this.libraryName = libraryName;
        this.userRegister = new ArrayList<>();
        this.publicationRegister = new ArrayList<>();
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

    public void addPublication(Publication publication){
        publicationRegister.add(publication);
    }

    public boolean removePublication(String id){
        return publicationRegister.removeIf(p -> (id.equals(p.getId()) && p.isInLibrary()));
    }

    public boolean checkIfPublicationExist(Publication publication){
        for (Publication p : publicationRegister) {
            if(publication.getId().equals(p.getId())){
                return true;
            }
        }
        return false;
    }

    public List<Publication> getPublicationRegister(){
        return new ArrayList<>(publicationRegister);
    }

    private int indexOfaPublication(String publicationId){
        for (int i = 0; i < publicationRegister.size(); i++) {
            if(publicationRegister.get(i).getId().equals(publicationId)){
                return i;
            }
        }
        return -1;
    }
    /*--------------------------------------------------------------*/

    public void addUser(User user){
        userRegister.add(user);
    }

    public boolean removeUser(String id){
        return userRegister.removeIf(u -> (id.equals(u.getId()) && u.getTakenPublicationsId().size() == 0));
    }

    public boolean checkIfUserExist(User user){
        for (User u : userRegister) {
            if(user.getId().equals(u.getId())){
                return true;
            }
        }
        return false;
    }

    public List<User> getUserRegister(){
        return new ArrayList<>(userRegister);
    }

    private int indexOfUser(String userId){
        for (int i = 0; i < userRegister.size(); i++) {
            if(userRegister.get(i).getId().equals(userId)){
                return i;
            }
        }
        return -1;
    }
    /*--------------------------------------------------------------*/

    public boolean givePublicationToUser(String userId, String publicationId){
        int indexOfUser = indexOfUser(userId);
        int indexOfPublication = indexOfaPublication(publicationId);

        if(indexOfUser == -1 || indexOfPublication == -1){
            return false;
        }

        if(!publicationRegister.get(indexOfPublication).isInLibrary()){
            return false;
        }

        userRegister.get(indexOfUser).takePublication(publicationId);
        publicationRegister.get(indexOfPublication).setIsInLibraryState(false);

        return true;
    }
}
