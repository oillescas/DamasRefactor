package es.urjccode.mastercloudapps.adcs.draughts.models;

public abstract class MoveValidator {

    private MoveValidator next;

    public abstract Error moveValid(Coordinate origin, Coordinate target);

    public void setNext(MoveValidator next){
        this.next = next;
    }

    public MoveValidator getNext(){
        return next;
    }
}
