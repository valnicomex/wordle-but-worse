import java.util.ArrayList;

public class Wordle {

  //private instance fields
  private String word;
  private String[] guesses;
  private ArrayList<String> words;
  private String fail = "please enter a valid response";
  private String perfect = ":):):):):)";

  //constructor
  public Wordle(ArrayList<String> words) {
    this.words = words;

    //chooses word 
    word = this.words.get((int) (Math.random() * this.words.size() + 1));
    guesses = new String[6];
  }

  //returns word
  public String getWord() {
    return word;
  }

  //returns response if fails
  public String getFail() {
    return fail;
  }

  //returns response if perfect
  public String getPerfect() {
    return perfect;
  }

  public String guess(String guess, int guessNumber) {
    String result = "";

    try {
      guesses[guessNumber] = guess;

      for (int i = 0; i < 5; i++) {
        if (guess.charAt(i) == (word.charAt(i))) {
          result += ":)";
          
        }

        else {
          boolean check = true;

          for (int f = 0; f < 5; f++) {
            if (guess.charAt(i) == word.charAt(f)) {
              result += "O";
              f = 10;
              check = false;

            }
          }
          if (check) {
            result += "X";

          }
        }
      }
      return result;

    } catch (IndexOutOfBoundsException e) {
      return fail;

    }
  }
}