package es.urjccode.mastercloudapps.adcs.draughts.views;

public enum Message {
    GAME_OVER("Derrota!!! No puedes mover tus fichas!!!"),
    NEXT_MOVE("Mueven las %s: "),
    ERROR("Error!!! %s"), 
    TITTLE("Draughts"), 
    RESSUME("¿Queréis jugar otra"), 
    WHITE_PIECE("b"), 
    BLACK_PIECE("n"), 
    EMPTY_PIECE(" "), 
    WHITE_TURN("blancas"),
    BLACK_TURN("negras");


	private String message;

	private Message(String message) {
		this.message = message;
    }

    public String getMessage(){
        return message;
    }
    


}