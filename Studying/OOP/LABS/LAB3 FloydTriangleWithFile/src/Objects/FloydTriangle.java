package Objects;

import java.util.ArrayList;
import java.util.List;

public class FloydTriangle {

    private int numberOfRows;
    private List<Integer> sequence;

    public FloydTriangle(int numberOfRows){
        this.numberOfRows = numberOfRows;
        sequence = calculateSequence();
    }

    public int getNumberOfRows(){
        return numberOfRows;
    }

    public List<Integer> getSequence(){
        return sequence;
    }

    private List<Integer> calculateSequence(){
        List<Integer> lazyCaterersSequence = calculateLazyCaterersSequence();
        List<Integer> triangularNumbers = calculateTriangularNumbers();
        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = lazyCaterersSequence.get(i); j <= triangularNumbers.get(i); j++) {
                sequence.add(j);
            }
        }
        return sequence;
    }

    private List<Integer> calculateLazyCaterersSequence(){
        List<Integer> lazyCaterersSequence = new ArrayList<>();
        for (int i = 0; i < numberOfRows; i++) {
            lazyCaterersSequence.add(getCentralPolygonalNumber(i));
        }
        return lazyCaterersSequence;
    }

    private List<Integer> calculateTriangularNumbers(){
        List<Integer> triangularNumbers = new ArrayList<>();
        for (int i = 1; i <= numberOfRows; i++) {
            triangularNumbers.add(getTriangularNumber(i));
        }
        return triangularNumbers;
    }

    private int getCentralPolygonalNumber(int row){
        return (row*row + row + 2) / 2;
    }

    private static int getTriangularNumber(int row){
        return (row*(row + 1)) / 2;
    }

}
