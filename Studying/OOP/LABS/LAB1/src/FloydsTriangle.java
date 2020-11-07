import java.util.ArrayList;
import java.util.List;

public class FloydsTriangle {

    private int numberOfRows;
    private List<Integer> sequence;

    public FloydsTriangle(int numberOfRows){
        this.numberOfRows = numberOfRows;
        fillArray();
    }

    private void fillArray(){
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

    public int getNumberOfRows(){
        return numberOfRows;
    }

    public List<Integer> getSequence(){
        return sequence;
    }
}
