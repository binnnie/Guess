import java.util.Random;
import java.util.Scanner;
/**
   Brandon Dixon
   CS145
   Lab 1
   Guess.java
   9/28/2017
   
   A game that has users guess the correct number between 1 and 100 while offering hints 
   periodically. Shows stats about the game played when the program ends.
 */
public class Guess{
   private static int MAX_VALUE = 100;
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      greeter();
      boolean playAgain = true;
      int least = 9999;
      int games = 0;
      int totalGuesses = 0;
      while(playAgain){
         int gameGuesses = playGame();
         if(gameGuesses < least)
            least = gameGuesses;
         games++;
         totalGuesses += gameGuesses;
         System.out.print("Do you want to play again? ");
         String again = in.next();
         if(again.charAt(0) == 'n' || again.charAt(0) == 'N')
            playAgain = false;
      }
      showStats(games, totalGuesses, least);
   }
   
   //Shows a general explanation of the game.
   public static void greeter(){
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println(MAX_VALUE+" and will allow you to guess until");
      System.out.println("you get it. For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
   }
   
   //Starts a game for the user to play. Requests inputs for guesses and provides hints for the 
   //right answer. Returns the total guesses it took for the game to end.
   public static int playGame(){
      Random rand = new Random();
      Scanner in = new Scanner(System.in);
      int target = rand.nextInt(MAX_VALUE)+1;
      System.out.println("I'm thinking of a number between 1 and 100...");
      int guess;
      int total = 0;
      do{
         System.out.print("Your guess? ");
         guess = in.nextInt();
         total++;
         if(guess < target)
            System.out.println("It's higher.");
         else if(guess > target)
            System.out.println("It's lower.");
      }while(guess != target);
      if(total ==1)
         System.out.println("You got it right in 1 guess");
      else
         System.out.println("You got it right in "+total+ " guesses");
      return total;
   }
   
   //Accepts the total games played, total guesses made, and least guesses it took to beat one game 
   //and based off of this information; displays some statistics.
   public static void showStats(int totalGames, int totalGuesses, int leastGuesses){
      System.out.println("Overall results:");
      System.out.println("    total games   = "+totalGames);
      System.out.println("    total guesses = "+totalGuesses);
      System.out.println("    guesses/game  = "+(double)totalGuesses/totalGames);
      System.out.println("    best game     = "+leastGuesses);
   }
}