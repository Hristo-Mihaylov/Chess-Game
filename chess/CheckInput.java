package chess;

public class CheckInput {
	
	
	public boolean checkCoordinateValidity(String input){

		if (input.equals("END") || input.equals("end")){
			return true;
		}

		if (input.length() != 2){
			return false;
		}

		if (input.charAt(0) < '1' || input.charAt(0) > '8'){
			return false;
		}

		if (input.charAt(1) < 'a' || input.charAt(1) > 'h'){
			return false;
		}

		return true;
	}
}
