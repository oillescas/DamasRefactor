package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;


public abstract class Controller {

    protected State state;
	protected Game game;

	protected Controller(State state, Game game) {
		this.state = state;
		this.game = game;
    }

    public Color getColor(Coordinate coordinate) {
		return this.game.getColor(coordinate);
	}

	public int getDimension() {
		return this.game.getDimension();
	}

	abstract public void accept(ControllersVisitor controllersVisitor);
    
}
