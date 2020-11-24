import FileReader.FileReader;
import FileWriter.FileWriter;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        FileReader fileReader1 = new FileReader("src\\InputFiles\\Digital values.txt");
        StringOperations stringOperations1 = new StringOperations(fileReader1.readTextFromFile());

        StringModifier stringModifier1 = new StringModifier();
        stringModifier1.addModification("FULLY COPIED TEXT", stringOperations1.getAllText());
        stringModifier1.addModification("SPLIT STRING BY '.'", Arrays.toString(stringOperations1.getTextSplitBySeparator(".")));
        stringModifier1.addModification("SPLIT INTO WORDS", Arrays.toString(stringOperations1.getAllWords()));
        stringModifier1.addModification("NUMBER OF WORDS", String.valueOf(stringOperations1.getTheNumberOfWords()));
        stringModifier1.addModification("NUMBER OF CHARACTERS", String.valueOf(stringOperations1.getTheNumberOfCharacters()));
        stringModifier1.addModification("CAPITALIZE EVERY WORD", Arrays.toString(stringOperations1.getCapitalizedEveryWord()));
        stringModifier1.addModification("TO UPPER CASE EVERY SECOND WORD", Arrays.toString(stringOperations1.getUpperCasedEverySecondWord()));
        stringModifier1.addModification("WORDS FROM TWO FIRST AND LAST LETTERS EVERY WORD", Arrays.toString(stringOperations1.getNewWordsFromTwoFirstAndLastLettersEveryWord()));
        stringModifier1.addModification("TEXT WITH DIGITS IN EQUIVALENT STRINGS", stringOperations1.getTextWhereAllDigitsChangedToEquivalentStrings());
        stringModifier1.addModification("NUMBER OF OCCURRENCES EVERY WORD", stringOperations1.getOccurrencesOfEveryWord());

        FileWriter fileWriter1 = new FileWriter("src\\OutputFiles\\Modified Digit Values.txt");
        fileWriter1.writeTextToFile(stringModifier1.getFormattedHeaderAndBody());


        FileReader fileReader2 = new FileReader("src\\InputFiles\\Flyby missions.txt");
        StringOperations stringOperations2 = new StringOperations(fileReader2.readTextFromFile());

        StringModifier stringModifier2 = new StringModifier();
        stringModifier2.addModification("FULLY COPIED TEXT", stringOperations2.getAllText());
        stringModifier2.addModification("SPLIT INTO WORDS", Arrays.toString(stringOperations2.getAllWords()));
        stringModifier2.addModification("NUMBER OF WORDS", String.valueOf(stringOperations2.getTheNumberOfWords()));
        stringModifier2.addModification("NUMBER OF CHARACTERS", String.valueOf(stringOperations2.getTheNumberOfCharacters()));
        stringModifier2.addModification("FORMATTED NUMBERS BY PATTERN #,###", stringOperations2.getFormattedNumbers());
        stringModifier2.addModification("FORMATTED DATES OF PATTERN dd.MM.yyyy", stringOperations2.getFormattedDates());
        stringModifier2.addModification("CONCATENATED SIMILAR STRINGS", stringOperations2.getConcatenatedSimilarStrings());

        FileWriter fileWriter2 = new FileWriter("src\\OutputFiles\\Modified Flyby missions.txt");
        fileWriter2.writeTextToFile(stringModifier2.getFormattedHeaderAndBody());
    }
}
