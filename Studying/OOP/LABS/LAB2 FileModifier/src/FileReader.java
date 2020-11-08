import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {

    File fileToRead;

    private static final String NEXT_LINE = System.lineSeparator();

    public FileReader(String filePathToRead){
        fileToRead = new File(filePathToRead);
    }

    public String getAllTextFromFile(){

        StringBuilder allTextFromFile = new StringBuilder();

        try(BufferedReader br = new BufferedReader(new java.io.FileReader(fileToRead))){
            String line;
            while((line = br.readLine()) != null){
                allTextFromFile.append(line).append(NEXT_LINE);
            }
        } catch (IOException exception) {
            System.out.println("PROBLEM WITH READING FROM FILE");
        }

        return allTextFromFile.toString();
    }
}
