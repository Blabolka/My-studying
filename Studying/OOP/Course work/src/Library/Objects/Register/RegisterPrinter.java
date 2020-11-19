package Library.Objects.Register;

import Library.Objects.Publications.Book;
import Library.Objects.Publications.Magazine;
import Library.Objects.Publications.Publication;

import java.util.List;

public class RegisterPrinter {

    public static void printAllPublications(List<Publication> publications){
        for (Publication publication : publications) {
            System.out.println(publication.getTitle());
            System.out.println(publication.getPageCount());
            System.out.println(publication.getLanguageOfPublication());
            if(publication instanceof Book){
                System.out.println(((Book) publication).getPublicationYear());
            }else if(publication instanceof Magazine){
                System.out.println(((Magazine) publication).getArticleCount());
            }
            System.out.println();
        }
    }
}
