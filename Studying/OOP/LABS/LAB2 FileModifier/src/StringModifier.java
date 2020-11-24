import FileWriter.FileWriter;
public class StringModifier {

    private static final String NEXT_LINE = System.lineSeparator();

    private int indexOfModification = 0;

    private final StringBuilder header = new StringBuilder();
    private final StringBuilder body = new StringBuilder();

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

    public String getHeader(){
        return header.toString();
    }

    public String getBody(){
        return body.toString();
    }

    public String getFormattedHeaderAndBody(){
        return header.toString() +NEXT_LINE+ body.toString();
    }
}
