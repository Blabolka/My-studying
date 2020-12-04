import Objects.FileOperations.FileReader.FileReader;
import Objects.FileOperations.FileWriter.FileWriter;
import Objects.FloydTriangle.FloydTrianglePrinter;
import Objects.TextOperations.FloydTriangleStringFormer;
import Objects.TextOperations.ReadTextOperations;
import Objects.FloydTriangle.FloydTriangle;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        File fileToRead = new File("src\\Objects\\Files\\InputFiles\\input.txt");
        FileReader fileReader = new FileReader(fileToRead);

        ReadTextOperations readTextOperations = new ReadTextOperations(fileReader.readText());

        FloydTriangle floydTriangle = new FloydTriangle(readTextOperations.getNumberOfLinesInFloydTriangle());

        FloydTrianglePrinter floydTrianglePrinter = new FloydTrianglePrinter(floydTriangle);
        FloydTriangleStringFormer floydTriangleStringFormer = new FloydTriangleStringFormer(floydTriangle);


//        floydTrianglePrinter.direct();
//        floydTrianglePrinter.inverse();
//        floydTrianglePrinter.shuffle();
        System.out.println(floydTriangleStringFormer.direct());
        System.out.println(floydTriangleStringFormer.inverse());
        System.out.println(floydTriangleStringFormer.shuffle());

        File fileToWrite = new File("src\\Objects\\Files\\OutputFiles\\output.txt");
        FileWriter fileWriter = new FileWriter(fileToWrite);
    }
}