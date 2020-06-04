package chess;

public class King extends Piece{

	public King(PieceColour kingColour){

		colour = kingColour;
		setSymbol((kingColour == PieceColour.WHITE)? "\u2654": "\u265A");
	}

	public boolean isLegitMove(int i, int j, int i1, int j1){

		Square[][] board = Board.getBoard();

		int iDifference = Math.abs(i1 - i);
		int jDifference = Math.abs(j1 - j);

		if (!board[i][j].hasPiece()){
			return false;
		}

		if (iDifference > 1 || jDifference > 1){
			return false;
		}

		if (i == i1 && j == j1){
			return false;
		}

		if (!(board[i1][j1].hasPiece())){
			return true;
		}
		else if (board[i1][j1].hasPiece()){
				if (board[i][j].getPiece().getColour() == board[i1][j1].getPiece().getColour()){
					return false;
				}
				else{
					return true;
				}
			}

		return true;
	}

	
}
