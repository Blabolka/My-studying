import java.util.ArrayList;
import java.util.List;

public class FloydTriangle {

    private int numberOfRows;
    private List<Integer> sequence;

    public FloydTriangle(int numberOfRows){
        this.numberOfRows = numberOfRows;
        fillSequence();
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

    public int getNumberOfRows(){
        return numberOfRows;
    }

    public List<Integer> getSequence(){
        return new ArrayList<>(sequence);
    }
}
