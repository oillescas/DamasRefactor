package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Piece extends MoveValidator{

	private Color color;

	Piece(Color color){
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

	public boolean isAdvanced(Move move) {
		int difference = move.getOrigin().getRow() - move.getTarget().getRow();
		if (color == Color.WHITE){
			return difference>0;
		}
		return difference<0;
	}

	@Override
	Error moveValid(Move move, PieceSearcher searcher) {

		if (!move.isDiagonal()) {
			return Error.NOT_DIAGONAL;
        }
		if (!this.isAdvanced(move)) {
			return Error.NOT_ADVANCED;
        }
        if (move.diagonalDistance() >= 3) {
			return Error.BAD_DISTANCE;
		}
        
        if (move.diagonalDistance() == 2) {
			Coordinate between = move.betweenDiagonal();
			if (searcher.getPiece(between) == null) {
				return Error.EATING_EMPTY;
			}
        }

		return this.validNext(move, searcher);
	}

}