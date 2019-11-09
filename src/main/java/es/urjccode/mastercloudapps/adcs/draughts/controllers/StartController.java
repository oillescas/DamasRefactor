package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Session;

public class StartController extends Controller {

	private Session session;

	public StartController(Session session) {
		super(session.state, session.game);
		this.session = session;
	}

    @Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
    }

	public void start() {
        this.session.state.next();
	}
    
}
