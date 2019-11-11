package es.urjccode.mastercloudapps.adcs.draughts.models;

abstract class MoveValidator {

    private MoveValidator next;

    abstract Error moveValid(Move move);

    void setNext(MoveValidator next){
        this.next = next;
    }

    MoveValidator getNext(){
        return next;
    }

    Error validNext(Move move){
        if(this.getNext()!=null){
            return this.getNext().moveValid(move);
        }
        return null;
    }
}
