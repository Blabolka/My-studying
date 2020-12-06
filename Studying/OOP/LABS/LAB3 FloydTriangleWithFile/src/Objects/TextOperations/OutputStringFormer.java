package Objects.TextOperations;

public class OutputStringFormer {

    private static final String NEXT_LINE = System.lineSeparator();

    private final StringBuilder header = new StringBuilder();
    private final StringBuilder body = new StringBuilder();
    private final StringBuilder footer = new StringBuilder();

    public void addModification(String header, String body, String footer){
        addHeader(header);
        addBody(body);
        addFooter(footer);
    }

    public String getHeader(){
        return header.toString();
    }

    public String getBody(){
        return body.toString();
    }

    public String getFooter(){
        return footer.toString();
    }

    public String getFormedModifications(){
        return header.toString() + body.toString() + footer.toString();
    }

    private void addHeader(String header){
        this.header.append(header).append(NEXT_LINE);
    }

    private void addBody(String body){
        this.body.append(body);
    }

    private void addFooter(String footer){
        this.footer.append(footer).append(NEXT_LINE);
    }
}
