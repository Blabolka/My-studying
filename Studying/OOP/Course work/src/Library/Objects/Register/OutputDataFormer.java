package Library.Objects.Register;

import Library.Objects.Persons.User;
import Library.Objects.Publications.Book;
import Library.Objects.Publications.Magazine;
import Library.Objects.Publications.Publication;

import java.util.List;

public class OutputDataFormer {

    private final static String NEXT_LINE = System.lineSeparator();

    public static String publicationsToCSV(List<Publication> publications, char separator){
        StringBuilder csv = new StringBuilder();

        for (Publication p : publications) {
            csv.append(p.getType().getTitle()).append(separator);
            csv.append(p.getId()).append(separator);
            csv.append(p.getPublisher()).append(separator);
            csv.append(p.getAuthor()).append(separator);
            csv.append(p.getTitle()).append(separator);
            csv.append(p.getPageCount()).append(separator);
            csv.append(p.getLanguage()).append(separator);
            csv.append(p.isInLibrary()).append(separator);
            if(p instanceof Book){
                csv.append(((Book) p).getPublicationYear());
            }else if(p instanceof Magazine){
                csv.append(((Magazine) p).getArticleCount()).append(separator);
                csv.append(((Magazine) p).getPublicationDay());
            }
            csv.append(NEXT_LINE);
        }

        return csv.toString();
    }

    public static String usersToCSV(List<User> users, char separator){
        StringBuilder csv = new StringBuilder();
        
        for (User u : users) {
            csv.append(u.getId()).append(separator);
            csv.append(u.getFirstName()).append(separator);
            csv.append(u.getLastName()).append(separator);
            csv.append(u.getPatronymic()).append(separator);
            csv.append(u.getBirthYear()).append(separator);
            csv.append(toArrayString(u.getTakenPublicationsId()));
            csv.append(NEXT_LINE);
        }

        return csv.toString();
    }

    private static String toArrayString(List<String> list){
        StringBuilder publications = new StringBuilder();

        publications.append('[');

        for (int i = 0; i < list.size(); i++) {
            if(i != list.size()-1){
                publications.append(list.get(i)).append(';');
            }else{
                publications.append(list.get(i));
            }

        }
        publications.append(']');
        return publications.toString();
    }
}
