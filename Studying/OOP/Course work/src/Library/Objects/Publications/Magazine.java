package Library.Objects.Publications;

public class Magazine extends Publication {

    private static final String NEXT_LINE = System.lineSeparator();

    private final PublicationType type;
    private final int articleCount;
    private String publicationDay;

    public Magazine(String id, String publisher, String name, int pageCount, String language, int articleCount, String publicationDay) {
        super(id, publisher, name, pageCount, language);
        type = PublicationType.MAGAZINE;
        this.articleCount = articleCount;
        this.publicationDay = publicationDay;
    }

    private PublicationType getType(){
        return type;
    }

    private int getArticleCount() {
        return articleCount;
    }

    private String getPublicationDay() {
        return publicationDay;
    }

    public String getDescription(){
        return  type.getTitle() + NEXT_LINE +
                super.getDescription() +
                "Article count: " +getArticleCount() + NEXT_LINE +
                "Publication day: " +getPublicationDay();
    }
}
