import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class StringOperations {

    private final String text;

    public StringOperations(String text){
        this.text = text;
    }

    public String copyAllText(){
        return text;
    }

    public String[] splitTextBySeparator(String separator){
        return StringUtils.split(text, separator);
    }

    public String[] copyAllWords(){
        return getAllWordsFromTextWithoutSymbols(text);
    }

    public int countNumberOfWords(){
        return getAllWordsFromTextWithoutWhitespace().length;
    }

    public int countNumberOfCharacters(){
        return text.length();
    }

    public String[] capitalizeEveryWord(){
        String[] wordsWithoutWhitespace = getAllWordsFromTextWithoutWhitespace();

        for (int i=0 ; i<wordsWithoutWhitespace.length ; i++) {
            wordsWithoutWhitespace[i] = StringUtils.capitalize(wordsWithoutWhitespace[i]);
        }
        return wordsWithoutWhitespace;
    }

    public String[] upperCaseEverySecondWord(){
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

    public String[] createNewWordsFromTwoFirstAndLastLettersEveryWord(){
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

    public String changeAllDigitsToEquivalentStrings(){
        String allText = text;
        for (int i = 0; i <= 9; i++) {
            allText = StringUtils.replace(allText, String.valueOf(i), getDigitInStringForm(i));
        }
        return allText;
    }

    public String occurrencesOfEveryWord(){
        Map<String, Integer> occurrences = new HashMap<>();
        String[] allWordsWithoutSymbols = getAllWordsFromTextWithoutSymbols(text);
        for (String s : allWordsWithoutSymbols) {
            if(!occurrences.containsKey(s)){
                occurrences.put(s,getOccurrenceOfWord(allWordsWithoutSymbols,s));
            }
        }
        return occurrences.entrySet().toString();
    }

    public String formatNumbers(){
        String[] words = getAllWordsFromTextWithoutWhitespace();
        for (int i = 0; i < words.length; i++) {
            if(NumberUtils.isDigits(words[i])){
                words[i] = getFormattedString(Integer.parseInt(words[i]));
            }
        }
        return Arrays.toString(words);
    }

    public String formatDates(){
        String[] allWords = getAllWordsFromTextBySeparator("\t");
        for (int i = 0 ; i<allWords.length ; i++) {
            try{
                LocalDate date = LocalDate.parse(allWords[i], DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.US));
                allWords[i] = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            }catch (Exception ignored){}
        }
        return Arrays.toString(allWords);
    }

    public String concatenateSimilarStrings(){
        String[] rows = getAllWordsFromTextBySeparator(System.lineSeparator());
        List<String> titles = new ArrayList<>();

        for (int i = 2; i < rows.length; i++) {
            titles.add(StringUtils.split(rows[i], "\t")[0]);
            titles.set(i-2, StringUtils.replace(titles.get(i-2), " ", ""));
        }

        List<String> concatenatedTitles = new ArrayList<>();

        while(titles.size() > 0){
            String string = titles.remove(0);
            StringBuilder concatenatedBuffer = new StringBuilder(string);
            for (int i = 0; i < titles.size(); i++) {
                if(getStringWithoutNumbers(string).equals(getStringWithoutNumbers(titles.get(i)))){
                    concatenatedBuffer.append("AND").append(titles.get(i));
                    titles.remove(i);
                    i--;
                }
            }
            concatenatedTitles.add(concatenatedBuffer.toString());
        }

        return concatenatedTitles.toString();
    }

    private String[] getAllWordsFromTextWithoutWhitespace(){
        return StringUtils.split(text, " \t");
    }

    private String[] getAllWordsFromTextWithoutSymbols(String text){
        StringBuilder separator = new StringBuilder();
        for (int i = 0; i < text.length() ; i++) {
            if(!CharUtils.isAsciiAlpha(text.charAt(i)) && !CharUtils.isAsciiNumeric(text.charAt(i))){
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
        return StringUtils.split(text.toString(), separator);
    }

    private String getStringWithoutNumbers(String string){
        StringBuilder stringWithoutNumbers = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if(!Character.isDigit(string.charAt(i))){
                stringWithoutNumbers.append(string.charAt(i));
            }
        }
        return stringWithoutNumbers.toString();
    }
}
