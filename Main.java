import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Main {

  public static void fileToArrayList(FileInputStream fis, ArrayList<String> nothing) {
    Scanner sc = new Scanner(fis);
    while (sc.hasNextLine())
    nothing.add(sc.nextLine());
    sc.close();
  }

  public static void main(String[] args) {

    // array list: temp while import word list
    ArrayList<String> nothing = new ArrayList<String>();
    try{
    Main.fileToArrayList(new FileInputStream("words.txt"), nothing);
    } catch(FileNotFoundException e) {
      nothing.add("fails");
    }

  // init obj + results
  ArrayList<String> results = new ArrayList<String>();
  Wordle test = new Wordle(nothing);
  int i;
  boolean ending = true;

  // temp to test ending easier
  //System.out.println(test.getWord());

  // actual game starting
  System.out.println("enter your guess (only enter five vaild letters: a-z no caps, any extra letters will be disregarded and shorter answers will count)");
    System.out.println(":) = letter in correct spot \nO = letter in word, but not in correct spot \nX = letter is not in word");
  Scanner sc = new Scanner(System.in);
  for(i=0;i<6;i++) {
      // user input
      
      String myLine = sc.nextLine();

      results.add(test.guess(myLine, i));
      System.out.println(results.get(i));

      if (results.get(i).equals(test.getPerfect())) {
        System.out.println("good job, you got the word in " + (i + 1) + " tries");
        i = 10;
        ending = false;
      }

    }
    

  // end aka results
  if(ending)System.out.println("oh no, you lost. the word was: "+test.getWord());
  sc.close();
  }
  
}