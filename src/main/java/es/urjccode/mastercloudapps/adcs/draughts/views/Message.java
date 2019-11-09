package es.urjccode.mastercloudapps.adcs.draughts.views;

public enum Message {
    GAME_OVER("Derrota!!! No puedes mover tus fichas!!!"),
    NEXT_MOVE("Mueven las %s: "),
    ERROR("Error!!! %s");


	private String message;

	private Message(String message) {
		this.message = message;
    }

    public String getMessage(){
        return message;
    }
    


}