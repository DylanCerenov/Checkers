import java.util.*;
class Main 
{
    static String turnColor;

  	public static void main(String[] args) 
  	{
		// Prerequisites:
		System.out.println();
		Scanner scan = new Scanner(System.in);
		CheckersBoard board = new CheckersBoard();
		String response;
		boolean playing = true;

		// Phase 0: Intro
		System.out.println("--------------------\nWelcome to Checkers!\n--------------------");
		
		System.out.println("Do you know the rules for checkers? (yes/no)");
		response = scan.nextLine();

		while (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no"))
		{
			System.out.println("Error: Invalid input. Enter (yes/no)");
			response = scan.nextLine(); 
		}

		if (response.equalsIgnoreCase("no"))
		{
			String rules = "Rules: This game is played on a 64 square board. Both players have 12 checkers, which they use to capture their opponents checkers. When a player has no available moves or checkers left, they lose the game. Checkers can only move diagonally and player can jump over an opponent's checker to remove it from play. Proper input for this program is:\n(OriginLetter)(OriginNumber) (DestinationLetter)(DestinationNumber)";
			System.out.println(rules);
		}
        
		//****************
		// Phase 1: Game Time
		System.out.println("\nWould you like to start the game? (yes/no)");
		response = scan.nextLine();

		while (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no"))
		{
			System.out.println("Error: Invalid input. Enter (yes/no)");
			response = scan.nextLine();
		}

		while (response.equalsIgnoreCase("yes"))
		{
            int count = 0;
            System.out.println();
			board.displayBoard(); // first board showing
            while (playing) // each turn
			{
                CheckersBoard.jumpHappened = false;
                String temp1, temp2;

                // CHANGES TURN COLOR 
                if(count % 2 == 0)
                    turnColor = "RD";
                else
                    turnColor = "WT";

                // REQUEST USER INPUT
                // Prints directions
                if (turnColor.equals("WT"))
                    System.out.println("\nEnter WHITE move (example: a3 b4):");
                else   
                    System.out.println("\nEnter RED move (example: b6 c5):");
                temp1 = scan.next(); temp2 = scan.next();

                // checks syntax, valid token being moved, if its a valid move
                while (board.incorrectSyntax(temp1, temp2) || !(turnColor.charAt(0) == board.currentTurn(temp1,temp2).charAt(0)) || !board.validMove(temp1, temp2))
                {
                    if (turnColor.equals("WT"))
                        System.out.println("Error: Invalid move entered.");
                    else
                        System.out.println("Error: Invalid move entered.");

                    System.out.println();
                    board.displayBoard(); // requirement.

                    if (turnColor.equals("WT"))
                        System.out.println("\nEnter WHITE move (example: a3 b4):");
                    else
                        System.out.println("\nEnter RED move (example: b6 c5):");
                    temp1 = scan.next(); temp2 = scan.next();
                }
                
                board.updateBoard(temp1, temp2);
                System.out.println();
                board.displayBoard();
                
                scan.nextLine();
                while (board.jumpAvailable(temp2) && CheckersBoard.jumpHappened)
                {
                    System.out.println("\nYou have the option to jump again. Enter (yes/no)");
                    String r = scan.nextLine();
                    while (!r.equalsIgnoreCase("yes") && !r.equalsIgnoreCase("no"))
                    {
                        System.out.println("Error: Invalid input. Enter (yes/no)");
                        r = scan.nextLine();
                    }
                    if(r.equalsIgnoreCase("yes"))
                    {
                        board.jump(temp2, CheckersBoard.jumpToPosition);
                        temp2 = CheckersBoard.jumpToPosition;
                        System.out.println();
                        board.displayBoard();
                    }
                    else
                        break;
                }
                CheckersBoard.jumpHappened = false;
                
                // checks if someone won the game. 
				if (board.winConditionsMet())
				{
                    playing = false;
					System.out.println(board.getWinner() + " is the winner. GG");
                    break;
				}
                count++; // changes turn.
            }

            System.out.println("Would you like to play again? (yes/no)");
            response = scan.nextLine();

            while (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no"))
            {
                System.out.println("Error: Invalid input. Enter (yes/no)");
                response = scan.nextLine();
            }

            if (response.equalsIgnoreCase("yes"))
            {
                board.resetBoard();
                playing = true;
                System.out.println("\nNew Game: ");
            }
		}
		//****************

		// Later skater:
		System.out.println("\nThank you for playing checkers!");
        System.out.println("Programmed by Dylan & Ryan");
  	}
}