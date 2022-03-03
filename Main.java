import java.util.Scanner;
import java.util.ArrayList;

public class Main {


  
  public static void main(String[] args) {

    //scanner init
    Scanner sc = new Scanner(System.in);
    
    //array list: temp
    ArrayList<String> nothing = new ArrayList<String>();
    nothing.add("thing");

    //init obj + results
    ArrayList<String> results = new ArrayList<String>();
    Wordle test = new Wordle(nothing);
    int i;


    //actual game starting
    System.out.println("enter your guess (only enter five vaild letters: a-z no caps)");
    for(i = 0; i < 6; i++) {
      
      String myLine = sc.nextLine();

      results.add(test.guess(myLine, i));
      System.out.println(results.get(i));
      if(results.get(i).equals("✓✓✓✓✓")) {
        i = 10;
      }
        
    }

    //hola



    //end aka results
    if(i == 10)
      System.out.println("good job, you got the word");
    else
      System.out.println("oh no, you lost. the word was " + nothing.getWord());
    
  }
}