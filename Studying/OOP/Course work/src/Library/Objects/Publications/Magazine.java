package Library.Objects.Publications;

public class Magazine extends Publication {

    private int articleCount;

    public Magazine(String name, int pageCount, String printLanguage, int articleCount) {
        super(name, pageCount, printLanguage);
        this.articleCount = articleCount;
    }
}
