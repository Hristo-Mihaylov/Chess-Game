package chess;

public class Bishop extends Piece{

	public Bishop(PieceColour bishopColour){
		colour = bishopColour;
		setSymbol((bishopColour == PieceColour.WHITE)? "\u2657": "\u265d");
	}

	public boolean isLegitMove(int i, int j, int i1, int j1){

		Square[][] board = Board.getBoard();

		int iDifference = Math.abs(i1 - i);
		int jDifference = Math.abs(j1 - j);

		if (!board[i][j].hasPiece()){
			return false;
		}

		if (!(iDifference == jDifference)){
			return false;
		}

		if (iDifference == 0 && jDifference == 0){
			return false;
		}

		

		//Main diagonal
		if (iDifference == jDifference && i+j != i1+j1){
			if (i1>i && j1>j){
				for (int a=i+1, b=j+1; a<i1 && b<j1; a++, b++){
					
						if (board[a][b].hasPiece()){
							return false;
						
					}
				}
			}

			else if (i1<i && j1<j){
				for (int a=i-1, b=j-1; a>i1 && b>j1; a--, b--){
					
						if (board[a][b].hasPiece()){
							return false;
						
					}
				}
			}

		}

		//Reverse diagonal
		else if (iDifference == jDifference && i+j == i1+j1){

			if (i1>i && j1<j){
				for (int a=i+1, b=j-1; a<i1 && b>j1; a++, b--){
					
						if (board[a][b].hasPiece()){
							return false;
						}
					
				}
			}

			else if (i1<i && j1>j){
				for (int a=i-1, b=j+1; a>i1 && b<j1; a--, b++){
					
						if (board[a][b].hasPiece()){
							return false;
						
					}
				}
			}
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
