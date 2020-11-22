package Library.Objects.Persons;

import Library.Objects.Publications.Publication;

import java.util.ArrayList;
import java.util.List;

public class User extends Person {

    private String birthYear;
    private String id;
    private List<Publication> takenPublicationsList;

    public User(String firstName, String lastName, String patronymic, String birthYear, String id) {
        super(firstName, lastName, patronymic);
        this.birthYear = birthYear;
        this.id = id;
        takenPublicationsList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }
}
