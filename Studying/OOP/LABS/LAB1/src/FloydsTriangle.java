import java.util.ArrayList;
import java.util.List;

public class FloydsTriangle {

    private int numberOfRows;
    private List<Integer> sequence;
    private FloydsTrianglePrinter printer;

    public FloydsTriangle(int numberOfRows){
        this.numberOfRows = numberOfRows;
        fillSequence();
        printer = new FloydsTrianglePrinter(numberOfRows, sequence);
    }

    private void fillSequence(){
        sequence = new ArrayList<>(numberOfRows);

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = getCentralPolygonalNumber(i); j <= getTriangularNumber(i+1); j++) {
                sequence.add(j);
            }
        }
    }

    private static int getCentralPolygonalNumber(int row){
        return (row*row + row + 2) / 2;
    }

    private static int getTriangularNumber(int row){
        return (row*(row + 1)) / 2;
    }

    public void printDirect(){
        printer.printDirect();
    }

    public void printConverse(){
        printer.printConverse();
    }
}
