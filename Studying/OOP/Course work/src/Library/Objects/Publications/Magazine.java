package Library.Objects.Publications;

public class Magazine extends Publication {

    private static final String NEXT_LINE = System.lineSeparator();

    private final int articleCount;
    private final String publicationDay;

    public Magazine(String id, String publisher, String name, int pageCount, String language, int articleCount, String publicationDay) {
        super(PublicationType.MAGAZINE, id, publisher, name, pageCount, language);
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
        return  super.getDescription() +
                "Article count: " +getArticleCount() + NEXT_LINE +
                "Publication day: " +getPublicationDay();
    }
}
