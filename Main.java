import java.util.Scanner;
import java.util.ArrayList;

public class Main {


  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> nothing = new ArrayList<String>();
    nothing.add("something");
    Wordle test = new Wordle(nothing);
    
    System.out.println("enter your guess");
    String myLine = sc.nextLine();
    
    System.out.println(test.guess(myLine, 0));
    
  }
}