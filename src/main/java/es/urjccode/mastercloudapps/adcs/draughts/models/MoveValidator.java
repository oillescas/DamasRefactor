package es.urjccode.mastercloudapps.adcs.draughts.models;

abstract class MoveValidator {

    private MoveValidator next;

    abstract Error moveValid(Coordinate origin, Coordinate target);

    void setNext(MoveValidator next){
        this.next = next;
    }

    MoveValidator getNext(){
        return next;
    }

    Error validNext(Coordinate origin, Coordinate target){
        if(this.getNext()!=null){
            return this.getNext().moveValid(origin, target);
        }
        return null;
    }
}
