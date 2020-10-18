public class Main {

    public static void main(String[] args){

        ModifyFile modifyFile1 = new ModifyFile("Digital values.txt", "Modified Digit Values.txt");

        modifyFile1.clearFile();
        modifyFile1.copyContent();
        modifyFile1.splitStringBySeparator(".");
        modifyFile1.splitStringBySeparator(" ");
        modifyFile1.countNumberOfWords();
        modifyFile1.countNumberOfSymbols();
        modifyFile1.changeFirstSymbolOfEveryWordToUppercase();
        modifyFile1.changeEverySecondWordToUpperCase();
        modifyFile1.changeAllDigitsToString();
        modifyFile1.createNewWordsFromOld();
        modifyFile1.countTheNumberOfOccurrencesOfEachWord();

        ModifyFile modifyFile2 = new ModifyFile("Flyby missions.txt", "Modified Flyby missions.txt");
        modifyFile2.clearFile();
        modifyFile2.copyContent();
        modifyFile2.splitStringBySeparator("\t");
        modifyFile2.countNumberOfSymbols();
    }
}
