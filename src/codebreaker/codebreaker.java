package codebreaker;
import java.util.Scanner; // Scanner is input for console 

public class codebreaker {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String colors []= {"Red", "Green", "Yellow", "Orange", "Purple", "Blue", "Space"};
		String answer []= new String [4];
		boolean gameOver = false;
		int loop = 0; // Loop worth
		int turn = 0; // Who's turn it is
		
		while (loop<4) {
			int rand = (int) (Math.random() * 7); // Math.random for random number from String colors
			answer[loop] = colors[rand];
			System.out.println(answer[loop]);
			loop++;
		}
		
		while (!gameOver && turn<10) { //gameOver false = game started. && = AND, turn lower than 10
			if (turn == 0){ 
				System.out.println("Each round you get 4 hints: 'zwart' means you have a correct color in the correct position, 'wit' means you have a correct color in the wrong position and 'null' means that color is not in the sequence.");
				System.out.println("Welcome to Mastermind!");
			}
			
			System.out.println( "Chose 4 colors (seperated by a space)");
			String input = scanner.nextLine(); // For an input on the next line
			String[] inputColors = input.split(" "); // the space is that it knows that there is a split
			
			String result1, result2, result3, result4;
			
			if (inputColors[0].equalsIgnoreCase(answer[0])) { // Equals is =
                result1 = "zwart"; // if yes it says black
            } else if (inputColors[0].equalsIgnoreCase(answer[1]) || inputColors[0].equalsIgnoreCase(answer[2]) || inputColors[0].equalsIgnoreCase(answer[3])) { // inputColors check answer is in 1-3
                result1 = "wit"; // if yes it says white
            } else {
                result1 = "null";
            }

            if (inputColors[1].equalsIgnoreCase(answer[1])) {
                result2 = "zwart";
            } else if (inputColors[1].equalsIgnoreCase(answer[0]) || inputColors[1].equalsIgnoreCase(answer[2]) || inputColors[1].equalsIgnoreCase(answer[3])) { // || = OF
                result2 = "wit";
            } else {
                result2 = "null";
            }

            if (inputColors[2].equalsIgnoreCase(answer[2])) {
                result3 = "zwart";
            } else if (inputColors[2].equalsIgnoreCase(answer[0]) || inputColors[2].equalsIgnoreCase(answer[1]) || inputColors[2].equalsIgnoreCase(answer[3])) {
                result3 = "wit";
            } else {
                result3 = "null";
            }

            if (inputColors[3].equalsIgnoreCase(answer[3])) {
                result4 = "zwart";
            } else if (inputColors[3].equalsIgnoreCase(answer[0]) || inputColors[3].equalsIgnoreCase(answer[1]) || inputColors[3].equalsIgnoreCase(answer[2])) {
                result4 = "wit";
            } else {
                result4 = "null";
            }
            
            if (answer[0].equalsIgnoreCase(inputColors[0]) && answer[1].equalsIgnoreCase(inputColors[1]) && answer[2].equalsIgnoreCase(inputColors[2]) && answer[3].equalsIgnoreCase(inputColors[3])) { //checks answer
                System.out.println("Congratulations! You've guessed the correct sequence!"); // if yes. shows win
                gameOver = true; // game = done
            } else if (turn == 9) { // checks turns
                System.out.println("Game Over! you've used all your turns. The correct sequence was: " + answer[0] + " " + answer[1] + " " + answer[2] + " " + answer[3]); // says loss. shows answer
                gameOver = true; 
            } else {
            	System.out.println("Incorrect guess. Try again. here are your hints: "+result1 + " " + result2 + " " + result3 + " " + result4); // show hint (black and white)
            }
			
			turn++; // Plus a Turn until 10 
			
		}
		scanner.close(); // Close Scanner input 
		
		

	}

}
