package Library.Objects.Publications;

public class Book extends Publication {

    private static final String NEXT_LINE = System.lineSeparator();

    private final int publicationYear;

    public Book(String id, String publisher, String author, String title, int pageCount, String language, int publicationYear) {
        super(PublicationType.BOOK, id, publisher, author, title, pageCount, language);
        this.publicationYear = publicationYear;
    }

    public Book(String id, String publisher, String author, String title, int pageCount, String language, boolean isInLibrary, int publicationYear) {
        super(PublicationType.BOOK, id, publisher, author, title, pageCount, language, isInLibrary);
        this.publicationYear = publicationYear;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getDescription(){
        return  "ID: " + getId() + NEXT_LINE +
                "Publisher: " + getPublisher() + NEXT_LINE +
                "Author: " + getAuthor() + NEXT_LINE +
                "Title: " + getTitle() + NEXT_LINE +
                "Page count: " + getPageCount() + NEXT_LINE +
                "Language of publication: " + getLanguage() + NEXT_LINE +
                "Publication year: " + getPublicationYear();
    }
}
