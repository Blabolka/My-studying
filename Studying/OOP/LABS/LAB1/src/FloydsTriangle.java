import java.util.ArrayList;
import java.util.List;

public class FloydsTriangle {

    private final int numberOfRows;
    private List<Integer> numbersForFloydsTriangle;

    public FloydsTriangle(int numberOfRows){
        this.numberOfRows = numberOfRows;
        fillArray();
    }

    private void fillArray(){

        numbersForFloydsTriangle = new ArrayList<Integer>(numberOfRows);

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = getNumberInColumnByRow(i); j < getNumberInDiagonalByRow(i+1)+1; j++) {
                numbersForFloydsTriangle.add(j);
            }
        }
    }

    private static int getNumberInColumnByRow(int row){
        return (row*row + row + 2) / 2;
    }

    private static int getNumberInDiagonalByRow(int row){
        return (row*(row + 1)) / 2;
    }

    public void printDirect(){

        if(numberOfRows != 0){

            int index = 0;

            for (int i = 0; i < numberOfRows; i++) {
                for (int j = 0; j < i+1; j++) {
                    System.out.print(numbersForFloydsTriangle.get(index) + " ");
                    index++;
                }
                System.out.println();
            }

        }
    }

    public void printConverse(){

        if(numberOfRows != 0){

            int index = numbersForFloydsTriangle.size()-1;

            for (int i = numberOfRows; i > 0; i--) {
                for (int j = i; j > 0 ; j--) {
                    System.out.print(numbersForFloydsTriangle.get(index) + " ");
                    index--;
                }
                System.out.println();
            }
        }
    }
}
