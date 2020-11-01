package Library.Objects.Publications;

public class Book extends Publication {

    private int publicationYear;

    public Book(String name, int pageCount, String printLanguage, int publicationYear) {
        super(name, pageCount, printLanguage);
        this.publicationYear = publicationYear;
    }
}
