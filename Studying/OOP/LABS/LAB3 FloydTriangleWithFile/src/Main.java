import Objects.FileOperations.FileReader.FileReader;
import Objects.FileOperations.FileWriter.FileWriter;
import Objects.Shapes.FloydTriangle.TriangleTypes;
import Objects.Shapes.Shape;
import Objects.Shapes.ShapePrinter;
import Objects.TextOperations.OutputStringFormer;
import Objects.TextOperations.ReadTextInfoParser;
import Objects.Shapes.FloydTriangle.FloydTriangle;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        File fileToRead = new File("src\\Objects\\Files\\InputFiles\\input.txt");
        FileReader fileReader = new FileReader(fileToRead);

        ReadTextInfoParser readTextInfo = new ReadTextInfoParser(fileReader.readText());
        Integer numberOfLines = readTextInfo.getNumberOfLinesInFloydTriangle();
        String order = readTextInfo.getOrderOfPrintFloydTriangle();

        TriangleTypes type;
        if(order.equals("normal")){
            type = TriangleTypes.NORMAL;
        }else if(order.equals("inverted")){
            type = TriangleTypes.INVERTED;
        }else if(order.equals("shuffled")){
            type = TriangleTypes.SHUFFLED;
        }else{
            throw new RuntimeException();
        }

        Shape floydTriangle = new FloydTriangle(numberOfLines, type);

        ShapePrinter shapePrinter = new ShapePrinter(floydTriangle);
        shapePrinter.printConsole();

        OutputStringFormer outputStringFormer = new OutputStringFormer();
        outputStringFormer.addModification( "FLOYD’S TRIANGLE CONSISTS OF " +numberOfLines+ " LINES IN " +order+ " ORDER", floydTriangle.getStringRepresentation(), "POWERED BY JAVA. ENJOY OOP!");

        File fileToWrite = new File("src\\Objects\\Files\\OutputFiles\\output.txt");
        FileWriter fileWriter = new FileWriter(fileToWrite);

        fileWriter.writeTextToFile(outputStringFormer.getFormedModifications());
    }
}