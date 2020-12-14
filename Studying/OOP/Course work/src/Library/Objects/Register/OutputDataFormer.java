package Library.Objects.Register;

import Library.Objects.Persons.User;
import Library.Objects.Publications.Book;
import Library.Objects.Publications.Magazine;
import Library.Objects.Publications.Publication;

import java.util.List;

public class OutputDataFormer {

    private final static String NEXT_LINE = System.lineSeparator();

    public static String publicationsToCSV(List<Publication> publications){
        StringBuilder csv = new StringBuilder();

        for (Publication p : publications) {
            csv.append(p.getType().getTitle()).append(";");
            csv.append(p.getId()).append(";");
            csv.append(p.getPublisher()).append(";");
            csv.append(p.getTitle()).append(";");
            csv.append(p.getPageCount()).append(";");
            csv.append(p.getLanguage()).append(";");
            csv.append(p.isInLibrary()).append(";");
            if(p instanceof Book){
                csv.append(((Book) p).getPublicationYear());
            }else if(p instanceof Magazine){
                csv.append(((Magazine) p).getArticleCount()).append(";");
                csv.append(((Magazine) p).getPublicationDay());
            }
            csv.append(NEXT_LINE);
        }

        return csv.toString();
    }

    public static String usersToCSV(List<User> users){
        StringBuilder csv = new StringBuilder();
        
        for (User u : users) {
            csv.append(u.getId()).append(";");
            csv.append(u.getFirstName()).append(";");
            csv.append(u.getLastName()).append(";");
            csv.append(u.getPatronymic()).append(";");
            csv.append(u.getBirthYear()).append(";");
            csv.append(u.getTakenPublicationsId().toString());
            csv.append(NEXT_LINE);
        }

        return csv.toString();
    }
}
