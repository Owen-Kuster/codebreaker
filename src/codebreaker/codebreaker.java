package codebreaker;

import java.util.Scanner;

public class codebreaker {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String colors[] = { "red", "green", "orange", "yellow", "purple", "blue" };
		String[] answer = new String[4];
		boolean gameOver = false;
		int turn = 1;

		// loop for filling up answer with random color
		for (int i = 0; i < 4; i++) {
			int rand = (int) (Math.random() * 6);
			answer[i] = colors[rand];
		}

		//System.out.println(answer[0] + answer[1] + answer[2] + answer[3]); // prints out answers for me to test the game

		//explanations game
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Welcome to Mastermind! (made by Owen Kuster)");												
		System.out.println("Each round you get 2 hints: 'Black' meaning you have the correct place 'White' meaning correct color in the wrong place!");
		System.out.println("You can choose from the colors: Red, Green, Yellow, Orange, Purple, Blue");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		System.out.println(" ");
		System.out.println("<---- GUESS THE CODE ---->");

		//loop for turns until turn 11
		while (!gameOver && turn < 11) {
			System.out.println("Choose 4 colors seperated by a space (spacebar)");
			System.out.println("This is turn " + turn);
			String input = scanner.nextLine();
			String[] guess = input.trim().split(" ");

			// length of the array guess, if not skip rest code, repeat
			if (guess.length != 4) {
				System.out.println("Please enter 4 colors");
				continue;
			}

			// black check with for loop for each place
			int black = 0;
			boolean[] answerMatched = new boolean[4]; // checks if the position is correct array van boolean false, false, false, false
			boolean[] guessMatched = new boolean[4]; // checks if the position is correct array van boolean false, false, false, false
			for (int i = 0; i < 4; i++) {
				if (guess[i].equalsIgnoreCase(answer[i])) {
					black++;
					answerMatched[i] = true;
					guessMatched[i] = true; 
					System.out.println("Number " + (i + 1) + " " + guess[i] + " is black");
				}
			}
			// white check with for loop for each place
			int white = 0;
			for (int i = 0; i < 4; i++) {
				boolean foundColor = false;
				if (!guessMatched[i]) {
					for (int j = 0; j < 4; j++) { // repeats 4 times if guess is in position j
						if (!answerMatched[j] && guess[i].equalsIgnoreCase(answer[j])) { // if answerMatched is not in the sequence it checks if guess contains answer j
							white++;
							answerMatched[j] = true;
							System.out.println("Number " + (i + 1) + " " + guess[i] + " is white");
							foundColor = true;
						}
					}
					// none check
					if (!foundColor) {
						System.out.println("Number " + (i + 1) + " " + guess[i] + " is none");
					}
				}
			}
			turn++;
			// win check and loss check
			if (black == 4) {
				System.out.println("<----You have guessed the correct sequence---->");
				gameOver = true; 
			} else if (turn >= 11) {
				System.out.println("GAME OVER! You have used all your turns!");
				System.out.println(
						"The correct sequence was: " + answer[0] + " " + answer[1] + " " + answer[2] + " " + answer[3]);
			}
		}
		scanner.close();

	}
}