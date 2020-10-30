package Library.Objects;

public abstract class Publication {
    private String name;
    private String pageCount;
    private String languageOfBook;
    private boolean isInLibrary = true;

    public Publication(String name, String pageNumber, String printLanguage) {
        this.name = name;
        this.pageCount = pageNumber;
        this.languageOfBook = printLanguage;
    }

    public String getName() {
        return name;
    }

    public String getPageCount() {
        return pageCount;
    }

    public String getLanguageOfBook() {
        return languageOfBook;
    }
}
