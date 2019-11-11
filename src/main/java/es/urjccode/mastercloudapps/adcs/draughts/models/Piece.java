package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Piece {

	private Color color;

	Piece(Color color){
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

	public boolean isAdvanced(Move move) {
		int difference = move.origin.getRow() - move.target.getRow();
		if (color == Color.WHITE){
			return difference>0;
		}
		return difference<0;
	}

}