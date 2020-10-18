
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ModifyFile {

    private File fileToRead;
    private File fileToWrite;

    public ModifyFile(String fileReaderName, String fileWriterName){
        fileToRead = new File(fileReaderName);
        fileToWrite = new File(fileWriterName);
    }

    public void copyContent(){
        try(BufferedReader br = new BufferedReader(new FileReader(fileToRead));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite, true))) {
            bw.write("КОПИРОВАНИЕ КОНТЕНТА ФАЙЛА" + System.lineSeparator());

            String line;
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null){
                sb.append(line + System.lineSeparator());
            }
            bw.write(sb.toString() + System.lineSeparator());

        }catch (IOException ex){
        }
    }

    public void splitStringBySeparator(String separator) {

        try(BufferedReader br = new BufferedReader(new FileReader(fileToRead));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite, true))) {
            bw.write("РАЗБИЕНИЕ ТЕКСТА НА ПРЕДЛОЖЕНИЯ ПО РАЗДЕЛИТЕЛЮ '" + separator + "'" + System.lineSeparator());

            String line;
            StringBuilder sb = new StringBuilder();
            while( (line = br.readLine()) != null){
                String[] sentences;
                if(separator.equals(".")){
                    sentences = line.split("\\.");
                }else{
                    sentences = line.split(separator);
                }

                for (int i = 0; i < sentences.length; i++) {
                    sb.append(sentences[i]).append(System.lineSeparator());
                }
            }
            bw.write(sb.toString() + System.lineSeparator());
        }catch (IOException ex){
        }
    }

    public void countNumberOfWords(){

        try(BufferedReader br = new BufferedReader(new FileReader(fileToRead));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite, true))){

            bw.write("ПОДСЧЁТ КОЛИЧЕСТВА СЛОВ" + System.lineSeparator());

            int counter = 0;
            String line;
            while( (line = br.readLine()) != null){
                String[] words = line.split(" ");
                counter += words.length;
            }
            bw.write("КОЛИЧЕСТВО СЛОВ: "+ counter + System.lineSeparator() + System.lineSeparator());

        }catch(IOException ex){

        }
    }

    public void countNumberOfSymbols(){

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

    public void changeFirstSymbolOfEveryWordToUppercase(){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite, true));
            BufferedReader br = new BufferedReader(new FileReader(fileToRead))){

            bw.write("ЗАМЕНА ВСЕХ ПЕРВЫХ СТРОЧНЫХ БУКВ В СЛОВАХ НА ПРОПИСНУЮ" + System.lineSeparator());

            String line;
            StringBuilder sb = new StringBuilder();
            while( (line = br.readLine()) != null){
                String[] words = line.split("\\s");

                for (int i = 0; i < words.length; i++) {
                    sb.append(words[i].substring(0, 1).toUpperCase()).append(words[i].substring(1)).append(" ");
                }
                sb.append(System.lineSeparator()).append(System.lineSeparator());
                bw.write(sb.toString());
            }

        }catch(IOException ex){
        }
    }

    public void changeEverySecondWordToUpperCase(){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite, true));
            BufferedReader br = new BufferedReader(new FileReader(fileToRead))){

            bw.write("ЗАМЕНА КАЖДОГО ВТОРОГО СЛОВА НА ПРОПИСНОЕ" + System.lineSeparator());

            int counter = 0;
            String line;
            StringBuilder sb = new StringBuilder();
            while( (line = br.readLine()) != null){
                String[] words = line.split("\\s");

                for (int i = 0; i < words.length; i++) {
                    counter++;
                    if(counter%2 == 0){
                        sb.append(words[i].toUpperCase()).append(" ");
                    }else{
                        sb.append(words[i]).append(" ");
                    }
                }
                sb.append(System.lineSeparator()).append(System.lineSeparator());
                bw.write(sb.toString());
            }

        }catch(IOException ex){
        }
    }

    public void createNewWordsFromOld(){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite, true));
            BufferedReader br = new BufferedReader(new FileReader(fileToRead))){

            bw.write("СОЗДАНИЕ НОВОГО СЛОВА ИЗ ПЕРВЫХ И ПОСЛЕДНИХ ДВУХ БУКВ СТАРОГО" + System.lineSeparator());

            String line;
            StringBuilder sbOldWord = new StringBuilder();
            StringBuilder sbNewWord = new StringBuilder();
            while((line = br.readLine()) != null){
                String[] words = line.split(" ");

                for (int i = 0; i < words.length; i++) {

                    //Get string without symbols
                    for (int j = 0; j < words[i].length(); j++) {
                        if(Character.isLetter(words[i].charAt(j))){
                            sbOldWord.append(words[i].charAt(j));
                        }
                    }

                    if(sbOldWord.length()>=4){
                        sbNewWord.append(sbOldWord.toString().charAt(0));
                        sbNewWord.append(sbOldWord.toString().charAt(1));
                        sbNewWord.append(sbOldWord.toString().charAt(sbOldWord.toString().length()-2));
                        sbNewWord.append(sbOldWord.toString().charAt(sbOldWord.toString().length()-1));

                        line = line.replace(sbOldWord.toString(), sbNewWord.toString());
                    }
                    sbOldWord.setLength(0);
                    sbNewWord.setLength(0);
                }
                bw.write(line + System.lineSeparator());
            }
            bw.write(System.lineSeparator());


        }catch(IOException ex){
        }
    }

    public void changeAllDigitsToString(){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite, true));
            BufferedReader br = new BufferedReader(new FileReader(fileToRead))){

            bw.write("ЗАМЕНА КАЖДОЙ ЦИФРЫ НА СТРОКУ:" + System.lineSeparator());

            String line;
            StringBuilder sb = new StringBuilder();
            while((line = br.readLine()) != null){
                line = line.replace("0", "Zero");
                line = line.replace("1", "One");
                line = line.replace("2", "Two");
                line = line.replace("3", "Three");
                line = line.replace("4", "Four");
                line = line.replace("5", "Five");
                line = line.replace("6", "Six");
                line = line.replace("7", "Seven");
                line = line.replace("8", "Eight");
                line = line.replace("9", "Nine");

                sb.append(line).append(System.lineSeparator());
            }
            bw.write(sb.toString() + System.lineSeparator());

        }catch (IOException ex){
        }
    }

    public void countTheNumberOfOccurrencesOfEachWord(){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite, true));
            BufferedReader br = new BufferedReader(new FileReader(fileToRead))){

            bw.write("ПОДСЧЁТ КОЛИЧЕСТВА ВХОЖДЕНИЙ КАЖДОГО ОТДЕЛЬНОГО СЛОВА" + System.lineSeparator());

            String line;
            StringBuilder sb = new StringBuilder();

            Map<String, Integer> countOfOccurence = new HashMap<>();

            while((line = br.readLine()) != null){
                String[] wordsWithSymbols = line.split(" ");

                for (String wordsWithSymbol : wordsWithSymbols) {
                    for (int j = 0; j < wordsWithSymbol.length(); j++) {
                        if (Character.isLetter(wordsWithSymbol.charAt(j))) {
                            sb.append(wordsWithSymbol.charAt(j));
                        }
                    }

                    if(sb.length() != 0){
                        if (!countOfOccurence.containsKey(sb.toString())) {
                            countOfOccurence.put(sb.toString(), 1);
                        } else {
                            countOfOccurence.put(sb.toString(), countOfOccurence.get(sb.toString())+1);
                        }

                        sb.setLength(0);
                    }
                }
            }

            for (Map.Entry<String, Integer> entry : countOfOccurence.entrySet()) {
                sb.append(entry.getKey()).append(" = ").append(entry.getValue()).append(System.lineSeparator());
            }

            bw.write(sb.toString());

        }catch(IOException ex){
        }
    }

    public void clearFile(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite))){
            bw.write("");
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
