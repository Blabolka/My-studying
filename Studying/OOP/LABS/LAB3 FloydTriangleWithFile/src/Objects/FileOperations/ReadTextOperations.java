package Objects.FileOperations;

public class ReadTextOperations {

    private String readText;

    public ReadTextOperations(String readText){
        this.readText = readText;
    }

    

    private Integer numberFromWord(String word){
        String[] words = {"zero", "one", "two", "three" , "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
        "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five",
        "twenty six", "twenty seven", "twenty eight", "twenty nine", "thirty"};

        for (int i = 0; i < words.length; i++) {
            if(word.equalsIgnoreCase(words[i])){
                return i;
            }
        }
        return -1;
    }
}
