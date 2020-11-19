package Library;

import Library.Objects.Library;
import Library.Objects.Publications.Book;
import Library.Objects.Publications.Magazine;
import Library.Objects.Publications.Publication;
import Library.Objects.Register.RegisterPrinter;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Library library = new Library("Andrew Klochko Library", "Ukraine", "Kharkiv", "Klochkivska", "1337");


        String choice;
        boolean exitStatus = false;
        while(!exitStatus){
            System.out.println( "1. Add new publication to register\n" +
                                "2. Delete publication from register\n" +
                                "3. Get a list of all publications\n" +
                                "4. Get a list of all publications sorted by print language\n" +
                                "5. Add new user\n" +
                                "6. Give publication to user\n" +
                                "7. Save register to storage\n" +
                                "8. Load register from storage\n" +
                                "0. Exit");
            choice = scanner.next();
            switch (choice){
                case "1":
                    Publication publication = addNewPublication();
                    if(publication != null){
                        library.add(publication);
                    }
                    break;
                case "2":
                    break;
                case "3":
                    RegisterPrinter.printAllPublications(library.getPublicationList());
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
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

        String title;
        int pageCount;
        String languageOfPublication;

        while(!exitStatus){
            System.out.println( "1. Book\n" +
                                "2. Magazine");
            choice = scanner.next();
            switch (choice){
                case "1":
                    System.out.print("Enter the title: ");
                    title = scanner.next();
                    System.out.print("Enter the page count: ");
                    pageCount = scanner.nextInt();
                    System.out.print("Enter the language of publication: ");
                    languageOfPublication = scanner.next();
                    System.out.print("Enter the publication your: ");
                    int publicationYear = scanner.nextInt();
                    publication = new Book(title, pageCount, languageOfPublication, publicationYear);
                    exitStatus = true;
                    break;
                case "2":
                    System.out.print("Enter the title: ");
                    title = scanner.next();
                    System.out.print("Enter the page count: ");
                    pageCount = scanner.nextInt();
                    System.out.print("Enter the language of publication: ");
                    languageOfPublication = scanner.next();
                    System.out.print("Enter the article count: ");
                    int articleCount = scanner.nextInt();
                    publication = new Magazine(title, pageCount, languageOfPublication, articleCount);
                    exitStatus = true;
                    break;
            }
        }

        return publication;
    }




}