public class FloydTrianglePrinter {

    public static void printDirect(FloydTriangle triangle){
        int index = 0;
        for (int i = 0; i < triangle.getNumberOfRows(); i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print(triangle.getSequence().get(index) + " ");
                index++;
            }
            System.out.println();
        }
    }

    public static void printConverse(FloydTriangle triangle){
        int index = triangle.getSequence().size()-1;
        for (int i = triangle.getNumberOfRows(); i > 0; i--) {
            for (int j = i; j > 0 ; j--) {
                System.out.print(triangle.getSequence().get(index) + " ");
                index--;
            }
            System.out.println();
        }
    }
}
