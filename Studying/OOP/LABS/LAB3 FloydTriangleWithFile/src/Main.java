import Objects.FileOperations.FileReader.FileReader;
import Objects.FileOperations.FileWriter.FileWriter;
import Objects.FileOperations.ReadTextOperations;
import Objects.FloydTriangle;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        File fileToRead = new File("src\\Objects\\Files\\InputFiles\\input.txt");
        FileReader fileReader = new FileReader(fileToRead);

        ReadTextOperations readTextOperations = new ReadTextOperations(fileReader.readText());

        FloydTriangle floydTriangle = new FloydTriangle(readTextOperations.getNumberOfLinesInFloydTriangle());



        File fileToWrite = new File("src\\Objects\\Files\\OutputFiles\\output.txt");
        FileWriter fileWriter = new FileWriter(fileToWrite);
    }
}