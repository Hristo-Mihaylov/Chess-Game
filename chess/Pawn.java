package chess;

public class Pawn extends Piece {

	public Pawn(PieceColour pawnColour) {
		colour = pawnColour;

		setSymbol((pawnColour == PieceColour.WHITE) ? "\u2659" : "\u265F");
	}

	public boolean isLegitMove(int i, int j, int i1, int j1) {

		Square[][] board = Board.getBoard();

		int iDifference = Math.abs(i1 - i);
		int jDifference = Math.abs(j1 - j);

		if (!board[i][j].hasPiece()) {
			return false;
		}

		if (iDifference > 2 || jDifference > 1) {
			return false;
		}

		if (iDifference == 0 && jDifference == 0) {
			return false;
		}

		if (iDifference == 0) {
			return false;
		}

		// White pawn case
		if (board[i][j].getPiece().getColour() == PieceColour.WHITE) {

			if (i1 >= i) {
				return false;
			}

			if (!(i == 6)) {

				if (iDifference > 1) {
					return false;
				}

				else if (iDifference == 1) {
					if (jDifference == 0) {
						if (board[i1][j1].hasPiece()) {
							return false;
						} else {
							return true;
						}
					} else if (jDifference == 1) {
						if (!board[i1][j1].hasPiece()) {
							return false;
						} else {
							if (board[i1][j1].getPiece().getColour() == PieceColour.BLACK) {
								return true;
							} else {
								return false;
							}
						}

					}
				}

			}

			else if (i == 6) {
				if (iDifference == 2) {
					if (jDifference != 0) {
						return false;
					} else if (jDifference == 0) {
						if (board[i1 + 1][j1].hasPiece() || board[i1][j1].hasPiece()) {
							return false;
						} else {
							return true;
						}
					}
				} else if (iDifference == 1) {
					if (jDifference == 1) {
						if (!board[i1][j1].hasPiece()) {
							return false;
						} else {
							if (board[i1][j1].getPiece().getColour() == PieceColour.BLACK) {
								return true;
							} else {
								return false;
							}
						}
					} else if (jDifference == 0) {
						if (board[i1][j1].hasPiece()) {
							return false;
						} else {
							return true;
						}
					}
				}
			}

		}

		// Black pawn case

		if (board[i][j].getPiece().getColour() == PieceColour.BLACK) {

			if (i >= i1) {
				return false;
			}

			if (!(i == 1)) {
				if (iDifference > 1) {
					return false;
				} else if (iDifference == 1) {
					if (jDifference == 0) {
						if (board[i1][j1].hasPiece()) {
							return false;
						} else {
							return true;
						}
					} else if (jDifference == 1) {
						if (!board[i1][j1].hasPiece()) {
							return false;
						} else {
							if (board[i1][j1].getPiece().getColour() == PieceColour.WHITE) {
								return true;
							} else {
								return false;
							}
						}

					}

				} else if (i == 1) {
					if (iDifference == 2) {
						if (jDifference != 0) {
							return false;
						} else if (jDifference == 0) {
							if (board[i1 - 1][j1].hasPiece() || board[i1][j1].hasPiece()) {
								return false;
							} else {
								return true;
							}
						}
					} else if (iDifference == 1) {
						if (jDifference == 1) {
							if (!board[i1][j1].hasPiece()) {
								return false;
							} else {
								if (board[i1][j1].getPiece().getColour() == PieceColour.WHITE) {
									return true;
								} else {
									return false;
								}
							}
						} else if (jDifference == 0) {
							if (board[i1][j1].hasPiece()) {
								return false;
							} else {
								return true;
							}
						}
					}
				}
			}

		}
		return true;
	}
}
