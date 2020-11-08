import org.apache.commons.lang3.StringUtils;

public class FileModifier {

    public static final String NEXT_LINE = System.lineSeparator();

    FileReader fileReader;
    FileWriter fileWriter;

    StringBuffer allTextFromFileForReading;
    StringBuilder allTextForFileForWriting = new StringBuilder();

    public FileModifier(String filePathToRead, String filePathToWrite){
        fileReader = new FileReader(filePathToRead);
        fileWriter = new FileWriter(filePathToWrite);
        allTextFromFileForReading = new StringBuffer(fileReader.getAllTextFromFile());
    }

    public void copyAllText(){
        addHeaderToFileForWriting("FULLY COPIED TEXT");
        addBodyToFileForWriting(allTextFromFileForReading.toString());
    }

    public void splitBySeparator(String separator){
        addHeaderToFileForWriting("SPLIT STRING BY '"+ separator +"'");

        String[] splitString = StringUtils.split(allTextFromFileForReading.toString(), separator);

        StringBuilder splitStringBuilder = new StringBuilder();
        for (String s : splitString) {
            s = StringUtils.strip(s);
            splitStringBuilder.append(s).append(NEXT_LINE);
        }
        addBodyToFileForWriting(splitStringBuilder.toString());
    }

    public void splitIntoWords(){
        addHeaderToFileForWriting("SPLIT STRING INTO WORDS");

        String[] allWordsFromText = StringUtils.split(allTextFromFileForReading.toString(), "\t ,.");

        StringBuilder allWordsFromTextBuider = new StringBuilder();
        for (String s : allWordsFromText) {
            allWordsFromTextBuider.append(s).append(NEXT_LINE);
        }
        addBodyToFileForWriting(allWordsFromTextBuider.toString());
    }

    public void countAllWords(){
        addHeaderToFileForWriting("NUMBER OF WORDS");
        addBodyToFileForWriting(getAllWordsFromFile().length + NEXT_LINE);
    }

    public void writeToFile(){
        fileWriter.writeTextToFile(allTextForFileForWriting.toString());
    }

    private String[] getAllWordsFromFile(){
        return StringUtils.split(allTextFromFileForReading.toString(), "\t ,.");
    }

    private void addHeaderToFileForWriting(String header){
        allTextForFileForWriting.append(header).append(NEXT_LINE);
    }

    private void addBodyToFileForWriting(String body){
        allTextForFileForWriting.append(body).append(NEXT_LINE);
    }
}
