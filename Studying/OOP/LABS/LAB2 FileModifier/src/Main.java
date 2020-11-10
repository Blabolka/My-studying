import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) {
        FileModifier fileModifier1 = new FileModifier("src\\InputFiles\\Digital values.txt", "src\\OutputFiles\\Modified Digit Values.txt");
        fileModifier1.copyAllText();
        fileModifier1.splitBySeparator(".");
        fileModifier1.splitIntoWords();
        fileModifier1.countTheNumberOfWords();
        fileModifier1.countTheNumberOfCharacters();
        fileModifier1.capitalizeEveryWord();
        fileModifier1.toUpperCaseEverySecondWord();
        fileModifier1.createNewWordsFromTwoFirstAndLastLettersEveryWord();
        fileModifier1.changeAllDigitsToEquivalentStrings();
        fileModifier1.countNumberOfOccurrencesEveryWord();
        fileModifier1.writeToFile();

        System.out.println(StringUtils.getLevenshteinDistance("Andrew 55","Andrew"));

        FileModifier fileModifier2 = new FileModifier("src\\InputFiles\\Flyby missions.txt", "src\\OutputFiles\\Modified Flyby missions.txt");
        fileModifier2.copyAllText();
        fileModifier2.splitIntoWords();
        fileModifier2.countTheNumberOfWords();
        fileModifier2.countTheNumberOfCharacters();
        fileModifier2.formatNumbers();
        fileModifier2.formatDates();
        fileModifier2.writeToFile();
    }
}
