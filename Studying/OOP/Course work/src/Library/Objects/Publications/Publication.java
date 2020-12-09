package Library.Objects.Publications;

public abstract class Publication {

    private static final String NEXT_LINE = System.lineSeparator();

    private final String id;
    private final String publisher;
    private final String title;
    private final int pageCount;
    private final String languageOfPublication;
    private boolean isInLibrary = true;

    public Publication(String id, String publisher, String title, int pageCount, String printLanguage) {
        this.id = id;
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

    public String getId(){
        return id;
    }

    public void setIsInLibraryState(boolean state){
        isInLibrary = state;
    }

    public boolean isInLibrary() {
        return isInLibrary;
    }

    public String getDescription(){
        return  "ID: " + getId() + NEXT_LINE +
                "Publisher: " +getPublisher() + NEXT_LINE +
                "Title: " +getTitle() + NEXT_LINE +
                "Page count: " +getPageCount() + NEXT_LINE +
                "Language of publication: " +getLanguageOfPublication() + NEXT_LINE;
    }
}
