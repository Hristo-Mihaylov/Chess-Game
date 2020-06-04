package chess;

public class Rook extends Piece{

	public Rook(PieceColour rookColour){
		colour = rookColour;
		setSymbol((rookColour == PieceColour.WHITE)? "\u2656": "\u265C");
	}

	public boolean isLegitMove(int i, int j, int i1, int j1){

		Square[][] board = Board.getBoard();

		int iDifference = Math.abs(i1 - i);
		int jDifference = Math.abs(j1 - j);

		if (!board[i][j].hasPiece()){
			return false;
		}

		if (!(iDifference == 0 || jDifference == 0)){
			return false;
		}
		

		if (iDifference == 0 && jDifference == 0){
			return false;
		}


		if (iDifference == 0 && jDifference != 0){

			if (j1 > j){
				for (int a=j+1; a<j1; a++){
					if (board[i1][a].hasPiece()){
						return false;
					}
				}
			}

			else if (j > j1){
				for (int b =j1+1; b<j; b++){
					if (board[i1][b].hasPiece()){
						return false;
						
					}
				}
			}
		}

		if (iDifference != 0 && jDifference == 0){

			if (i1 > i){
				for(int a = i+1; a<i1; a++){
					if (board[a][j1].hasPiece()){
						return false;
						
					}
				}
			}

			else if (i > i1){
				for (int b=i1+1; b<i; b++){
					if (board[b][j1].hasPiece()){
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
