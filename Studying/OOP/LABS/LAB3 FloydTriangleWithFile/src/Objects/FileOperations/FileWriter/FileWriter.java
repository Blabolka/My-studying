package Objects.FileOperations.FileWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriter {

    private final File file;

    public FileWriter(File file){
        this.file = file;
    }

    public void write(String text){
        try(BufferedWriter bw = new BufferedWriter(new java.io.FileWriter(file))){
            bw.write(text);
        }catch (IOException exception){
            System.out.println("PROBLEM WITH WRITING TO FILE");
        }
    }
}