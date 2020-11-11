package FileWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriter {

    private final File fileToWrite;

    public FileWriter(String filePathToWrite){
        fileToWrite = new File(filePathToWrite);
    }

    public void writeTextToFile(String text){
        try(BufferedWriter bw = new BufferedWriter(new java.io.FileWriter(fileToWrite))){
            bw.write(text);
        }catch (IOException exception){
            System.out.println("PROBLEM WITH WRITING TO FILE");
        }
    }
}
