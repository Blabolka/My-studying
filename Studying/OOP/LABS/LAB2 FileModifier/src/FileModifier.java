import FileWriter.FileWriter;
public class FileModifier {

    private static final String NEXT_LINE = System.lineSeparator();

    private final FileWriter fileWriter;

    private int indexOfModification = 0;

    private final StringBuilder header = new StringBuilder();
    private final StringBuilder body = new StringBuilder();

    public FileModifier(String filePathToWrite){
        fileWriter = new FileWriter(filePathToWrite);
    }

    public void addModification(String description, String modification){
        indexOfModification++;
        addHeaderToFileForWriting(indexOfModification +". "+ description);
        addBodyToFileForWriting(indexOfModification +". "+ modification);
    }

    private void addHeaderToFileForWriting(String header){
        this.header.append(header).append(NEXT_LINE);
    }

    private void addBodyToFileForWriting(String body){
        this.body.append(body).append(NEXT_LINE);
    }

    public void writeToFile(){
        fileWriter.writeTextToFile(header.toString() +NEXT_LINE+ body.toString());
    }
}
