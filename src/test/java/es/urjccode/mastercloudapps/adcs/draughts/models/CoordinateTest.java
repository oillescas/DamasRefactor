package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CoordinateTest {

    @Test
    public void testGivenTwoCoordinatesWhenBettweenDiagonalThenOk() {
        assertEquals(new Coordinate(1, 1), new Move(new Coordinate(2, 2),new Coordinate(0, 0)).betweenDiagonal());
        assertEquals(new Coordinate(3, 1), new Move(new Coordinate(2, 2),new Coordinate(4, 0)).betweenDiagonal());
        assertEquals(new Coordinate(3, 3), new Move(new Coordinate(2, 2),new Coordinate(4, 4)).betweenDiagonal());
        assertEquals(new Coordinate(1, 3), new Move(new Coordinate(2, 2),new Coordinate(0, 4)).betweenDiagonal());
    }

    @Test
    public void testGivenTwoCoordinatesWhenGetDistanceThenResult() {
        assertEquals(3, new Move(new Coordinate(3, 4),new Coordinate(0, 7) ).diagonalDistance() );
    }

}