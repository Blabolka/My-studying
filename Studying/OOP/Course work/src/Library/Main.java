package Library;

import Library.Objects.FileOperations.FileReader;
import Library.Objects.FileOperations.FileWriter;
import Library.Objects.Library;
import Library.Objects.Register.*;
import Library.Objects.Persons.User;
import Library.Objects.Publications.Book;
import Library.Objects.Publications.Magazine;
import Library.Objects.Publications.Publication;
import Library.Objects.Address;

import java.io.File;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        Address libraryAddress = new Address("Ukraine", "Kharkiv", "Klochkivska", "1337");
        Library library = new Library("Andrew Klochko Library", libraryAddress);

        String choice;
        boolean exitStatus = false;
        while(!exitStatus){
            System.out.println( "1. Add new publication to register\n" +
                                "2. Delete publication from register\n" +
                                "3. Get a list of all publications\n" +
                                "4. Get a list of all publications by language\n" +
                                "5. Add new user to register\n" +
                                "6. Delete user from register\n" +
                                "7. Get a list of all users\n" +
                                "8. Give publication to user\n" +
                                "9. Save register to storage\n" +
                                "a. Load register from storage\n" +
                                "0. Exit");
            choice = scanner.nextLine();
            switch (choice){
                case "1":
                    Publication publication = addNewPublication();
                    if(!library.checkIfPublicationExist(publication)){
                        library.addPublication(publication);
                    }else{
                        System.out.println("This publication with the same ID is already in the library register!");
                    }
                    break;
                case "2":
                    System.out.print("Enter the ID of publication: ");
                    String id = scanner.nextLine();
                    if(library.removePublication(id)){
                        System.out.println("Publication deleted successfully!");
                    }else{
                        System.out.println("Error with deleting publication!");
                    }
                    break;
                case "3":
                    PublicationRegisterPrinter printer = new PublicationRegisterPrinter(library.getPublicationList());
                    printer.printAll();
                    break;
                case "4":
                    System.out.print("Enter the language of search publication: ");
                    String language = scanner.nextLine();
                    printer = new PublicationRegisterPrinter(library.getPublicationList());
                    printer.printByLanguage(language);
                    break;
                case "5":
                    User user = addNewUser();
                    if(!library.checkIfUserExist(user)){
                        library.addUser(user);
                    }else{
                        System.out.println("This user with the same ID is already in the library register!");
                    }
                    break;
                case "6":
                    System.out.print("Enter the ID of user: ");
                    id = scanner.nextLine();
                    if(library.removeUser(id)){
                        System.out.println("User deleted successfully!");
                    }else{
                        System.out.println("Error with deleting user!");
                    }
                    break;
                case "7":
                    UserRegisterPrinter userRegisterPrinter = new UserRegisterPrinter(library.getUserList());
                    userRegisterPrinter.printAll();
                    break;
                case "8":
                    System.out.print("Enter the id of user: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter the id of publication: ");
                    String publicationId = scanner.nextLine();
                    if(library.givePublicationToUser(userId, publicationId)){
                        System.out.println("The publication have been given to user!");
                    }else{
                        System.out.println("Error with giving publication to user!");
                    }
                    break;
                case "9":
                    String filePathToWritePublications = "src\\Library\\Files\\publications.csv";
                    FileWriter fileWriterPublications = new FileWriter(new File(filePathToWritePublications));
                    fileWriterPublications.write(OutputDataFormer.publicationsToCSV(library.getPublicationList()));

                    String filePathToWriteUsers = "src\\Library\\Files\\users.csv";
                    FileWriter fileWriterUsers = new FileWriter(new File(filePathToWriteUsers));
                    fileWriterUsers.write(OutputDataFormer.usersToCSV(library.getUserList()));
                    break;
                case "a":
                    String filePathToReadPublications = "src\\Library\\Files\\publications.csv";
                    FileReader fileReaderPublications = new FileReader(new File(filePathToReadPublications));
                    String readPublications = fileReaderPublications.read();
                    library.setPublicationList(InputDataParser.parsePublicationsCSV(readPublications));

                    String filePathToReadUsers = "src\\Library\\Files\\users.csv";
                    FileReader fileReaderUsers = new FileReader(new File(filePathToReadUsers));
                    String readUsers = fileReaderUsers.read();
                    library.setUserList(InputDataParser.parseUsersCSV(readUsers));
                    break;
                case "0":
                    exitStatus = true;
                    break;
            }
        }
    }

    private static Publication addNewPublication(){

        String choice;
        boolean exitStatus = false;
        Publication publication = null;

        String id;
        String publisher;
        String author;
        String title;
        int pageCount;
        String language;

        while(!exitStatus){
            System.out.println( "1. Book\n" +
                                "2. Magazine");
            choice = scanner.nextLine();
            switch (choice){
                case "1":
                    System.out.print("Enter the ID: ");
                    id = scanner.nextLine();
                    System.out.print("Enter the publisher: ");
                    publisher = scanner.nextLine();
                    System.out.print("Enter the author: ");
                    author = scanner.nextLine();
                    System.out.print("Enter the title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter the page count: ");
                    pageCount = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter the language of publication: ");
                    language = scanner.nextLine();
                    System.out.print("Enter the publication year: ");
                    int publicationYear = Integer.parseInt(scanner.nextLine());
                    publication = new Book(id, publisher, author, title, pageCount, language, publicationYear);
                    exitStatus = true;
                    break;
                case "2":
                    System.out.print("Enter the ID: ");
                    id = scanner.nextLine();
                    System.out.print("Enter the publisher: ");
                    publisher = scanner.nextLine();
                    System.out.print("Enter the author");
                    author = scanner.nextLine();
                    System.out.print("Enter the title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter the page count: ");
                    pageCount = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter the language of publication: ");
                    language = scanner.nextLine();
                    System.out.print("Enter the article count: ");
                    int articleCount = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter the publication day: ");
                    String publicationDay = scanner.nextLine();
                    publication = new Magazine(id, publisher, author, title, pageCount, language, articleCount, publicationDay);
                    exitStatus = true;
                    break;
            }
        }

        return publication;
    }

    private static User addNewUser(){
        User newUser;

        String id;
        String firstName;
        String lastName;
        String patronymic;
        String birthYear;

        System.out.print("Enter the ID: ");
        id = scanner.nextLine();
        System.out.print("Enter the first name: ");
        firstName = scanner.nextLine();
        System.out.print("Enter the last name: ");
        lastName = scanner.nextLine();
        System.out.print("Enter the patronymic: ");
        patronymic = scanner.nextLine();
        System.out.print("Enter the birth year: ");
        birthYear = scanner.nextLine();

        newUser = new User(id, firstName, lastName, patronymic, birthYear);

        return newUser;
    }
}