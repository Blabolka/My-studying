import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        OperationWithFile operationWithFile1 = new OperationWithFile("src\\InputFiles\\Digital values.txt");
        FileModifier fileModifier1 = new FileModifier("src\\OutputFiles\\Modified Digit Values.txt");

        fileModifier1.addModification("FULLY COPIED TEXT", operationWithFile1.getAllText());
        fileModifier1.addModification("SPLIT STRING BY '.'", Arrays.toString(operationWithFile1.getTextSplitBySeparator(".")));
        fileModifier1.addModification("SPLIT INTO WORDS", Arrays.toString(operationWithFile1.getAllWords()));
        fileModifier1.addModification("NUMBER OF WORDS", String.valueOf(operationWithFile1.getTheNumberOfWords()));
        fileModifier1.addModification("NUMBER OF CHARACTERS", String.valueOf(operationWithFile1.getTheNumberOfCharacters()));
        fileModifier1.addModification("CAPITALIZE EVERY WORD", Arrays.toString(operationWithFile1.getCapitalizedEveryWord()));
        fileModifier1.addModification("TO UPPER CASE EVERY SECOND WORD", Arrays.toString(operationWithFile1.getUpperCasedEverySecondWord()));
        fileModifier1.addModification("WORDS FROM TWO FIRST AND LAST LETTERS EVERY WORD", Arrays.toString(operationWithFile1.getNewWordsFromTwoFirstAndLastLettersEveryWord()));
        fileModifier1.addModification("TEXT WITH DIGITS IN EQUIVALENT STRINGS", operationWithFile1.getTextWhereAllDigitsChangedToEquivalentStrings());
        fileModifier1.addModification("NUMBER OF OCCURRENCES EVERY WORD", operationWithFile1.getNumberOfOccurrencesEveryWord());
        fileModifier1.writeToFile();


        OperationWithFile operationWithFile2 = new OperationWithFile("src\\InputFiles\\Flyby missions.txt");
        FileModifier fileModifier2 = new FileModifier("src\\OutputFiles\\Modified Flyby missions.txt");

        fileModifier2.addModification("FULLY COPIED TEXT", operationWithFile2.getAllText());
        fileModifier2.addModification("SPLIT INTO WORDS", Arrays.toString(operationWithFile2.getAllWords()));
        fileModifier2.addModification("NUMBER OF WORDS", String.valueOf(operationWithFile2.getTheNumberOfWords()));
        fileModifier2.addModification("NUMBER OF CHARACTERS", String.valueOf(operationWithFile2.getTheNumberOfCharacters()));
        fileModifier2.addModification("FORMATTED NUMBERS BY PATTERN #,###", operationWithFile2.getFormattedNumbers());
        fileModifier2.addModification("FORMATTED DATES OF PATTERN dd.MM.yyyy", operationWithFile2.getFormattedDates());
        fileModifier2.writeToFile();
    }
}
