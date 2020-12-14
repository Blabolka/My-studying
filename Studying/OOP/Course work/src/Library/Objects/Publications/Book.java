package Library.Objects.Publications;

public class Book extends Publication {

    private static final String NEXT_LINE = System.lineSeparator();

    private final PublicationType type;
    private final int publicationYear;

    public Book(String id, String publisher, String title, int pageCount, String language, int publicationYear) {
        super(id, publisher, title, pageCount, language);
        type = PublicationType.BOOK;
        this.publicationYear = publicationYear;
    }

    private PublicationType getType(){
        return type;
    }

    private int getPublicationYear() {
        return publicationYear;
    }

    public String getDescription(){
        return  type.getTitle() + NEXT_LINE +
                super.getDescription() +
                "Publication year: " +getPublicationYear() + NEXT_LINE;
    }
}
