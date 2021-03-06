package es.urjccode.mastercloudapps.adcs.draughts.views;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Move;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class CommandView extends SubView {

    private static final String REGEX = "(\\d\\d)[\\.\\,](\\d\\d)";
    private static final Pattern pattern = Pattern.compile(REGEX);

    private static final String[] COLORS = {
        Message.WHITE_TURN.getMessage(), 
        Message.BLACK_TURN.getMessage()
    };

    private static final int ORIGIN_GROUP = 1;
    private static final int TARGET_GROUP = 2;

    public CommandView(){
        super();
    }

    public void interact(PlayController playController) {
        String color = CommandView.COLORS[playController.getColor().ordinal()];
        Error error = null;
        GameView gameView = new GameView();
        do {
            error = readMove(playController, color);
            if (error != null){
                console.writeln(String.format(Message.ERROR.getMessage(), error.name()));
            }
            gameView.write(playController);
        } while (error != null); 
        if (playController.isBlocked()){
            this.console.write(Message.GAME_OVER.getMessage());
        }
    }

    private Error readMove(PlayController playController, String color) {
        Error error;
        String command = this.console.readString(String.format(Message.NEXT_MOVE.getMessage(), color));
        Matcher matcher = CommandView.pattern.matcher(command);
        
        if(matcher.find()){
            error = playController.move(new Move(Coordinate.fromString(matcher.group(ORIGIN_GROUP)),Coordinate.fromString(matcher.group(TARGET_GROUP))));   
        } else {
            error = Error.NOT_UNDERSTAND;
        }
        return error;
    }

}