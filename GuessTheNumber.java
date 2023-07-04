package chapter2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

	int randomNumber, numberGuessed, max, tries;
	int numOfAttempt = 0;
	boolean keepTrying = true;
	String userTryAgain;

	void rangeOfNumber() {

		Scanner roc = new Scanner(System.in);
		while (keepTrying) {
			System.out.println("Enter the range of Number you'll like to guess(1 - ???): ");
			try {
				max = roc.nextInt(); // Accepting User's Range
			} catch (InputMismatchException e) {
				System.err.println("Intergers Only");
				roc.next();
				continue;
			}
			if (max <= 10) { // Ensuring user range is from 10 above
				System.err.println("Too Small, Enter Only Numbers Above 10");
				continue;
			}
			keepTrying = false;
		}
	}

	int scoreBoard() {
		if (max < 30) {
			tries = 5;
			return tries;
		}
		if (max < 100) {
			tries = 8;
			return tries;
		}
		if (max < 250) {
			tries = 10;
			return tries;
		}
		if (max < 500) {
			tries = 12;
			return tries;
		} else
			tries = 15;

		return tries;
	}

	void generateRandom() {
		Random rd = new Random();
		randomNumber = rd.nextInt(1, max + 1); // Generating Random number from 1 - user's choice
//		System.out.println(randomNumber);
	}

	void userGuess() {

		keepTrying = true;
		Scanner ug = new Scanner(System.in);
		System.out.println("\nSTART GAME!!! ");

		while (keepTrying) {

			numOfAttempt++; // counting the number of Attempts
			System.out.printf("\nNumber of tries left : %d \n" + "Guess the Number(1-%d): \n", tries, max);
			try {
				numberGuessed = ug.nextInt(); // Accepting User's Guess
			} catch (InputMismatchException e) {
				System.err.println("Intergers Only");
				ug.next();
				numOfAttempt--; // not counting invalid inputs as Attempt
				continue;
			}

			if (numberGuessed > max || numberGuessed < 1) { // ensuring the User's guess is between 1 - user's choice
				System.out.printf("Enter between 1 - %d \n", max);
				numOfAttempt--; // not counting invalid inputs as Attempt
			} else if (numberGuessed < randomNumber) { //
				System.out.println("Too Low!");
				tries--; // reducing the number of tries left
			} else if (numberGuessed > randomNumber) {
				System.out.println("Too High!");
				tries--; // reducing the number of tries left
			} else {
				System.out.println("Bravo! You are Correct \n" + "The Number is: " + randomNumber
						+ "\nNumber of Attempt(s): " + numOfAttempt);
				keepTrying = false; // break out of the loop
			}

			if (tries == 0) {
				gameOver();
				break;
			}

		}
	}

	void gameOver() {
		keepTrying = true;
		System.out.printf("\nYou Lost! Game Over!!!  \n" + "Play Again? Enter Y/N: ");
		Scanner go = new Scanner(System.in);
		while (keepTrying) {
			try {
				userTryAgain = go.nextLine();
			} catch (InputMismatchException e) {
				System.err.println("Enter only Y or N");
				continue;
			}

			if (userTryAgain.equalsIgnoreCase("Y")) {
				
				numOfAttempt = 0; // reset the number of attempts
				rangeOfNumber();
				scoreBoard();
				generateRandom();
				userGuess();
				keepTrying = false;
				
			} else if (userTryAgain.equalsIgnoreCase("N")) {
				System.out.println("BYE!!!");
				keepTrying = false;
			} else {
				System.out.println("Enter Y or N");
				continue;
			}
		}
		
	}

	public static void main(String[] args) {

		GuessTheNumber obj = new GuessTheNumber();
		obj.rangeOfNumber();
		obj.scoreBoard();
		obj.generateRandom();
		obj.userGuess();

	}

}
