package Objects.Shapes;

public class ShapePrinter {

    private Shape shape;

    public ShapePrinter(Shape shape){
        this.shape = shape;
    }

    public void printConsole(){
        System.out.println(shape.stringRepresentation());
    }
}
