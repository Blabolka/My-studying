package Library.Objects.Publications;

public class Magazine extends Publication {

    private int articleCount;

    public Magazine(String name, int pageCount, String languageOfPublication, int articleCount) {
        super(name, pageCount, languageOfPublication);
        this.articleCount = articleCount;
    }

    public int getArticleCount() {
        return articleCount;
    }
}
