package Objects.FloydTriangle;

public class FloydTrianglePrinter {

    private final FloydTriangle floydTriangle;

    public FloydTrianglePrinter(FloydTriangle floydTriangle){
        this.floydTriangle = floydTriangle;
    }

    public void direct(){
        for (int i = 0; i < floydTriangle.getNumberOfRows(); i++) {
            printLineDirect(i);
            System.out.println();
        }
    }

    public void inverse(){
        for (int i = floydTriangle.getNumberOfRows()-1; i >= 0; i--) {
            printLineInverse(i);
            System.out.println();
        }
    }

    public void shuffle(){
        for (int i = 0; i < floydTriangle.getNumberOfRows(); i++) {
            if (i % 2 == 0) {
                printLineDirect(i);
            } else {
                printLineInverse(i);
            }
            System.out.println();
        }
    }

    private void printLineDirect(int index){
        for (int i = floydTriangle.getLazyCaterersSequence().get(index); i <= floydTriangle.getTriangularNumbers().get(index); i++) {
            System.out.print(i + "\t");
        }
    }

    private void printLineInverse(int index){
        for (int i = floydTriangle.getTriangularNumbers().get(index); i >= floydTriangle.getLazyCaterersSequence().get(index); i--) {
            System.out.print(i + "\t");
        }
    }
}
