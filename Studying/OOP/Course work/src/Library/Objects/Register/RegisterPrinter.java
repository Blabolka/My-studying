package Library.Objects.Register;

import Library.Objects.Publications.Book;
import Library.Objects.Publications.Magazine;
import Library.Objects.Publications.Publication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RegisterPrinter {

    public static void printAllPublications(List<Publication> publications){
        for (Publication publication : publications) {
            System.out.println("Title: " +publication.getTitle());
            System.out.println("Page count: " +publication.getPageCount());
            System.out.println("Language of publication: " +publication.getLanguageOfPublication());
            if(publication instanceof Book){
                System.out.println("Publication year: " +((Book) publication).getPublicationYear());
            }else if(publication instanceof Magazine){
                System.out.println("Article count: " +((Magazine) publication).getArticleCount());
            }
            System.out.println();
        }
    }

    public static void printByLanguageOfPublication(List<Publication> publications){
        List<Publication> copyOfPublications = new ArrayList<>(publications);
        copyOfPublications.sort(Comparator.comparing(Publication::getLanguageOfPublication));
        printAllPublications(publications);
    }
}
