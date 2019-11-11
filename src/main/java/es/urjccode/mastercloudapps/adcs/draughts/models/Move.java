package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Move {
	 
	public Coordinate origin;

    public Coordinate target;

    public Move(Coordinate origin, Coordinate target) {
    	assert origin != null && target != null;
        this.origin = origin;
        this.target = target;
    }
    
    public int diagonalDistance() {
        assert target != null && target.isValid();
        assert this.origin.isValid() && this.isDiagonal();
        return Math.abs(this.origin.getRow() - target.getRow());
    }
    
    public Coordinate betweenDiagonal() {
        assert target != null && target.isValid();
        assert this.origin.isValid() && this.diagonalDistance() == 2;
        int rowShift = 1;
        if (target.getRow() - this.origin.getRow() < 0) {
            rowShift = -1;
        }
        int columnShift = 1;
        if (target.getColumn() - this.origin.getColumn() < 0) {
            columnShift = -1;
        }
        return new Coordinate(this.origin.getRow() + rowShift, this.origin.getColumn() + columnShift);
    }
    
    public boolean isDiagonal() {
        assert target != null && target.isValid();
        assert origin.isValid();
        return origin.getRow() + origin.getColumn() == target.getRow() + target.getColumn()
                || origin.getRow() - origin.getColumn() == target.getRow() - target.getColumn();
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
