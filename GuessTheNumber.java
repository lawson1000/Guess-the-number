package chapter2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
	int randomNumber;
	int numberGuessed;
	int numOfAttempt = 0;

	void generateRandom() {
		Random rd = new Random();
		randomNumber = rd.nextInt(1, 81); // Generating Random number from 1 - 80
		System.out.println(randomNumber);
	}

	void userGuess() {
		boolean keepTrying = true;
		Scanner sc = new Scanner(System.in);

		while (keepTrying) {
			numOfAttempt++; // counting the number of Attempts
			System.out.println("Guess the Number(1-80): ");
			try {
				numberGuessed = sc.nextInt(); // Accepting User's Guess
			} catch (InputMismatchException e) {
				System.err.println("Intergers Only");
				sc.next();
				numOfAttempt--; // not counting invalid inputs as Attempt
				continue;
			}

			if (numberGuessed > 80 || numberGuessed < 1) { // ensuring the User's guess is between 1-80
				System.err.println("Enter between 1-80");
				numOfAttempt--; // not counting invalid inputs as Attempt
			} else if (numberGuessed < randomNumber) { //
				System.out.println("Too Low!");
			} else if (numberGuessed > randomNumber) {
				System.out.println("Too High!");
			} else {
				System.out.println("Bravo! You are Correct \n"
						+ "The Number is: " + randomNumber
						+ "\nNumber of Attempt(s): " + numOfAttempt);
				keepTrying = false; // break out of the loop
			}
		}
	}

	public static void main(String[] args) {
		GuessTheNumber obj = new GuessTheNumber();
		obj.generateRandom();
		obj.userGuess();
	}

}
