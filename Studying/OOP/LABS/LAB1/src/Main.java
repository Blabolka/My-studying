import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FloydsTriangle floydsTriangle;
        String choice;

        while(true){
            System.out.println("1: Make Floyd's Triangle\n" + "0: Exit");
            choice = scanner.next();

            if(choice.equals("1")){
                System.out.println("1: Print direct triangle\n" + "2: Print converse triangle");
                choice = scanner.next();

                System.out.print("Enter the number of rows for floyd's triangle: ");
                int numberOfRowsFloydsTriangle = scanner.nextInt();
                floydsTriangle = new FloydsTriangle(numberOfRowsFloydsTriangle);

                if(choice.equals("1")){
                    floydsTriangle.printDirect();
                }else if(choice.equals("2")) {
                    floydsTriangle.printConverse();
                }
            }else if(choice.equals("0")){
                break;
            }
        }
    }
}
