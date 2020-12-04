import Objects.FileOperations.FileReader.FileReader;
import Objects.FileOperations.FileWriter.FileWriter;
import Objects.FloydTriangle.FloydTrianglePrinter;
import Objects.TextOperations.FloydTriangleStringFormer;
import Objects.TextOperations.ReadTextOperations;
import Objects.FloydTriangle.FloydTriangle;
import Objects.TextOperations.StringToOutputFormer;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        File fileToRead = new File("src\\Objects\\Files\\InputFiles\\input.txt");
        FileReader fileReader = new FileReader(fileToRead);

        ReadTextOperations readTextInfo = new ReadTextOperations(fileReader.readText());
        Integer numberOfLines = readTextInfo.getNumberOfLinesInFloydTriangle();
        String order = readTextInfo.getOrderOfPrintFloydTriangle();


        FloydTriangle floydTriangle = new FloydTriangle(readTextInfo.getNumberOfLinesInFloydTriangle());

        FloydTrianglePrinter floydTrianglePrinter = new FloydTrianglePrinter(floydTriangle);
        FloydTriangleStringFormer floydTriangleStringFormer = new FloydTriangleStringFormer(floydTriangle);

        String triangle = null;
        if(order.equals("normal")){
            floydTrianglePrinter.normal();
            triangle = floydTriangleStringFormer.normal();
        }else if(order.equals("inverted")){
            floydTrianglePrinter.inverted();
            triangle = floydTriangleStringFormer.inverted();
        }else if(order.equals("shuffled")){
            floydTrianglePrinter.shuffled();
            triangle = floydTriangleStringFormer.shuffled();
        }

        StringToOutputFormer stringToOutput = new StringToOutputFormer();
        stringToOutput.addModification("FLOYD’S TRIANGLE CONSISTS OF " +numberOfLines+ " LINES IN " +order+ " ORDER", triangle, "POWERED BY JAVA. ENJOY OOP!");

        File fileToWrite = new File("src\\Objects\\Files\\OutputFiles\\output.txt");
        FileWriter fileWriter = new FileWriter(fileToWrite);

        fileWriter.writeTextToFile(stringToOutput.getFormedString());
    }
}