import FileReader.FileReader;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FileOperations {

    private final FileReader fileReader;
    private final String readText;

    public FileOperations(String filePathToRead){
        fileReader = new FileReader(filePathToRead);
        readText = fileReader.readTextFromFile();
    }

    public String getAllText(){
        return readText;
    }

    public String[] getTextSplitBySeparator(String separator){
        return StringUtils.split(readText, separator);
    }

    public String[] getAllWords(){
        return getAllWordsFromTextWithoutSymbols(readText);
    }

    public int getTheNumberOfWords(){
        return getAllWordsFromTextWithoutWhitespace().length;
    }

    public int getTheNumberOfCharacters(){
        return readText.length();
    }

    public String[] getCapitalizedEveryWord(){
        String[] wordsWithoutWhitespace = getAllWordsFromTextWithoutWhitespace();

        for (int i=0 ; i<wordsWithoutWhitespace.length ; i++) {
            wordsWithoutWhitespace[i] = StringUtils.capitalize(wordsWithoutWhitespace[i]);
        }
        return wordsWithoutWhitespace;
    }

    public String[] getUpperCasedEverySecondWord(){
        String[] wordsWithoutWhitespace = getAllWordsFromTextWithoutWhitespace();

        for (int i = 1; i <= wordsWithoutWhitespace.length; i++) {
            if(i%2 == 0){
                wordsWithoutWhitespace[i-1] = wordsWithoutWhitespace[i-1].toUpperCase();
            }else{
                wordsWithoutWhitespace[i-1] = wordsWithoutWhitespace[i-1];
            }
        }
        return wordsWithoutWhitespace;
    }

    public String[] getNewWordsFromTwoFirstAndLastLettersEveryWord(){
        String[] wordsWithoutWhitespace = getAllWordsFromTextWithoutWhitespace();

        for (int i = 0; i < wordsWithoutWhitespace.length; i++) {
            String word = getStringWithoutSymbols(wordsWithoutWhitespace[i]);
            if(word.length() > 4){
                String newWord = word.substring(0,2) + word.substring(word.length()-2);
                wordsWithoutWhitespace[i] = StringUtils.replace(wordsWithoutWhitespace[i], word, newWord);
            }
        }
        return wordsWithoutWhitespace;
    }

    public String getTextWhereAllDigitsChangedToEquivalentStrings(){
        String allText = readText;
        for (int i = 0; i <= 9; i++) {
            allText = StringUtils.replace(allText, String.valueOf(i), getDigitInStringForm(i));
        }
        return allText;
    }

    public String getOccurrencesOfEveryWord(){
        Map<String, Integer> occurrences = new HashMap<>();
        String[] allWordsWithoutSymbols = getAllWordsFromTextWithoutSymbols(readText);
        for (String s : allWordsWithoutSymbols) {
            if(!occurrences.containsKey(s)){
                occurrences.put(s,getOccurrenceOfWord(allWordsWithoutSymbols,s));
            }
        }
        return occurrences.entrySet().toString();
    }

    public String getFormattedNumbers(){
        String[] words = getAllWordsFromTextWithoutWhitespace();
        for (int i = 0; i < words.length; i++) {
            if(NumberUtils.isDigits(words[i])){
                words[i] = getFormattedString(Integer.parseInt(words[i]));
            }
        }
        return Arrays.toString(words);
    }

    public String getFormattedDates(){
        String[] allWords = getAllWordsFromTextBySeparator("\t");
        for (int i = 0 ; i<allWords.length ; i++) {
            try{
                LocalDate date = LocalDate.parse(allWords[i], DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.US));
                allWords[i] = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            }catch (Exception ignored){}
        }
        return Arrays.toString(allWords);
    }

    public void getConcatenatedSimilarStrings(){

    }

    private String[] getAllWordsFromTextWithoutWhitespace(){
        return StringUtils.split(readText, " \t");
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
        String[] numbersInTextForm = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
        return numbersInTextForm[number];
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

    private String getFormattedString(int number){
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        DecimalFormat decimalFormat = (DecimalFormat)numberFormat;
        decimalFormat.applyPattern("###,###");
        return decimalFormat.format(number);
    }

    private String[] getAllWordsFromTextBySeparator(String separator){
        return StringUtils.split(readText.toString(), separator);
    }
}
