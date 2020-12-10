package Library;

import Library.Objects.Library;
import Library.Objects.Persons.User;
import Library.Objects.Publications.Book;
import Library.Objects.Publications.Magazine;
import Library.Objects.Publications.Publication;
import Library.Objects.Address;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Address libraryAddress = new Address("Ukraine", "Kharkiv", "Klochkivska", "1337");
        Library library = new Library("Andrew Klochko Library", libraryAddress);

        String choice;
        boolean exitStatus = false;
        while(!exitStatus){
            System.out.println( "1. Add new publication to register\n" +
                                "2. Delete publication from register\n" +
                                "3. Get a list of all publications\n" +
                                "4. Get a list of all publications sorted by print language\n" +
                                "5. Add new user to register\n" +
                                "6. Delete user from register\n" +
                                "7. Give publication to user\n" +
                                "8. Save register to storage\n" +
                                "9. Load register from storage\n" +
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
                    break;
                case "4":
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
                case "8":
                    break;
                case "9":
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
        String title;
        int pageCount;
        String languageOfPublication;

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
                    System.out.print("Enter the title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter the page count: ");
                    pageCount = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter the language of publication: ");
                    languageOfPublication = scanner.nextLine();
                    System.out.print("Enter the publication year: ");
                    int publicationYear = Integer.parseInt(scanner.nextLine());
                    publication = new Book(id, publisher, title, pageCount, languageOfPublication, publicationYear);
                    exitStatus = true;
                    break;
                case "2":
                    System.out.print("Enter the ID: ");
                    id = scanner.nextLine();
                    System.out.print("Enter the publisher: ");
                    publisher = scanner.nextLine();
                    System.out.print("Enter the title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter the page count: ");
                    pageCount = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter the language of publication: ");
                    languageOfPublication = scanner.nextLine();
                    System.out.print("Enter the article count: ");
                    int articleCount = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter the publication day: ");
                    String publicationDay = scanner.nextLine();
                    publication = new Magazine(id, publisher, title, pageCount, languageOfPublication, articleCount, publicationDay);
                    exitStatus = true;
                    break;
            }
        }

        return publication;
    }

    private static User addNewUser(){
        User newUser = null;

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