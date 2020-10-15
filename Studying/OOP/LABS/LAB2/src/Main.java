public class Main {

    public static void main(String[] args){

        ModifyFile modifyFile1 = new ModifyFile("Digital values.txt", "Modified Digit Values.txt");

        modifyFile1.clearFile();
        modifyFile1.copyContent();
        modifyFile1.splitStringIntoSentences();
        modifyFile1.splitStringIntoWords();
        modifyFile1.countNumberOfWords();
        modifyFile1.countNumberOfSymbols();
        modifyFile1.changeFirstSybolOfEveryWordToUppercase();

        ModifyFile modifyFile2 = new ModifyFile("Flyby missions.txt", "Modified Flyby missions.txt");
        modifyFile2.clearFile();
        modifyFile2.copyContent();
        modifyFile2.splitStringIntoWords();
        modifyFile2.countNumberOfSymbols();
    }
}
