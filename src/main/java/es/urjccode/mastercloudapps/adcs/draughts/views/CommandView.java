package es.urjccode.mastercloudapps.adcs.draughts.views;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class CommandView extends SubView {

    private static final String REGEX = "(\\d\\d)[\\.\\,](\\d\\d)";
    private static final Pattern pattern = Pattern.compile(REGEX);

    private static final String[] COLORS = {"blancas", "negras"};

    private static final int ORIGIN_GROUP = 1;
    private static final int TARGET_GROUP = 2;

    private static final String MESSAGE = "Derrota!!! No puedes mover tus fichas!!!";

    public CommandView(){
        super();
    }

    public void interact(PlayController playController) {
        String color = CommandView.COLORS[playController.getColor().ordinal()];
        Error error = null;
        GameView gameView = new GameView();
        do {
            String command = this.console.readString("Mueven las " + color + ": ");
            Matcher matcher = CommandView.pattern.matcher(command);
            
            if(matcher.find()){
                int origin = Integer.parseInt(matcher.group(ORIGIN_GROUP));
                int target = Integer.parseInt(matcher.group(TARGET_GROUP));
                error = playController.move(new Coordinate(origin/10-1, origin%10-1), new Coordinate(target/10-1, target%10-1));   
            } else {
                error = Error.NOT_UNDERSTAND;
            }
            if (error != null){
                console.writeln("Error!!!" + error.name());
            }
            gameView.write(playController);
        } while (error != null); 
        if (playController.isBlocked()){
            this.console.write(CommandView.MESSAGE);
        }
    }

}