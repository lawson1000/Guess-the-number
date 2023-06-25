package chapter2;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
	int rNum;
	int numberGuessed;
	
	void generateRandom() {
		Random rd = new Random();
		rNum = rd.nextInt(1,81); // Generating Random number from 1 - 80 
		System.out.println(rNum);
	}
	void userGuess() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Guess the Number: ");
		numberGuessed = sc.nextInt(); 
		
		if (numberGuessed < rNum) {
			System.out.println("Too Low!");
		}
		else if(numberGuessed > rNum) {
			System.out.println("Too High!");
		}
		else {
			System.out.println("Correct");
		}
	}

	public static void main(String[] args) {
		GuessTheNumber obj = new GuessTheNumber();
		obj.generateRandom();
		obj.userGuess();
		
		
		Scanner sc = new Scanner(System.in);
	}

}
