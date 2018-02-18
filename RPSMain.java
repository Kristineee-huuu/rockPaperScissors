package rockPaperScissors;
import java.util.Scanner;

public class RPSMain
{

		public static void main(String[] args)
		{
			System.out.println("New game of Rock, Paper, Scissors!");
			System.out.println("Games consist of three rounds.");
			System.out.println("Valid input consists of 'rock', 'paper', and 'scissors'");
			System.out.println("*******************************");
			System.out.println("");
			
			boolean gameRunning = true;
			int userScore = 0;
			int compScore = 0;
			
			Scanner reader = new Scanner(System.in);
			
			while(gameRunning)
			{
				System.out.println("Enter your choice: ");
				String userInput = reader.next().toString();
				
				switch (runGame(userInput)){
				case 2: System.out.println("It's a draw"); break;
				case 1: System.out.println("You won the round!"); userScore++; break;
				case 0: System.out.println("Computer wins this round."); compScore++; break;
				case 4: break;
				}
				
				if(userScore == 3)
				{
					System.out.println("Congratulations, you won the game!");
					return;
				}else if(compScore == 3)
				{
					System.out.println("Sorry, the computer won the game");
					return;
				}
			}
			
		}//end main
		
		static String getCompChoice()
		{
			int x = (int) (Math.random() * 3 + 1);
			
			switch (x) {
			case 1: return "rock";
			case 2: return "paper";
			case 3: return "scissors";
			}
			
			return ""; //this should never be reached
		}
		
		/*This method determines who wins the current round
		 * 1 means User wins, 0 means Comp wins, 2 means draw
		 */
		static int runGame(String userInput)
		{
			
			String compChoice = getCompChoice();
			System.out.println("Computer draws " + compChoice + ".");

			if(userInput.equals(compChoice))
				return 2;
			
			switch (userInput.toLowerCase()){
				case "rock":
					if(compChoice.equals("paper")) return 0;
					else return 1;
				case "paper":
					if(compChoice.equals("rock")) return 1;
					else return 0;
				case "scissors":
					if(compChoice.equals("rock")) return 0;
					else return 1;
				default: System.out.println("INVALID USER INPUT. Try Again."); return 4;
			}
		}//end runGame
		
}//end class


