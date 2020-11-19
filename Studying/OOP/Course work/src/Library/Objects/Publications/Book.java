package Library.Objects.Publications;

public class Book extends Publication {

    private int publicationYear;

    public Book(String publisher, String title, int pageCount, String languageOfPublication, int publicationYear) {
        super(publisher, title, pageCount, languageOfPublication);
        this.publicationYear = publicationYear;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}
