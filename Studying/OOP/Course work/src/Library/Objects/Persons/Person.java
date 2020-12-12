package Library.Objects.Persons;

public abstract class Person {

    private static final String NEXT_LINE = System.lineSeparator();

    private final String id;
    private final String firstName;
    private final String lastName;
    private final String patronymic;
    private final String birthYear;

    public Person(String id, String firstName, String lastName, String patronymic, String birthYear) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthYear = birthYear;
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

    public String getDescription(){
        return  "First name: " +getFirstName() + NEXT_LINE +
                "Last name: " +getLastName() + NEXT_LINE +
                "Patronymic: " +getPatronymic() + NEXT_LINE +
                "Birth year: " +getBirthYear() + NEXT_LINE +
                "ID: " +getId();
    }

}
