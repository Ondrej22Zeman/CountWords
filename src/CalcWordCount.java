import java.util.ArrayList;
import java.util.Objects;

public class CalcWordCount {

    private ArrayList<Word> uniqueWords = new ArrayList<>();

    public ArrayList<Word> calc(String input) {
        input = input.toLowerCase();

        StringBuilder foundWord = new StringBuilder();
        char charToAppend;

        for (int i = 0; i < input.length(); i++) {
            boolean contains = false;
            charToAppend = input.charAt(i);
            if (charToAppend == ' ' || i == input.length()-1) {
                if (i == input.length()-1) foundWord.append(charToAppend);
                for (Word w : uniqueWords) {
                    if (Objects.equals(w.getName(), foundWord.toString())) {
                        w.addCount();
                        foundWord.setLength(0);
                        contains = true;
                        break;
                    }
                }

                if (!contains) {
                    Word word = new Word(foundWord.toString());
                    uniqueWords.add(word);
                    foundWord.setLength(0);
                }
            }else{
                if (    !( charToAppend == '.'
                        || charToAppend == ','
                        || charToAppend == '"'
                        || charToAppend == '!'
                        || charToAppend == ':'
                        || charToAppend == '*'
                        || charToAppend == '–')){
                    foundWord.append(charToAppend);
                }
            }
        }

        return uniqueWords;
    }
}
