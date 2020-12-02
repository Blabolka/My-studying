package Library.Objects.Register;

import Library.Objects.Publications.Publication;

import java.util.List;

public class PublicationRegisterPrinter {

    public static void printAll(List<Publication> list){
        for (Publication publication : list) {
            System.out.println(publication.getDescription());
        }
    }

    public static void printByLanguageOfPublication(List<Publication> list, String languageOfPublication){
        for (Publication publication : list) {
            if(publication.getLanguageOfPublication().equals(languageOfPublication)){
                System.out.println(publication.getDescription());
            }
        }
    }
}
