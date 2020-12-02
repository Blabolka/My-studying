package Objects.FileOperations.FileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReader {

    private final File fileToRead;

    private static final String NEXT_LINE = System.lineSeparator();

    public FileReader(File fileToRead){
        this.fileToRead = fileToRead;
    }

    public String readText(){

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