package chess;

public abstract class Piece { // The abstract class

	private int row;
	private int column;
	private String symbol;
	protected PieceColour colour;

	public Piece(){

	}

	public String getSymbol(){
		return symbol;
	}

	public void setSymbol(String newSymbol){
		symbol = newSymbol;
	}

	public PieceColour getColour(){
		return colour;
	}

	public void updateCoordinates(int i, int j){
		row = i;
		column = j;
	}

	public abstract boolean isLegitMove(int i, int j, int i1, int j1);
		
	

}
