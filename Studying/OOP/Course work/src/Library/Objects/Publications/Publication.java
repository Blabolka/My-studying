package Library.Objects.Publications;

public abstract class Publication {

    private static final String NEXT_LINE = System.lineSeparator();

    private final PublicationType type;
    private final String id;
    private final String publisher;
    private final String title;
    private final int pageCount;
    private final String language;
    private boolean isInLibrary = true;

    public Publication(PublicationType type, String id, String publisher, String title, int pageCount, String language) {
        this.type = type;
        this.id = id;
        this.publisher = publisher;
        this.title = title;
        this.pageCount = pageCount;
        this.language = language;
    }

    public Publication(PublicationType type, String id, String publisher, String title, int pageCount, String language, boolean isInLibrary){
        this.type = type;
        this.id = id;
        this.publisher = publisher;
        this.title = title;
        this.pageCount = pageCount;
        this.language = language;
        this.isInLibrary = isInLibrary;
    }

    public PublicationType getType(){
        return type;
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

    public String getLanguage() {
        return language;
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
                "Language of publication: " + getLanguage() + NEXT_LINE;
    }
}
