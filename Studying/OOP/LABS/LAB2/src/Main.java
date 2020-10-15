public class Main {

    public static void main(String[] args){

        ModifyFile modifyFile = new ModifyFile("Digital values.txt", "Modified Digit Values.txt");

        modifyFile.clearFile();
        modifyFile.splitStringIntoSentences();
        modifyFile.splitStringIntoWords();
    }
}
