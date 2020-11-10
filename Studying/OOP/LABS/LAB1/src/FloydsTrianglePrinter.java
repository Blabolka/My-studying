import java.util.List;

public class FloydsTrianglePrinter {

    private int numberOfRows;
    private List<Integer> sequence;

    public FloydsTrianglePrinter(int numberOfRows, List<Integer> sequence){
        this.numberOfRows = numberOfRows;
        this.sequence = sequence;
    }

    public void printDirect(){
        int index = 0;
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print(sequence.get(index) + " ");
                index++;
            }
            System.out.println();
        }
    }

    public void printConverse(){
        int index = sequence.size()-1;
        for (int i = numberOfRows; i > 0; i--) {
            for (int j = i; j > 0 ; j--) {
                System.out.print(sequence.get(index) + " ");
                index--;
            }
            System.out.println();
        }
    }
}
