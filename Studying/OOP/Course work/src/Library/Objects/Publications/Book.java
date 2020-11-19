package Library.Objects.Publications;

public class Book extends Publication {

    private int publicationYear;

    public Book(String title, int pageCount, String languageOfPublication, int publicationYear) {
        super(title, pageCount, languageOfPublication);
        this.publicationYear = publicationYear;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}
