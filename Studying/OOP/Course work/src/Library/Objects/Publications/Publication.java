package Library.Objects.Publications;

public abstract class Publication {

    private final String publisher;
    private final String title;
    private final int pageCount;
    private final String languageOfPublication;
    private boolean isInLibrary = true;

    public Publication(String publisher, String title, int pageCount, String printLanguage) {
        this.publisher = publisher;
        this.title = title;
        this.pageCount = pageCount;
        this.languageOfPublication = printLanguage;
    }

    public String getPublisher(){
        return publisher;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getLanguageOfPublication() {
        return languageOfPublication;
    }

    public boolean isInLibrary() {
        return isInLibrary;
    }
}
