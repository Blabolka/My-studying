import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;

public class FileModifier {

    private static final String NEXT_LINE = System.lineSeparator();

    FileReader fileReader;
    FileWriter fileWriter;

    StringBuffer allTextFromFileForReading;
    StringBuilder allTextForFileForWriting = new StringBuilder();

    public FileModifier(String filePathToRead, String filePathToWrite){
        fileReader = new FileReader(filePathToRead);
        fileWriter = new FileWriter(filePathToWrite);
        allTextFromFileForReading = new StringBuffer(fileReader.getAllTextFromFile());
    }

    public void copyAllText(){
        addHeaderToFileForWriting("FULLY COPIED TEXT");
        addBodyToFileForWriting(allTextFromFileForReading.toString());
    }

    public void splitBySeparator(String separator){
        addHeaderToFileForWriting("SPLIT STRING BY '"+ separator +"'");

        String[] splitString = StringUtils.split(allTextFromFileForReading.toString(), separator);

        StringBuilder splitStringBuilder = new StringBuilder();
        for (String s : splitString) {
            splitStringBuilder.append(s).append(NEXT_LINE);
        }
        addBodyToFileForWriting(splitStringBuilder.toString());
    }

    public void splitIntoWords(){
        addHeaderToFileForWriting("SPLIT INTO WORDS");

        String[] wordsWithoutSymbols = getAllWordsFromTextWithoutSymbols(allTextFromFileForReading.toString());

        StringBuilder wordsWithoutSymbolsStringBuider = new StringBuilder();
        for (String w : wordsWithoutSymbols) {
            wordsWithoutSymbolsStringBuider.append(w).append(NEXT_LINE);
        }
        addBodyToFileForWriting(wordsWithoutSymbolsStringBuider.toString());
    }

    public void countTheNumberOfWords(){
        addHeaderToFileForWriting("COUNT OF WORDS");
        addBodyToFileForWriting(getAllWordsFromTextWithoutSymbols(allTextFromFileForReading.toString()).length + NEXT_LINE);
    }

    public void countTheNumberOfCharacters(){
        addHeaderToFileForWriting("COUNT OF CHARACTERS");
        addBodyToFileForWriting(allTextFromFileForReading.toString().length() + NEXT_LINE);
    }

    public void capitalizeEveryWord(){
        addHeaderToFileForWriting("CAPITALIZE EVERY WORD");

        String[] wordsWithoutWhitespace = getAllWordsFromTextWithoutWhitespace();

        StringBuilder wordsWithoutWhitespaceStringBuilder = new StringBuilder();
        for (String s : wordsWithoutWhitespace) {
            wordsWithoutWhitespaceStringBuilder.append(StringUtils.capitalize(s)).append(" ");
        }
        addBodyToFileForWriting(wordsWithoutWhitespaceStringBuilder.toString());
    }

    public void toUpperCaseEverySecondWord(){
        addHeaderToFileForWriting("TO UPPER CASE EVERY SECOND WORD");

        String[] wordsWithoutWhitespace = getAllWordsFromTextWithoutWhitespace();

        StringBuilder textWithUpperCase = new StringBuilder();
        for (int i = 1; i <= wordsWithoutWhitespace.length; i++) {
            if(i%2 == 0){
                textWithUpperCase.append(wordsWithoutWhitespace[i-1].toUpperCase()).append(" ");
            }else{
                textWithUpperCase.append(wordsWithoutWhitespace[i-1]).append(" ");
            }
        }
        addBodyToFileForWriting(textWithUpperCase.toString());
    }

    public void createNewWordsFromTwoFirstAndLastLettersEveryWord(){
        addHeaderToFileForWriting("WORDS FROM TWO FIRST AND LAST LETTERS EVERY WORD");

        String[] wordsWithoutWhitespace = getAllWordsFromTextWithoutWhitespace();

        StringBuilder newWords = new StringBuilder();
        for (int i = 0; i < wordsWithoutWhitespace.length; i++) {
            String word = getStringWithoutSymbols(wordsWithoutWhitespace[i]);
            if(word.length() > 4){
                String newWord = word.substring(0,2) + word.substring(word.length()-2);
                wordsWithoutWhitespace[i] = StringUtils.replace(wordsWithoutWhitespace[i], word, newWord);
            }
            newWords.append(wordsWithoutWhitespace[i]).append(" ");
        }
        addBodyToFileForWriting(newWords.toString());
    }

    public void writeToFile(){
        fileWriter.writeTextToFile(allTextForFileForWriting.toString());
    }

    private String[] getAllWordsFromTextWithoutSymbols(String text){
        StringBuilder separator = new StringBuilder();
        for (int i = 0; i < text.length() ; i++) {
            if(!CharUtils.isAsciiAlpha(text.charAt(i)) && !CharUtils.isAsciiNumeric(allTextFromFileForReading.toString().charAt(i))){
                if(!separator.toString().contains(String.valueOf(text.charAt(i)))){
                    separator.append(text.charAt(i));
                }
            }
        }
        return StringUtils.split(text, separator.toString());
    }

    private String[] getAllWordsFromTextWithoutWhitespace(){
        return StringUtils.split(allTextFromFileForReading.toString(), " \t");
    }

    private String getStringWithoutSymbols(String string){
        StringBuilder newWord = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if(Character.isLetter(string.charAt(i))){
                newWord.append(string.charAt(i));
            }
        }
        return newWord.toString();
    }

    private void addHeaderToFileForWriting(String header){
        allTextForFileForWriting.append(header).append(NEXT_LINE);
    }

    private void addBodyToFileForWriting(String body){
        allTextForFileForWriting.append(body).append(NEXT_LINE);
    }
}
