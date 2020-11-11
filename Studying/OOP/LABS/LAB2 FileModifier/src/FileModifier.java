import FileReader.FileReader;
import FileWriter.FileWriter;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FileModifier {

    private static final String NEXT_LINE = System.lineSeparator();

    private final FileReader fileReader;
    private final FileWriter fileWriter;

    private final StringBuffer readText;
    private final StringBuilder textToWrite = new StringBuilder();

    public FileModifier(String filePathToRead, String filePathToWrite){
        fileReader = new FileReader(filePathToRead);
        fileWriter = new FileWriter(filePathToWrite);
        readText = new StringBuffer(fileReader.readTextFromFile());
    }

    public void copyAllText(){
        addHeaderToFileForWriting("FULLY COPIED TEXT");
        addBodyToFileForWriting(readText.toString());
    }

    public void splitBySeparator(String separator){
        addHeaderToFileForWriting("SPLIT STRING BY '"+ separator +"'");

        String[] splitString = StringUtils.split(readText.toString(), separator);

        StringBuilder splitStringBuilder = new StringBuilder();
        for (String s : splitString) {
            splitStringBuilder.append(s).append(NEXT_LINE);
        }
        addBodyToFileForWriting(splitStringBuilder.toString());
    }

    public void splitIntoWords(){
        addHeaderToFileForWriting("SPLIT INTO WORDS");

        String[] wordsWithoutSymbols = getAllWordsFromTextWithoutSymbols(readText.toString());

        StringBuilder wordsWithoutSymbolsStringBuilder = new StringBuilder();
        for (String w : wordsWithoutSymbols) {
            wordsWithoutSymbolsStringBuilder.append(w).append(NEXT_LINE);
        }
        addBodyToFileForWriting(wordsWithoutSymbolsStringBuilder.toString());
    }

    public void countTheNumberOfWords(){
        addHeaderToFileForWriting("COUNT OF WORDS");
        addBodyToFileForWriting(getAllWordsFromTextWithoutSymbols(readText.toString()).length + NEXT_LINE);
    }

    public void countTheNumberOfCharacters(){
        addHeaderToFileForWriting("COUNT OF CHARACTERS");
        addBodyToFileForWriting(readText.toString().length() + NEXT_LINE);
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

    public void changeAllDigitsToEquivalentStrings(){
        addHeaderToFileForWriting("TEXT WITH DIGITS IN EQUIVALENT STRINGS");
        String allText = readText.toString();
        for (int i = 0; i <= 9; i++) {
            allText = StringUtils.replace(allText, String.valueOf(i), getDigitInStringForm(i));
        }
        addBodyToFileForWriting(allText + NEXT_LINE);
    }

    public void countNumberOfOccurrencesEveryWord(){
        addHeaderToFileForWriting("NUMBER OF OCCURRENCES EVERY WORD");
        Map<String, Integer> occurrences = new HashMap<>();
        String[] allWordsWithoutSymbols = getAllWordsFromTextWithoutSymbols(readText.toString());
        for (String s : allWordsWithoutSymbols) {
            if(!occurrences.containsKey(s)){
                occurrences.put(s,getOccurrenceOfWord(allWordsWithoutSymbols,s));
            }
        }
        addBodyToFileForWriting(occurrences.entrySet() + NEXT_LINE);
    }

    public void formatNumbers(){
        addHeaderToFileForWriting("FORMATTED NUMBERS BY PATTERN #,###");

        String[] words = getAllWordsFromTextWithoutWhitespace();
        for (int i = 0; i < words.length; i++) {
            if(NumberUtils.isDigits(words[i])){
                words[i] = getFormattedString(Integer.parseInt(words[i]));
            }
        }
        addBodyToFileForWriting(Arrays.toString(words));
    }

    public void formatDates(){
        addHeaderToFileForWriting("FORMATTED DATES OF PATTERN dd.MM.yyyy");

        String[] allWords = getAllWordsFromTextBySeparator("\t");

        for (int i = 0 ; i<allWords.length ; i++) {
            try{
                LocalDate date = LocalDate.parse(allWords[i], DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.US));
                allWords[i] = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            }catch (Exception ignored){}
        }
        addBodyToFileForWriting(Arrays.toString(allWords));
    }

    public void writeToFile(){
        fileWriter.writeTextToFile(textToWrite.toString());
    }

    private String[] getAllWordsFromTextWithoutSymbols(String text){
        StringBuilder separator = new StringBuilder();
        for (int i = 0; i < text.length() ; i++) {
            if(!CharUtils.isAsciiAlpha(text.charAt(i)) && !CharUtils.isAsciiNumeric(readText.toString().charAt(i))){
                if(!separator.toString().contains(String.valueOf(text.charAt(i)))){
                    separator.append(text.charAt(i));
                }
            }
        }
        return StringUtils.split(text, separator.toString());
    }

    private String[] getAllWordsFromTextWithoutWhitespace(){
        return StringUtils.split(readText.toString(), " \t");
    }

    private String[] getAllWordsFromTextBySeparator(String separator){
        return StringUtils.split(readText.toString(), separator);
    }

    private Integer getOccurrenceOfWord(String[] text, String word){
        Integer occurrence = 0;
        for (String s: text) {
            if(word.equals(s)){
                occurrence++;
            }
        }
        return occurrence;
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

    private String getDigitInStringForm(int number){
        String stringForm = "";
        switch (number){
            case 0: stringForm = "ZERO"; break;
            case 1: stringForm = "ONE"; break;
            case 2: stringForm = "TWO"; break;
            case 3: stringForm = "THREE"; break;
            case 4: stringForm = "FOUR"; break;
            case 5: stringForm = "FIVE"; break;
            case 6: stringForm = "SIX"; break;
            case 7: stringForm = "SEVEN"; break;
            case 8: stringForm = "EIGHT"; break;
            case 9: stringForm = "NINE"; break;
        }
        return stringForm;
    }

    private String getFormattedString(int number){
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        DecimalFormat decimalFormat = (DecimalFormat)numberFormat;
        decimalFormat.applyPattern("###,###");
        return decimalFormat.format(number);
    }

    private void addHeaderToFileForWriting(String header){
        textToWrite.append(header).append(NEXT_LINE);
    }

    private void addBodyToFileForWriting(String body){
        textToWrite.append(body).append(NEXT_LINE);
    }
}
