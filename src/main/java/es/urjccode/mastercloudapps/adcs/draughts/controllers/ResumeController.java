package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Session;

public class ResumeController extends Controller {

	private Session session;

	public ResumeController(Session session) {
		super(session.state, session.game);
		this.session = session;
    }
    
    @Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

	public void next() {
        this.session.state.next();
	}

	public void reset() {
        this.session.state.reset();
	}

}
