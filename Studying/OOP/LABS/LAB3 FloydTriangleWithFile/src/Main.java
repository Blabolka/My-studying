import Objects.FileOperations.FileReader.FileReader;
import Objects.FileOperations.ReadTextOperations;
import Objects.FloydTriangle;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader("src\\Objects\\Files\\InputFiles\\input.txt");
        ReadTextOperations readTextOperations = new ReadTextOperations(fileReader.readText());

        FloydTriangle floydTriangle = new FloydTriangle(readTextOperations.getNumberOfLinesInFloydTriangle());
    }
}
