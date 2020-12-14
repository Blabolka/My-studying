package Library.Objects.Publications;

public class Book extends Publication {

    private static final String NEXT_LINE = System.lineSeparator();

    private final int publicationYear;

    public Book(String id, String publisher, String title, int pageCount, String language, int publicationYear) {
        super(PublicationType.BOOK, id, publisher, title, pageCount, language);
        this.publicationYear = publicationYear;
    }

    public Book(String id, String publisher, String title, int pageCount, String language, boolean isInLibrary, int publicationYear) {
        super(PublicationType.BOOK, id, publisher, title, pageCount, language, isInLibrary);
        this.publicationYear = publicationYear;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getDescription(){
        return  super.getDescription() +
                "Publication year: " + getPublicationYear() + NEXT_LINE;
    }
}
