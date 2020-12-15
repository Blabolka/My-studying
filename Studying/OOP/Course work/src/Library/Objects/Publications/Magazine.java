package Library.Objects.Publications;

public class Magazine extends Publication {

    private static final String NEXT_LINE = System.lineSeparator();

    private final int articleCount;
    private final String publicationDay;

    public Magazine(String id, String publisher, String author, String name, int pageCount, String language, int articleCount, String publicationDay) {
        super(PublicationType.MAGAZINE, id, publisher, author, name, pageCount, language);
        this.articleCount = articleCount;
        this.publicationDay = publicationDay;
    }
    public Magazine(String id, String publisher, String author, String name, int pageCount, String language, boolean isInLibrary, int articleCount, String publicationDay) {
        super(PublicationType.MAGAZINE, id, publisher, author, name, pageCount, language, isInLibrary);
        this.articleCount = articleCount;
        this.publicationDay = publicationDay;
    }

    public int getArticleCount() {
        return articleCount;
    }

    public String getPublicationDay() {
        return publicationDay;
    }

    public String getDescription(){
        return  "ID: " + getId() + NEXT_LINE +
                "Publisher: " + getPublisher() + NEXT_LINE +
                "Author: " + getAuthor() + NEXT_LINE +
                "Title: " + getTitle() + NEXT_LINE +
                "Page count: " + getPageCount() + NEXT_LINE +
                "Language of publication: " + getLanguage() + NEXT_LINE +
                "Article count: " +getArticleCount() + NEXT_LINE +
                "Publication day: " +getPublicationDay();
    }
}
