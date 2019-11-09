package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Session {

	public State state;

	public Game game;

	public Session(State state, Game game){
		this.state = state;
		this.game = game;
	}

	

}
