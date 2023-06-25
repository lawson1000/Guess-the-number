package chapter2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
	int randomNumber, numberGuessed, max;
	int numOfAttempt = 0;
	boolean keepTrying = true;

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

	void generateRandom() {
		Random rd = new Random();
		randomNumber = rd.nextInt(1, max + 1); // Generating Random number from 1 - user's choice
//		System.out.println(randomNumber);
	}

	void userGuess() {
		keepTrying = true;
		Scanner ug = new Scanner(System.in);

		while (keepTrying) {
			numOfAttempt++; // counting the number of Attempts
			System.out.printf("Guess the Number(1-%d): \n", max);
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
			} else if (numberGuessed > randomNumber) {
				System.out.println("Too High!");
			} else {
				System.out.println("Bravo! You are Correct \n" + "The Number is: " + randomNumber
						+ "\nNumber of Attempt(s): " + numOfAttempt);
				keepTrying = false; // break out of the loop
			}
		}
	}

	public static void main(String[] args) {
		GuessTheNumber obj = new GuessTheNumber();
		obj.rangeOfNumber();
		obj.generateRandom();
		obj.userGuess();
	}

}
