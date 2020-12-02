package Library.Objects.Publications;

public class Book extends Publication {

    private static final String NEXT_LINE = System.lineSeparator();

    private int publicationYear;

    public Book(String publisher, String title, int pageCount, String languageOfPublication, int publicationYear) {
        super(publisher, title, pageCount, languageOfPublication);
        this.publicationYear = publicationYear;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getDescription(){
        return  super.getDescription() +
                "Publication year: " +getPublicationYear() + NEXT_LINE;
    }
}
