package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.Controller;
import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class GameView extends SubView {

    private static final String[] COLORS = new String[]{
        Message.WHITE_PIECE.getMessage(), 
        Message.BLACK_PIECE.getMessage(), 
        Message.EMPTY_PIECE.getMessage()
    };
    
	public void write(Controller controller) {
        final int DIMENSION = controller.getDimension();
        this.writeNumbersLine(DIMENSION);
        writeMainBoard(controller);
        this.writeNumbersLine(DIMENSION);
	}

	private void writeMainBoard(Controller controller) {
		final int DIMENSION = controller.getDimension();
		for(int i=0; i<DIMENSION; i++){
            this.console.write((i+1)+"");
            for(int j=0; j<DIMENSION; j++){
                writeSquare(controller, new Coordinate(i,j));
            }
            this.console.writeln((i+1)+"");
        }
	}

	private void writeSquare(Controller controller, Coordinate coordinate) {
		Color color = controller.getColor(coordinate);
		if (color == null){
		    this.console.write(GameView.COLORS[2]);
		} else {
		    this.console.write(GameView.COLORS[color.ordinal()]);
		}
	}

    private void writeNumbersLine(final int DIMENSION) {
        this.console.write(" ");
        for(int i=0; i<DIMENSION; i++){
            this.console.write((i+1)+"");
        }
        this.console.writeln();
    }

}
