import java.util.Scanner;
import java.util.ArrayList;

public class Main {


  
  public static void main(String[] args) {

    //scanner init
    Scanner sc = new Scanner(System.in);
    
    //array list: temp
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    ArrayList<String> nothing = new ArrayList<String>();
    for(int c = 0; c < 2000; c++) {
      String temp = "";
      for(int j = 0; j < 5; j++)
        temp += alphabet.charAt((int)(Math.random()*26));
      nothing.add(temp);

    }

    //init obj + results
    ArrayList<String> results = new ArrayList<String>();
    Wordle test = new Wordle(nothing);
    int i;


    //actual game starting
    System.out.println("enter your guess (only enter five vaild letters: a-z no caps)");
    for(i = 0; i < 6; i++) {
      //user input
      String myLine = sc.nextLine();

      results.add(test.guess(myLine, i));
      System.out.println(results.get(i));

      if(results.get(i).equals(test.getFail()))
        i--;

      if(results.get(i).equals(test.getPerfect())) {
        i = 10;
        System.out.println("good job, you got the word");
      }
        
    }
    sc.close();
    //end aka results
    if(i != 10)
      System.out.println("oh no, you lost. the word was: " + test.getWord());
    
  }
}