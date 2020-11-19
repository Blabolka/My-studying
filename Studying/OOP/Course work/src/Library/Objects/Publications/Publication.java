package Library.Objects.Publications;

public abstract class Publication {

    private String title;
    private int pageCount;
    private String languageOfPublication;
    private boolean isInLibrary = true;

    public Publication(String title, int pageCount, String printLanguage) {
        this.title = title;
        this.pageCount = pageCount;
        this.languageOfPublication = printLanguage;
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
