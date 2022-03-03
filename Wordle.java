import java.util.ArrayList;

public class Wordle {
  private String word;
  private String[] guesses;
  private ArrayList<String> words;

  public Wordle(ArrayList<String> words) {
    this.words = words;
    word = words.get((int) (Math.random() * this.words.size() + 1));
    word = "words";
  }

  public String guess(String guess, int guessNumber) {
    String result = "";
    if(guess.length() != 5)
      return "please enter a five letter word";
    
    for(int i = 0; i < 5; i++) {
      if(guess.charAt(i) == (word.charAt(i))) {
        result += "✓";
      }
        
      else {
        boolean check = true;
        
        for(int f = 0; f < 5; f++) {
          if(guess.charAt(i) == word.charAt(f)) {
            result += "O";
            f = 10;
            check = false;
          }
          
        }
        
        if(check){
          result += "X";
        }
      }
      
    }

    return result;
  }
  
}