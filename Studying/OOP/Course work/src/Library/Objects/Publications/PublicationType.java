package Library.Objects.Publications;

public enum PublicationType {
    BOOK("Book"),
    MAGAZINE("Magazine");

    private String title;

    PublicationType(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }
}
