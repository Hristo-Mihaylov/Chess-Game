package chess;

public class Queen extends Piece {

	public Queen(PieceColour queenColour) {
		colour = queenColour;

		setSymbol((queenColour == PieceColour.WHITE) ? "\u2655" : "\u265B");
	}

	public boolean isLegitMove(int i, int j, int i1, int j1) {

		// call the current board
		Square[][] board = Board.getBoard();

		// helpful variables
		int iDifference = Math.abs(i1 - i);
		int jDifference = Math.abs(j1 - j);

		if (!board[i][j].hasPiece()) {
			return false;
		}

		if (i == i1 && j == j1) {
			return false;
		}

		if (!(iDifference == jDifference || (iDifference == 0 || jDifference == 0))) {
			return false;
		}

		// Bishop case
		if (iDifference == jDifference) {
			// Main diagonal
			if (i + j != i1 + j1) {
				if (i1 > i && j1 > j) {
					for (int a = i + 1, b = j + 1; a < i1 && b < j1; a++, b++) {

						if (board[a][b].hasPiece()) {
							return false;
						}

					}
				}

				else if (i1 < i && j1 < j) {
					for (int a = i - 1, b = j - 1; a > i1 && b > j1; a--, b--) {

						if (board[a][b].hasPiece()) {
							return false;
						}

					}
				}

			}

			// Reverse diagonal
			else if (i + j == i1 + j1) {

				if (i1 > i && j1 < j) {
					for (int a = i + 1, b = j - 1; a < i1 && b > j1; a++, b--) {

						if (board[a][b].hasPiece()) {
							return false;
						}

					}
				}

				else if (i1 < i && j1 > j) {
					for (int a = i - 1, b = j + 1; a > i1 && b < j1; a--, b++) {

						if (board[a][b].hasPiece()) {
							return false;
						}

					}
				}
			}
		}

		// Rook case
		else if (iDifference == 0 || jDifference == 0) {

			if (iDifference == 0 && jDifference != 0) {

				if (j1 > j) {
					for (int a = j + 1; a < j1; a++) {
						if (board[i][a].hasPiece()) {
							return false;
						}
					}
				}

				else if (j > j1) {
					for (int b = j1 + 1; b < j; b++) {
						if (board[i][b].hasPiece()) {
							return false;

						}
					}
				}
			}

			if (iDifference != 0 && jDifference == 0) {

				if (i1 > i) {
					for (int a = i + 1; a < i1; a++) {
						if (board[a][j].hasPiece()) {
							return false;

						}
					}
				}

				else if (i > i1) {
					for (int b = i1 + 1; b < i; b++) {
						if (board[b][j].hasPiece()) {
							return false;

						}
					}
				}
			}
		}

		if (!(board[i1][j1].hasPiece())) {
			return true;
		} else if (board[i1][j1].hasPiece()) {
			if (board[i][j].getPiece().getColour() == board[i1][j1].getPiece().getColour()) {
				return false;
			} else {
				return true;
			}
		}
		return true;
	}

}
