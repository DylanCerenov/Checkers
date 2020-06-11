class CheckerPiece extends Piece
{
    private String color;

    //************
    // Sets color.
    //************
	public CheckerPiece(String input)
    {
        color = input;
    }

    //***************************************************
	// Checks if white has valid moves for win condition.
    // If all existing pieces do not have valid moves. 
    //***************************************************
	public static boolean WhiteNoValidMoves()
	{
		int whiteCheckers = 0;
        int tokensWithNoValidMoves = 0;
		
		// Counts checkers
		for(int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (CheckersBoard.board[i][j].getColor().equals("WT"))
					whiteCheckers++;
				else if (CheckersBoard.board[i][j].getColor().equals("WK"))
					whiteCheckers++;
			}
		}
        
        // increases int by every token without valid moves
        for(int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
                if (CheckersBoard.board[i][j].getColor().equals("WT"))
                {
                    try
                    {
                        boolean part1 = (CheckersBoard.board[i-1][j-1].getColor().equals("  ") || CheckersBoard.board[i-1][j+1].getColor().equals("  ")); // move available
                        boolean part2 = (CheckersBoard.board[i-2][j-2].getColor().equals("  ") && CheckersBoard.board[i-1][j-1].getColor().charAt(0) == 'R'); // jump available
                        boolean part3 = (CheckersBoard.board[i-2][j+2].getColor().equals("  ") && CheckersBoard.board[i-1][j+1].getColor().charAt(0) == 'R'); // jump avaible

                        // moving in forward directions isnt possible, or no jumps available
                        if (!part1 && !part2 && !part3)
                            tokensWithNoValidMoves++;
                    }
                    catch (ArrayIndexOutOfBoundsException e)
                    {

                    }
                }
                else if (CheckersBoard.board[i][j].getColor().equals("WK"))
                {
                    try
                    {
                        boolean part1 = (CheckersBoard.board[i-1][j-1].getColor().equals("  ") || CheckersBoard.board[i-1][j+1].getColor().equals("  ") || CheckersBoard.board[i+1][j-1].getColor().equals("  ") || CheckersBoard.board[i+1][j+1].getColor().equals("  "));
                        boolean part2 = (CheckersBoard.board[i-2][j-2].getColor().equals("  ") && CheckersBoard.board[i-1][j-1].getColor().charAt(0) == 'R');
                        boolean part3 = (CheckersBoard.board[i-2][j+2].getColor().equals("  ") && CheckersBoard.board[i-1][j+1].getColor().charAt(0) == 'R');
                        boolean part4 = (CheckersBoard.board[i+2][j-2].getColor().equals("  ") && CheckersBoard.board[i+1][j-1].getColor().charAt(0) == 'R');
                        boolean part5 = (CheckersBoard.board[i+2][j+2].getColor().equals("  ") && CheckersBoard.board[i+1][j+1].getColor().charAt(0) == 'R');

                        // white king is surrounded or has no jumps available.
                        if (!part1 && !part2 && !part3 && !part4 && !part5)
                            tokensWithNoValidMoves++;
                    }
                    catch (ArrayIndexOutOfBoundsException e)
                    {

                    }
                }
            }
        }

		return whiteCheckers == tokensWithNoValidMoves;
	}

    //*************************************************
	// Checks if red has valid moves for win condition.
    //*************************************************
	public static boolean RedNoValidMoves()
	{
		int redCheckers = 0;
        int tokensWithNoValidMoves = 0;
		
		// Counts checkers
		for(int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (CheckersBoard.board[i][j].getColor().equals("RD"))
					redCheckers++;
				else if (CheckersBoard.board[i][j].getColor().equals("RK"))
					redCheckers++;
			}
		}
        
        // increases int by every token without valid moves
        for(int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
                if (CheckersBoard.board[i][j].getColor().equals("RD"))
                {
                    try
                    {
                        boolean part1 = (CheckersBoard.board[i-1][j-1].getColor().equals("  ") || CheckersBoard.board[i-1][j+1].getColor().equals("  ")); // move available
                        boolean part2 = (CheckersBoard.board[i-2][j-2].getColor().equals("  ") && CheckersBoard.board[i-1][j-1].getColor().charAt(0) == 'W'); // jump available
                        boolean part3 = (CheckersBoard.board[i-2][j+2].getColor().equals("  ") && CheckersBoard.board[i-1][j+1].getColor().charAt(0) == 'W'); // jump avaible

                        // moving in forward directions isnt possible, or no jumps available
                        if (!part1 && !part2 && !part3)
                            tokensWithNoValidMoves++;
                    }
                    catch (ArrayIndexOutOfBoundsException e)
                    {

                    }
                }
                else if (CheckersBoard.board[i][j].getColor().equals("RK"))
                {
                    try
                    {
                        boolean part1 = (CheckersBoard.board[i-1][j-1].getColor().equals("  ") || CheckersBoard.board[i-1][j+1].getColor().equals("  ") || CheckersBoard.board[i+1][j-1].getColor().equals("  ") || CheckersBoard.board[i+1][j+1].getColor().equals("  "));
                        boolean part2 = (CheckersBoard.board[i-2][j-2].getColor().equals("  ") && CheckersBoard.board[i-1][j-1].getColor().charAt(0) == 'W');
                        boolean part3 = (CheckersBoard.board[i-2][j+2].getColor().equals("  ") && CheckersBoard.board[i-1][j+1].getColor().charAt(0) == 'W');
                        boolean part4 = (CheckersBoard.board[i+2][j-2].getColor().equals("  ") && CheckersBoard.board[i+1][j-1].getColor().charAt(0) == 'W');
                        boolean part5 = (CheckersBoard.board[i+2][j+2].getColor().equals("  ") && CheckersBoard.board[i+1][j+1].getColor().charAt(0) == 'W');

                        // white king is surrounded or has no jumps available.
                        if (!part1 && !part2 && !part3 && !part4 && !part5)
                            tokensWithNoValidMoves++;
                    }
                    catch (ArrayIndexOutOfBoundsException e)
                    {

                    }
                }
            }
        }

		return redCheckers == tokensWithNoValidMoves;
	}

    //***************************
    // Sets color based on input.
    //***************************
    public void setColor(String input)
    {
        color = input;
    }

    //********************
    // Get color of piece.
    //********************
    public String getColor()
    {
        return color;
    }

    //*******************
    // Prints toString().
    //*******************
    public String toString()
    {
        return color;
    }
}