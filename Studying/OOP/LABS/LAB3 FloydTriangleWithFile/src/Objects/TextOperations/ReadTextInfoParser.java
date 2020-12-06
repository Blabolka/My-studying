package Objects.TextOperations;

import org.apache.commons.lang3.StringUtils;

public class ReadTextInfoParser {

    private String readText;

    public ReadTextInfoParser(String readText){
        this.readText = readText;
    }

    public Integer getNumberOfLinesInFloydTriangle(){
        String[] linesOfReadText = StringUtils.split(readText, System.lineSeparator());
        String[] splitLastPartOfFirstLine = StringUtils.split(linesOfReadText[0], ":");
        String numberInStringForm = StringUtils.remove(splitLastPartOfFirstLine[splitLastPartOfFirstLine.length-1], "lines.");
        numberInStringForm = StringUtils.remove(numberInStringForm, " ");
        return numberFromWord(numberInStringForm);
    }

    public String getOrderOfPrintFloydTriangle(){
        String[] linesOfReadText = StringUtils.split(readText, System.lineSeparator());
        String[] splitOrderOfPrint = StringUtils.split(linesOfReadText[1], " .");
        return splitOrderOfPrint[splitOrderOfPrint.length-1];
    }

    private Integer numberFromWord(String word){
        String[] words = {"two", "three" , "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
        "nineteen", "twenty", "twentyone", "twentytwo", "twentythree", "twentyfour", "twentyfive",
        "twentysix", "twentyseven", "twentyeight", "twentynine", "thirty"};

        for (int i = 0; i < words.length; i++) {
            if(word.equalsIgnoreCase(words[i])){
                return i+2;
            }
        }
        throw new RuntimeException();
    }
}
