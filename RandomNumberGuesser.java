import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class RandomNumberGuesser {
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		RNG randomGuess = new RNG(); //Creates an object for the RNG class
		Scanner scanner = new Scanner(System.in);
		
		//While the user wants to play the game it will keep playing until the user ends it
		boolean playingGame = true;
		while(playingGame) { //Checks if you're currently playing the game
			//Sets the default high and low bounds each game
			int highGuess = 100;
			int lowGuess = 0;
			
			//Generates the random number
			int randNumd = randomGuess.rand();
			randomGuess.resetCount();

			//Loops through user input to make sure the user is correct
			boolean solved = false;
			while(solved != true) { //Loops through until user guessed the number
				System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
				
				int nextGuess = checkInput(scanner); //Makes sure the input given was an int
				boolean isValidNum = randomGuess.inputValidation(nextGuess, lowGuess, highGuess);
				
				while(!isValidNum) {
					//Loops through until the user gives valid input
					nextGuess = checkInput(scanner);
					isValidNum = randomGuess.inputValidation(nextGuess, lowGuess, highGuess);
				}
				if(isValidNum) { //If the number is valid then run this
					//Prints out the number of guesses
					int guesses = randomGuess.getCount();
					System.out.println("Number of guesses is " + guesses);
					
					if(nextGuess == randNumd) { 
						//If it's the correct number mark it as solved
						System.out.println("Congratulations, you guesses correctly");
						solved = true;
					}else if(nextGuess > randNumd){
						//Change the highGuess to be lower
						System.out.println("Your guess is too high");
						highGuess = nextGuess;
					}else if(nextGuess < randNumd){
						//Change the lowGuess to be higher
						System.out.println("Your guess is too low");
						lowGuess = nextGuess;
					}
				}
				
			}
			
			//Check to see if the user wants to play again
			System.out.print("Try again? (yes or no) \n");
			String userAnswer = scanner.nextLine();
			userAnswer = scanner.nextLine();
			if(userAnswer.equals(new String("no"))) {
				//The user ends the program, say thanks for playing.
				playingGame = false;
				System.out.println("Thank you for playing the RNG game by Parker Link!");
			}
			//Starts the game again
		}		
		
	}
	public static int checkInput(Scanner scanner) {
		try {
			return scanner.nextInt();
	    }catch (InputMismatchException e) {
	        System.err.println("Wrong input! Input only integer numbers please...");
	        scanner.nextLine();
	    }
		return 0;
	}
}

