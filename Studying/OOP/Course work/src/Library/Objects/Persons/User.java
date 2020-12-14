package Library.Objects.Persons;

import java.util.ArrayList;
import java.util.List;

public class User extends Person{

    private final List<String> takenPublicationsId;


    public User(String id, String firstName, String lastName, String patronymic, String birthYear) {
        super(id, firstName, lastName, patronymic, birthYear);
        takenPublicationsId = new ArrayList<>();
    }

    public User(String id, String firstName, String lastName, String patronymic, String birthYear, List<String> takenPublicationsId) {
        super(id, firstName, lastName, patronymic, birthYear);
        this.takenPublicationsId = takenPublicationsId;
    }
    public List<String> getTakenPublicationsId(){
        return new ArrayList<>(takenPublicationsId);
    }

    public void takePublication(String id){
        takenPublicationsId.add(id);
    }

    public String getDescription(){
        return  super.getDescription() +
                "Taken books by id: " + takenPublicationsId.toString();
    }
}
