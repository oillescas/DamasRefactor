package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.StartController;

public class StartView extends SubView {

    public StartView(){
        super();
    }

    public void interact(StartController startController) {
        this.console.writeln(Message.TITTLE.getMessage());
        new GameView().write(startController);
        startController.start();
    }
}
