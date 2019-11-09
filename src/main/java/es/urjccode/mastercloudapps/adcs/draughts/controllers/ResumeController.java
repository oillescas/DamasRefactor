package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;

public class ResumeController extends Controller {

	public ResumeController(State state, Game game) {
		super(state, game);
	}
    
    @Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

	public void next() {
        this.state.next();
	}

	public void reset() {
        this.state.reset();
	}

}
