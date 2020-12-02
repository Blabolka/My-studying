package Library.Objects.Persons;

public class User {

    private static final String NEXT_LINE = System.lineSeparator();

    private String firstName;
    private String lastName;
    private String patronymic;
    private String birthYear;
    private String id;

    public User(String firstName, String lastName, String patronymic, String birthYear, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthYear = birthYear;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public String getDescription(){
        return  "First name: " +getFirstName() + NEXT_LINE +
                "Last name: " +getLastName() + NEXT_LINE +
                "Patronymic: " +getPatronymic() + NEXT_LINE +
                "Birth year: " +getBirthYear() + NEXT_LINE +
                "ID: " +getId();
    }
}
