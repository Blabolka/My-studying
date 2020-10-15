import java.io.*;

public class ModifyFile {

    private File fileToRead;
    private File fileToWrite;

    public ModifyFile(String fileReaderName, String fileWriterName){
        fileToRead = new File(fileReaderName);
        fileToWrite = new File(fileWriterName);
    }

    void splitStringIntoSentences() {


        try(BufferedReader br = new BufferedReader(new FileReader(fileToRead));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite, true))) {
            bw.write("РАЗБИЕНИЕ ТЕКСТА НА ПРЕДЛОЖЕНИЯ" + System.lineSeparator());

            String line;
            StringBuffer sb = new StringBuffer();
            while( (line = br.readLine()) != null){
                for (int i = 0; i < line.length(); i++) {
                    if(line.charAt(i) == '.'){
                        bw.write(sb.toString() + System.lineSeparator());
                        sb.setLength(0);
                    }else{
                        sb.append(line.charAt(i));
                    }
                }
            }
            bw.write(sb.toString() + System.lineSeparator());

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    void splitStringIntoWords(){

        try(BufferedReader br = new BufferedReader(new FileReader(fileToRead));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite, true))){
            bw.write("РАЗБИЕНИЕ ТЕКСТА НА СЛОВА И СЛОВОСОЧЕТАНИЯ" + System.lineSeparator());

            String line;
            StringBuffer sb = new StringBuffer();
            while( (line = br.readLine()) != null){
                for (int i = 0; i < line.length(); i++) {
                    if(line.charAt(i) == ' ' || line.charAt(i) == '.' || line.charAt(i) == ','){
                        if(sb.length() != 0){
                            bw.write(sb.toString() + System.lineSeparator());
                            sb.setLength(0);
                        }

                    }else{
                        sb.append(line.charAt(i));
                    }
                }
            }
            bw.write(sb.toString() + System.lineSeparator());

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    void clearFile(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite))){
            bw.write("");
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

}
