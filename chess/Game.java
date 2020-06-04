package chess;

import java.io.Console;

public class Game {
	private static boolean gameEnd = false;

	public Game() {
		Board b = new Board();
		b.initialisePieces();
		b.printBoard();

		// Global variables
		Console console = System.console();
		String wOrigin;
		String wDestination;
		String bOrigin;
		String bDestination;

		CheckInput checkWOrigin = new CheckInput();
		CheckInput checkWDestination = new CheckInput();
		CheckInput checkBOrigin = new CheckInput();
		CheckInput checkBDestination = new CheckInput();

		int iWOrigin = 0;
		int jWOrigin = 0;
		int iWDestination = 0;
		int jWDestination = 0;
		int iBOrigin = 0;
		int jBOrigin = 0;
		int iBDestination = 0;
		int jBDestination = 0;

		boolean wInput = false;
		boolean bInput = false;

		while (!gameEnd) {

			// First case: White
			System.out.println("");
			System.out.println("------ Whites move ------");

			do {
				System.out.println("> Enter origin:");
				wOrigin = console.readLine();
				if (wOrigin.equals("END") || wOrigin.equals("end")) {
					System.out.println("");
					System.out.println(">>> Blacks wins! <<<");
					gameEnd = true;
					return;
				}
				iWOrigin = wOrigin.charAt(0) - '1';
				jWOrigin = wOrigin.charAt(1) - 'a';
				if (checkWOrigin.checkCoordinateValidity(wOrigin)) {
					if (!b.hasPiece(iWOrigin, jWOrigin)
							|| b.getPiece(iWOrigin, jWOrigin).getColour() == PieceColour.BLACK) {
						wInput = true;
					} else {
						wInput = false;
					}
				} else {
					wInput = true;
				}
			} while (wInput);

			wInput = false;

			do {
				System.out.println("> Enter destination:");
				wDestination = console.readLine();
				if (wDestination.equals("END") || wDestination.equals("end")) {
					System.out.println("");
					System.out.println(">>> Blacks win! <<<");
					gameEnd = true;
					return;
				}
				if (checkWDestination.checkCoordinateValidity(wDestination)) {
					iWDestination = wDestination.charAt(0) - '1';
					jWDestination = wDestination.charAt(1) - 'a';
					if (b.getPiece(iWOrigin, jWOrigin).isLegitMove(iWOrigin, jWOrigin, iWDestination, jWDestination)) {
						if (b.movePiece(iWOrigin, jWOrigin, iWDestination, jWDestination,
								b.getPiece(iWOrigin, jWOrigin))) {
							b.printBoard();
							System.out.println("");
							System.out.println(">>> Whites win! <<<");
							gameEnd = true;
							return;
						}
						wInput = false;
					} else {
						wInput = true;
					}
				} else {
					wInput = true;
				}

			} while (wInput);

			b.printBoard();

			System.out.println("");
			System.out.println("------ Blacks move ------");

			do {
				System.out.println("> Enter origin:");
				bOrigin = console.readLine();
				if (bOrigin.equals("END") || bOrigin.equals("end")) {
					System.out.println("");
					System.out.println(">>> Whites wins! <<<");
					gameEnd = true;
					return;
				}
				iBOrigin = bOrigin.charAt(0) - '1';
				jBOrigin = bOrigin.charAt(1) - 'a';
				if (checkBOrigin.checkCoordinateValidity(bOrigin)) {
					if (!b.hasPiece(iBOrigin, jBOrigin)
							|| b.getPiece(iBOrigin, jBOrigin).getColour() == PieceColour.WHITE) {
						bInput = true;
					} else {
						bInput = false;
					}
				} else {
					bInput = true;
				}

			} while (bInput);

			bInput = false;
			do {
				System.out.println("> Enter destination:");
				bDestination = console.readLine();
				if (bDestination.equals("END") || bDestination.equals("end")) {
					System.out.println("");
					System.out.println(">>> Whites wins! <<<");
					gameEnd = true;
					return;
				}
				if (checkBDestination.checkCoordinateValidity(bDestination)) {
					iBDestination = bDestination.charAt(0) - '1';
					jBDestination = bDestination.charAt(1) - 'a';
					if (b.getPiece(iBOrigin, jBOrigin).isLegitMove(iBOrigin, jBOrigin, iBDestination, jBDestination)) {
						if (b.movePiece(iBOrigin, jBOrigin, iBDestination, jBDestination,
								b.getPiece(iBOrigin, jBOrigin))) {
							b.printBoard();
							System.out.println("");
							System.out.println(">>> Blacks win! <<<");
							gameEnd = true;
							return;
						}
						bInput = false;
					} else {
						bInput = true;
					}
				} else {
					bInput = true;
				}

			}

			while (bInput);

			b.printBoard();

		}

	}

	public static void main(String args[]) {
		Game g = new Game();
	}
}

// 1.javac -d chess/bin chess/*.java
// 2.javac -d chess/bin -cp .;junit-platform-console-standalone.jar
// chess/tests/*.java
// 3.java -jar junit-platform-console-standalone.jar --class-path ./chess/bin
// --scan-class-path --fail-if-no-tests --disable-ansi-colors