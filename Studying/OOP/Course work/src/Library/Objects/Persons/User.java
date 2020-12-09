package Library.Objects.Persons;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static final String NEXT_LINE = System.lineSeparator();

    private final String id;
    private final String firstName;
    private final String lastName;
    private final String patronymic;
    private final String birthYear;

    private final List<String> takenPublicationsId;


    public User(String id, String firstName, String lastName, String patronymic, String birthYear) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthYear = birthYear;
        takenPublicationsId = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getBirthYear(){
        return birthYear;
    }

    public List<String> getTakenPublicationsId(){
        return new ArrayList<>(takenPublicationsId);
    }

    public void takePublication(String id){
        takenPublicationsId.add(id);
    }

    public String getDescription(){
        return  "First name: " +getFirstName() + NEXT_LINE +
                "Last name: " +getLastName() + NEXT_LINE +
                "Patronymic: " +getPatronymic() + NEXT_LINE +
                "Birth year: " +getBirthYear() + NEXT_LINE +
                "ID: " +getId();
    }
}
