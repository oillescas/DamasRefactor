package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Session {

	public State state;

	public Game game;

	public Session(State state, Game game){
		this.state = state;
		this.game = game;
	}

	public Error move(Coordinate origin, Coordinate target) {
		return this.game.move(origin, target);
	}

	public Piece getPiece(Coordinate coordinate) {
		return this.game.getPiece(coordinate);
	}

	public Color getColor() {
		return this.game.getColor();
	}

	public Color getColor(Coordinate coordinate) {
		return this.game.getColor(coordinate);
	}

	public boolean isBlocked() {
		return this.game.isBlocked();
	}

	public int getDimension() {
		return this.game.getDimension();
	}

	

}
