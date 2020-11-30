import FileReader.FileReader;
import FileWriter.FileWriter;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        FileReader fileReader1 = new FileReader("src\\InputFiles\\Digital values.txt");
        StringOperations stringOperations1 = new StringOperations(fileReader1.readTextFromFile());

        StringModifier stringModifier1 = new StringModifier();
        stringModifier1.addModification("FULLY COPIED TEXT", stringOperations1.copyAllText());
        stringModifier1.addModification("SPLIT STRING BY '.'", Arrays.toString(stringOperations1.splitTextBySeparator(".")));
        stringModifier1.addModification("SPLIT INTO WORDS", Arrays.toString(stringOperations1.copyAllWords()));
        stringModifier1.addModification("NUMBER OF WORDS", String.valueOf(stringOperations1.countNumberOfWords()));
        stringModifier1.addModification("NUMBER OF CHARACTERS", String.valueOf(stringOperations1.countNumberOfCharacters()));
        stringModifier1.addModification("CAPITALIZE EVERY WORD", Arrays.toString(stringOperations1.capitalizeEveryWord()));
        stringModifier1.addModification("TO UPPER CASE EVERY SECOND WORD", Arrays.toString(stringOperations1.upperCaseEverySecondWord()));
        stringModifier1.addModification("WORDS FROM TWO FIRST AND LAST LETTERS EVERY WORD", Arrays.toString(stringOperations1.createNewWordsFromTwoFirstAndLastLettersEveryWord()));
        stringModifier1.addModification("TEXT WITH DIGITS IN EQUIVALENT STRINGS", stringOperations1.changeAllDigitsToEquivalentStrings());
        stringModifier1.addModification("NUMBER OF OCCURRENCES EVERY WORD", stringOperations1.occurrencesOfEveryWord());

        FileWriter fileWriter1 = new FileWriter("src\\OutputFiles\\Modified Digit Values.txt");
        fileWriter1.writeTextToFile(stringModifier1.getFormattedHeaderAndBody());


        FileReader fileReader2 = new FileReader("src\\InputFiles\\Flyby missions.txt");
        StringOperations stringOperations2 = new StringOperations(fileReader2.readTextFromFile());

        StringModifier stringModifier2 = new StringModifier();
        stringModifier2.addModification("FULLY COPIED TEXT", stringOperations2.copyAllText());
        stringModifier2.addModification("SPLIT INTO WORDS", Arrays.toString(stringOperations2.copyAllWords()));
        stringModifier2.addModification("NUMBER OF WORDS", String.valueOf(stringOperations2.countNumberOfWords()));
        stringModifier2.addModification("NUMBER OF CHARACTERS", String.valueOf(stringOperations2.countNumberOfCharacters()));
        stringModifier2.addModification("FORMATTED NUMBERS BY PATTERN #,###", stringOperations2.formatNumbers());
        stringModifier2.addModification("FORMATTED DATES OF PATTERN dd.MM.yyyy", stringOperations2.formatDates());
        stringModifier2.addModification("CONCATENATED SIMILAR STRINGS", stringOperations2.concatenateSimilarStrings());

        FileWriter fileWriter2 = new FileWriter("src\\OutputFiles\\Modified Flyby missions.txt");
        fileWriter2.writeTextToFile(stringModifier2.getFormattedHeaderAndBody());
    }
}
