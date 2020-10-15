import java.io.*;
import java.util.ArrayList;

public class ModifyFile {

    private File fileToRead;
    private File fileToWrite;

    public ModifyFile(String fileReaderName, String fileWriterName){
        fileToRead = new File(fileReaderName);
        fileToWrite = new File(fileWriterName);
    }

    void copyContent(){
        try(BufferedReader br = new BufferedReader(new FileReader(fileToRead));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite, true))) {
            bw.write("КОПИРОВАНИЕ КОНТЕНТА ФАЙЛА" + System.lineSeparator());

            String line;
            while ((line = br.readLine()) != null){
                bw.write(line + System.lineSeparator());
            }
            bw.write(System.lineSeparator());

        }catch (IOException ex){
        }
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
        }
    }

    void splitStringIntoWords(){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite, true))){
            bw.write("РАЗБИЕНИЕ ТЕКСТА НА СЛОВА И СЛОВОСОЧЕТАНИЯ" + System.lineSeparator());

            ArrayList<String> arrayList = getAllWordsFromFile();

            for(int i=0 ; i < arrayList.size() ; i++){
                bw.write(arrayList.get(i) + System.lineSeparator());
            }

        }catch (IOException ex){
        }
    }

    void countNumberOfWords(){

        try(BufferedReader br = new BufferedReader(new FileReader(fileToRead));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite, true))){

            bw.write("ПОДСЧЁТ КОЛИЧЕСТВА СЛОВ" + System.lineSeparator());

            int counter = 0;
            String line;
            while( (line = br.readLine()) != null ){
                for(int i=0 ; i<line.length() ; i++){
                    if(line.charAt(i) == ' '){
                        counter++;
                    }
                }
            }
            bw.write("КОЛИЧЕСТВО СЛОВ: " + counter + System.lineSeparator() + System.lineSeparator());

        }catch(IOException ex){

        }
    }

    void countNumberOfSymbols(){

        try(BufferedReader br = new BufferedReader(new FileReader(fileToRead));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite, true))){

            bw.write("ПОДСЧЁТ КОЛИЧЕСТВА СИМВОЛОВ" + System.lineSeparator());

            int counter = 0;
            String line;
            while( (line = br.readLine()) != null ){
                counter += line.length();
            }
            bw.write("КОЛИЧЕСТВО СИМВОЛОВ: " + counter + System.lineSeparator() + System.lineSeparator());

        }catch(IOException ex){

        }
    }

    void changeFirstSybolOfEveryWordToUppercase(){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite, true))){

            bw.write("ЗАМЕНА ВСЕХ ПЕРВЫХ СТРОЧНЫХ БУКВ В СЛОВАХ НА ПРОПИСНУЮ" + System.lineSeparator());

            ArrayList<String> arrayList = getAllWordsFromFile();

            for (int i = 0; i < arrayList.size(); i++) {
                if(arrayList.get(i) != null || !arrayList.get(i).equals("")){
                    arrayList.set(i, arrayList.get(i).substring(0,1).toUpperCase() + arrayList.get(i).substring(1));
                    bw.write(arrayList.get(i) + " ");
                }
            }

        }catch(IOException ex){
        }
    }

    void clearFile(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite))){
            bw.write("");
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private ArrayList<String> getAllWordsFromFile(){

        ArrayList<String> arrayList = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(fileToRead))){

            String line;
            StringBuffer sb = new StringBuffer();
            while( (line = br.readLine()) != null){
                for (int i = 0; i < line.length(); i++) {
                    if(line.charAt(i) == ' '){
                        if(sb.length() != 0){
                            arrayList.add(sb.toString());
                            sb.setLength(0);
                        }
                    }else{
                        sb.append(line.charAt(i));
                    }
                }
                sb.append(System.lineSeparator());
                arrayList.add(sb.toString());
                sb.setLength(0);
            }

        }catch (IOException ex){
        }

        return arrayList;
    }

}
