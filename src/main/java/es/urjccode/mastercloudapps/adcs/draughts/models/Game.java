package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Game extends MoveValidator{

	private Board board;

	private Turn turn;

	public Game() {
		this.turn = new Turn();
		this.board = new Board();
		for (int i = 0; i < this.board.getDimension(); i++) {
			for (int j = 0; j < this.board.getDimension(); j++) {
				Coordinate coordinate = new Coordinate(i, j);
				Piece piece = this.getInitialPiece(coordinate);
				if (piece != null) {
					this.board.put(coordinate, piece);
				}
			}
		}
	}

	private Piece getInitialPiece(Coordinate coordinate) {
		if (coordinate.isBlack()) {
			final int row = coordinate.getRow();
			Color color = null;
			if (row <= 2) {
				color = Color.BLACK;
			} else if (row >= 5) {
				color = Color.WHITE;
			}
			if (color != null) {
				return new Piece(color);
			}
		}
		return null;
    }

    Error moveValid(Coordinate origin, Coordinate target){
        Color color = this.board.getColor(origin);
		if (color!=null && this.turn.getColor() != color) {
			return Error.OPPOSITE_PIECE;
        }
        return this.validNext(origin, target);
    }

    public Error getErrorMove(Move move){

        this.setNext(move.origin);
        move.origin.setNext(board);

        return this.moveValid(move.origin, move.target);
    }

	public void move(Move move) {
        assert getErrorMove(move) ==null;

		if (move.diagonalDistance() == 2) {
			Coordinate between = move.betweenDiagonal();
			this.board.remove(between);
		}
		this.board.move(move.origin, move.target);
		this.turn.change();
	}

	public Color getColor(Coordinate coordinate) {
		return this.board.getColor(coordinate);
	}

	@Override
	public String toString() {
		return this.board + "\n" + this.turn;
	}

	public Color getColor() {
		return this.turn.getColor();
	}

	public Piece getPiece(Coordinate coordinate) {
		return this.board.getPiece(coordinate);
	}

	public boolean isBlocked() {
		return this.board.getPieces(this.turn.getColor()).isEmpty();
	}

	public int getDimension() {
		return this.board.getDimension();
	}

}
