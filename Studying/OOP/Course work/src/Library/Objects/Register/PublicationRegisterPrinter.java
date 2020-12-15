package Library.Objects.Register;

import Library.Objects.Publications.Publication;

import java.util.List;

public class PublicationRegisterPrinter {

    List<Publication> publications;

    public PublicationRegisterPrinter(List<Publication> publications){
        this.publications = publications;
    }

    public void printAll(){
        publications.forEach(p -> System.out.println(p.getDescription()));
    }

    public void printByLanguage(String language){
        publications
                .stream()
                .filter(p -> p.getLanguage().equals(language))
                .forEach(p -> System.out.println(p.getDescription()));
    }
}
