import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FileOperations fileOperations1 = new FileOperations("src\\InputFiles\\Digital values.txt");
        FileModifier fileModifier1 = new FileModifier("src\\OutputFiles\\Modified Digit Values.txt");

        fileModifier1.addModification("FULLY COPIED TEXT", fileOperations1.getAllText());
        fileModifier1.addModification("SPLIT STRING BY '.'", Arrays.toString(fileOperations1.getTextSplitBySeparator(".")));
        fileModifier1.addModification("SPLIT INTO WORDS", Arrays.toString(fileOperations1.getAllWords()));
        fileModifier1.addModification("NUMBER OF WORDS", String.valueOf(fileOperations1.getTheNumberOfWords()));
        fileModifier1.addModification("NUMBER OF CHARACTERS", String.valueOf(fileOperations1.getTheNumberOfCharacters()));
        fileModifier1.addModification("CAPITALIZE EVERY WORD", Arrays.toString(fileOperations1.getCapitalizedEveryWord()));
        fileModifier1.addModification("TO UPPER CASE EVERY SECOND WORD", Arrays.toString(fileOperations1.getUpperCasedEverySecondWord()));
        fileModifier1.addModification("WORDS FROM TWO FIRST AND LAST LETTERS EVERY WORD", Arrays.toString(fileOperations1.getNewWordsFromTwoFirstAndLastLettersEveryWord()));
        fileModifier1.addModification("TEXT WITH DIGITS IN EQUIVALENT STRINGS", fileOperations1.getTextWhereAllDigitsChangedToEquivalentStrings());
        fileModifier1.addModification("NUMBER OF OCCURRENCES EVERY WORD", fileOperations1.getOccurrencesOfEveryWord());
        fileModifier1.writeToFile();


        FileOperations fileOperations2 = new FileOperations("src\\InputFiles\\Flyby missions.txt");
        FileModifier fileModifier2 = new FileModifier("src\\OutputFiles\\Modified Flyby missions.txt");

        fileModifier2.addModification("FULLY COPIED TEXT", fileOperations2.getAllText());
        fileModifier2.addModification("SPLIT INTO WORDS", Arrays.toString(fileOperations2.getAllWords()));
        fileModifier2.addModification("NUMBER OF WORDS", String.valueOf(fileOperations2.getTheNumberOfWords()));
        fileModifier2.addModification("NUMBER OF CHARACTERS", String.valueOf(fileOperations2.getTheNumberOfCharacters()));
        fileModifier2.addModification("FORMATTED NUMBERS BY PATTERN #,###", fileOperations2.getFormattedNumbers());
        fileModifier2.addModification("FORMATTED DATES OF PATTERN dd.MM.yyyy", fileOperations2.getFormattedDates());
        fileModifier2.writeToFile();
    }
}
