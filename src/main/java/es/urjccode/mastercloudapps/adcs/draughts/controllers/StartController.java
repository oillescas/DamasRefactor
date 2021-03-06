package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;

public class StartController extends Controller {

	public StartController(State state, Game game) {
		super(state, game);
	}

    @Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
    }

	public void start() {
        this.state.next();
	}
    
}
