package Library.Objects.Persons;

public class User extends Person {

    private String birthYear;
    private String id;

    public User(String firstName, String lastName, String patronymic, String birthYear, String id) {
        super(firstName, lastName, patronymic);
        this.birthYear = birthYear;
        this.id = id;
    }
}
