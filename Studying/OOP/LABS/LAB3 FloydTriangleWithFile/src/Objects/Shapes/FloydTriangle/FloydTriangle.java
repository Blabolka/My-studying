package Objects.Shapes.FloydTriangle;

import Objects.Shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class FloydTriangle implements Shape {

    private final static String NEXT_LINE = System.lineSeparator();

    private int numberOfRows;
    private TriangleTypes type;
    private List<Integer> lazyCaterersSequence;
    private List<Integer> triangularNumbers;
    private List<Integer> sequence;

    public FloydTriangle(int numberOfRows, TriangleTypes type){
        this.numberOfRows = numberOfRows;
        this.type = type;
        lazyCaterersSequence = calculateLazyCaterersSequence();
        triangularNumbers = calculateTriangularNumbers();
        sequence = calculateSequence();
    }

    public int getNumberOfRows(){
        return numberOfRows;
    }

    @Override
    public String getStringRepresentation(){
        if(type == TriangleTypes.NORMAL){
            return normalRepresentation();
        }else if(type == TriangleTypes.INVERTED){
            return invertedRepresentation();
        }else if(type == TriangleTypes.SHUFFLED){
            return shuffledRepresentation();
        }else{
            return "";
        }
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


    private String normalRepresentation(){
        StringBuilder triangleString = new StringBuilder();
        for (int i = 0; i < numberOfRows; i++) {
            triangleString.append(createNormalLine(i)).append(NEXT_LINE);
        }
        return triangleString.toString();
    }

    private String invertedRepresentation(){
        StringBuilder triangleString = new StringBuilder();
        for (int i = numberOfRows-1; i >= 0; i--) {
            triangleString.append(createInvertedLine(i)).append(NEXT_LINE);
        }
        return triangleString.toString();
    }

    private String shuffledRepresentation(){
        StringBuilder triangleString = new StringBuilder();
        for (int i = 0; i < numberOfRows; i++) {
            if(i%2 == 0){
                triangleString.append(createNormalLine(i)).append(NEXT_LINE);
            }else{
                triangleString.append(createInvertedLine(i)).append(NEXT_LINE);
            }
        }
        return triangleString.toString();
    }

    private String createNormalLine(int index){
        StringBuilder createdLine = new StringBuilder();
        for (int i = lazyCaterersSequence.get(index); i <= triangularNumbers.get(index); i++) {
            createdLine.append(i).append("\t");
        }
        return createdLine.toString();
    }

    private String createInvertedLine(int index){
        StringBuilder createdLine = new StringBuilder();
        for (int i = triangularNumbers.get(index); i >= lazyCaterersSequence.get(index); i--) {
            createdLine.append(i).append("\t");
        }
        return createdLine.toString();
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
