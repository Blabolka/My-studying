package Objects.FloydTriangle;

import java.util.ArrayList;
import java.util.List;

public class FloydTriangle {

    private int numberOfRows;
    private List<Integer> lazyCaterersSequence;
    private List<Integer> triangularNumbers;
    private List<Integer> sequence;

    public FloydTriangle(int numberOfRows){
        this.numberOfRows = numberOfRows;
        lazyCaterersSequence = calculateLazyCaterersSequence();
        triangularNumbers = calculateTriangularNumbers();
        sequence = calculateSequence();
    }

    public int getNumberOfRows(){
        return numberOfRows;
    }



    public List<Integer> getLazyCaterersSequence(){
        return new ArrayList<>(lazyCaterersSequence);
    }

    public List<Integer> getTriangularNumbers(){
        return new ArrayList<>(triangularNumbers);
    }

    public List<Integer> getSequence(){
        return new ArrayList<>(sequence);
    }

    private List<Integer> calculateSequence(){

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
