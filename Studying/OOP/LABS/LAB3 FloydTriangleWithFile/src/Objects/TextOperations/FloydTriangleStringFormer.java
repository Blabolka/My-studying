package Objects.TextOperations;

import Objects.FloydTriangle.FloydTriangle;

public class FloydTriangleStringFormer {

    private static final String NEXT_LINE = System.lineSeparator();

    private final FloydTriangle floydTriangle;

    public FloydTriangleStringFormer(FloydTriangle floydTriangle){
        this.floydTriangle = floydTriangle;
    }

    public String normal(){
        StringBuilder triangleString = new StringBuilder();
        for (int i = 0; i < floydTriangle.getNumberOfRows(); i++) {
            triangleString.append(createLineDirect(i)).append(NEXT_LINE);
        }
        return triangleString.toString();
    }

    public String inverted(){
        StringBuilder triangleString = new StringBuilder();
        for (int i = floydTriangle.getNumberOfRows()-1; i >= 0; i--) {
            triangleString.append(createLineInverse(i)).append(NEXT_LINE);
        }
        return triangleString.toString();
    }

    public String shuffled(){
        StringBuilder triangleString = new StringBuilder();
        for (int i = 0; i < floydTriangle.getNumberOfRows(); i++) {
            if(i%2 == 0){
                triangleString.append(createLineDirect(i)).append(NEXT_LINE);
            }else{
                triangleString.append(createLineInverse(i)).append(NEXT_LINE);
            }
        }
        return triangleString.toString();
    }

    private String createLineDirect(int index){
        StringBuilder createdLine = new StringBuilder();
        for (int i = floydTriangle.getLazyCaterersSequence().get(index); i <= floydTriangle.getTriangularNumbers().get(index); i++) {
            createdLine.append(i).append("\t");
        }
        return createdLine.toString();
    }

    private String createLineInverse(int index){
        StringBuilder createdLine = new StringBuilder();
        for (int i = floydTriangle.getTriangularNumbers().get(index); i >= floydTriangle.getLazyCaterersSequence().get(index); i--) {
            createdLine.append(i).append("\t");
        }
        return createdLine.toString();
    }
}
