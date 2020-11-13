// Parth Dhameliya
// CSC 15
// Ben WHite
// Driver class (project 4)

/* This class will be using the helperclass
 * Helper class is Memory game Board 
 * and memory game board will use Card class as a helper
 */

// Import the scanner class
import java.util.Scanner;

public class MemoryGame {
	
	// declaring the static variables Scanner object 
	// and MemoryGameBoard object 
	public static Scanner dg = new Scanner(System.in);
	public static MemoryGameBoard game = new MemoryGameBoard();
	
	
	public static void main(String[] args) {
		
		// initializing the variables being used for the game 
		int bestScore = 999;
		int turnCount;
		int pairsLeft;
		String pRe;
		String sr = "Row :";
		String sc = "Col :";
		int min = 1;                 // Setting up the limit for min
		int max = game.BOARD_SIZE;   // setting up the limit for max.
		
		do {
			game.shuffleCards();
			turnCount = 0;
			pairsLeft = (game.BOARD_SIZE*game.BOARD_SIZE)/2;
			while(pairsLeft>0) {
				turnCount++;        // This whole loop is while so it will work on condition
				game.showBoard();
				System.out.println("Which is the first card you want to see?");
				int r1 = getValidInt(dg, sr, min, max);           // It will get input in int.
				int c1 = getValidInt(dg, sc, min, max);        
				if(game.isFaceUp(r1, c1)) {
					System.out.println("Card already flipped .\n" + 
									      "Enter the Row and Column Again to see the next card.");
					r1 = getValidInt(dg, sr, min, max);
				    c1 = getValidInt(dg, sc, min, max);
				}	
            
            // As user changes choise it will flip a card
				game.flipCard(r1, c1);
				System.out.println("Which card you want to see?");
				int r2 = getValidInt(dg, sr, min, max);
				int c2 = getValidInt(dg, sc, min, max);
				if(game.isFaceUp(r2, c2)) {
					System.out.println("Card already flipped .\n" + 
							             "Enter the Row and Column Again to see the next card.");
					r2 = getValidInt(dg, sr, min, max);
				    c2 = getValidInt(dg, sc, min, max);
				}	
            
            // flip a card for new possibilty	
			    game.flipCard(r2, c2);
				game.showBoard();
            
            // if or else statment 
				if(game.cardsMatch(r1, c1, r2, c2)) {
					System.out.println("You choose A Right Card!!");
					pairsLeft = pairsLeft - 1;
				}
				else {
					game.flipCard(r1, c1);
					game.flipCard(r2, c2);
					System.out.println("Not a Right Card try again.");
				}
			}
         // This mathod will comapare the user's attempt
         // and success
			if(turnCount < bestScore) {
				bestScore = turnCount;
			}
			System.out.println("Great you just won the game");
			System.out.println("Your final Score is: " + turnCount);
			System.out.println("The Best Score till now is : " + bestScore);
			System.out.print("Would you like to play again to have fun:");
			pRe = dg.nextLine();
			while(!pRe.equalsIgnoreCase("yes") && !pRe.equalsIgnoreCase("no")) {
				System.out.println("Input should be eithr \"yes\" or \"no\".");
				pRe = dg.nextLine();
			}
			System.out.println();
		}while(pRe.equalsIgnoreCase("yes"));
		System.out.println("Thanks For Playing.");
	}


	/** 
	 * Prompts the user and loops until they type 
	 * in an integer in between the valid range. Double or string input will
	 * result in another prompt. 
	 * while so is also true for the number which is out of range 
	 */
	 public static int getValidInt(Scanner dg, String s, int m, int M) {
	     int number = 0;
	     boolean valid = false;
	     while(!valid) {
	    	  System.out.print(s);
	    	  if(dg.hasNextInt()) {
	    		 int num = dg.nextInt();
	    		 dg.nextLine();
	    		 if(num>=m && num<=M) {
	    			 valid = true;
	    			 number = num;
	    		 }
	    		 else {
	    			 System.out.println(num + " is not in valid range. {" + m + "..." + M + "}");
	    		 }
	    	 }
	    	 else {
	    		 String numo = dg.nextLine();
	    		 System.out.println(numo + " is not a valid integer {" + m + "..." + M + "}");
	    	 }
	     }
	     return number;
	 }
}

