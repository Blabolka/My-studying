package Library.Objects.Publications;

public class Magazine extends Publication {

    private static final String NEXT_LINE = System.lineSeparator();

    private final int articleCount;
    private String publicationDay;

    public Magazine(String id, String publisher, String name, int pageCount, String languageOfPublication, int articleCount, String publicationDay) {
        super(id, publisher, name, pageCount, languageOfPublication);
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
