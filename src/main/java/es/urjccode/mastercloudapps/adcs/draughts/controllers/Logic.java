package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import java.util.HashMap;
import java.util.Map;

import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;
import es.urjccode.mastercloudapps.adcs.draughts.models.StateValue;

public class Logic {

    private StartController startController;
    private PlayController playController;
    private ResumeController resumeController;
	private Map<StateValue, Controller> controllers;
	private State state;
	private Game game;

	public Logic() {
		this.state = new State();
		this.game = new Game();
        this.controllers = new HashMap<StateValue, Controller>();
		this.startController = new StartController(this.state, this.game);
		this.playController = new PlayController(this.state, this.game);
		this.resumeController = new ResumeController(this.state, this.game);
		this.controllers.put(StateValue.INITIAL, this.startController);
		this.controllers.put(StateValue.IN_GAME, this.playController);
		this.controllers.put(StateValue.FINAL, this.resumeController);
		this.controllers.put(StateValue.EXIT, null);
	}

	public Controller getController() {
		return this.controllers.get(this.state.getValueState());
    }

}
