package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Move {
	 
	public Coordinate origin;

    public Coordinate target;

    public Move(Coordinate origin, Coordinate target) {
        this.origin = origin;
        this.target = target;
    }
    
    @Override
    public boolean equals(Object obj) {
    	if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Move other = (Move) obj;
        if(!this.origin.equals(other.origin)) {
        	return false;
        }
        if(!this.target.equals(other.target)) {
        	return false;
        }
        return true;
    	
    }
}
