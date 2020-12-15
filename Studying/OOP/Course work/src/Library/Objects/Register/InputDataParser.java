package Library.Objects.Register;

import Library.Objects.Persons.User;
import Library.Objects.Publications.Book;
import Library.Objects.Publications.Magazine;
import Library.Objects.Publications.Publication;
import Library.Objects.Publications.PublicationType;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputDataParser {

    public static List<Publication> parsePublicationsCSV(String publications, char separator){

        List<Publication> list = new ArrayList<>();
        String[] splitByRow = StringUtils.split(publications, System.lineSeparator());

        for (String s : splitByRow) {
            String[] row = StringUtils.split(s, separator);

            Publication newPublication;

            PublicationType type = PublicationType.parsePublicationType(row[0]);
            String id = row[1];
            String publisher = row[2];
            String author = row[3];
            String title = row[4];
            int pageCount = Integer.parseInt(row[5]);
            String language = row[6];
            boolean isInLibrary = Boolean.parseBoolean(row[7]);

            if (type == PublicationType.BOOK) {
                int publicationYear = Integer.parseInt(row[8]);
                newPublication = new Book(id, publisher, author, title, pageCount, language, isInLibrary, publicationYear);
                list.add(newPublication);
            } else if (type == PublicationType.MAGAZINE) {
                int articleCount = Integer.parseInt(row[8]);
                String publicationDay = row[9];
                newPublication = new Magazine(id, publisher, author, title, pageCount, language, isInLibrary, articleCount, publicationDay);
                list.add(newPublication);
            }
        }

        return list;
    }

    public static List<User> parseUsersCSV(String users, char separator){

        List<User> list = new ArrayList<>();
        String[] splitByRow = StringUtils.split(users, System.lineSeparator());

        for (String s : splitByRow) {
            String[] row = StringUtils.split(s,separator);

            User newUser;

            String id = row[0];
            String firstName = row[1];
            String lastName = row[2];
            String patronymic = row[3];
            String birthYear = row[4];

            String[] takenPublications = StringUtils.split(row[5], ",[]");
            List<String> takenPublicationsId = new ArrayList<>(Arrays.asList(takenPublications));

            newUser = new User(id, firstName, lastName, patronymic, birthYear, takenPublicationsId);

            list.add(newUser);
        }

        return list;
    }
}
