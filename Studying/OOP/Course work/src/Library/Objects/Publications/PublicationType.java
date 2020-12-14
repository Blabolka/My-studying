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

    public static PublicationType parsePublicationType(String type){
        if(type.equals(BOOK.getTitle())){
            return BOOK;
        }else if(type.equals(MAGAZINE.getTitle())){
            return MAGAZINE;
        }else{
            throw new RuntimeException();
        }
    }
}
