package week9;

public class HiddenWord {

    private String hint;

    public HiddenWord(String hint) {
        this.hint = hint;
    }

    public String getHint(String guess) {
        String newHint = "";
        for (int i = 0; i < hint.length(); i++) {
            String letter = guess.substring(i, i + 1);
            String hintLetter = hint.substring(i, i + 1);

            if (hintLetter.equals(letter)) {
                newHint += letter;
            } else if (hint.indexOf(letter) >= 0) {
                newHint += "+";
            } else {
                newHint += "*";
            }
        }
        return newHint;
    } 
}
