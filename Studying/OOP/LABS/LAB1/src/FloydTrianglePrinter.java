public class FloydTrianglePrinter {

    private final FloydTriangle floydTriangle;

    public FloydTrianglePrinter(FloydTriangle floydTriangle){
        this.floydTriangle = floydTriangle;
    }

    public void printDirect(){
        int index = 0;
        for (int i = 0; i < floydTriangle.getNumberOfRows(); i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print(floydTriangle.getSequence().get(index) + " ");
                index++;
            }
            System.out.println();
        }
    }

    public void printConverse(){
        int index = floydTriangle.getSequence().size()-1;
        for (int i = floydTriangle.getNumberOfRows(); i > 0; i--) {
            for (int j = i; j > 0 ; j--) {
                System.out.print(floydTriangle.getSequence().get(index) + " ");
                index--;
            }
            System.out.println();
        }
    }
}
