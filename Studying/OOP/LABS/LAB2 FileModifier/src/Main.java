public class Main {
    public static void main(String[] args) {
        FileModifier fileModifier1 = new FileModifier("Digital values.txt", "Modified Digit Values.txt");
        fileModifier1.copyAllText();
        fileModifier1.splitBySeparator(".");
        fileModifier1.splitIntoWords();
        fileModifier1.countAllWords();
        fileModifier1.writeToFile();

        FileModifier fileModifier2 = new FileModifier("Flyby missions.txt", "Modified Flyby missions.txt");
        fileModifier2.splitBySeparator("");
        fileModifier2.splitIntoWords();
        fileModifier2.writeToFile();
    }
}
