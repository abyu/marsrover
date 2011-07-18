package marsrover.app;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DirectionFactoryTest {

    @Test
    public void shouldReturnNorthDirectionInstanceWhenDirectionStringIsN() throws InvalidArgumentException {
        Direction north = DirectionFactory.getDirectionInstance("N");
        assertTrue(north instanceof NorthDirection);
    }

    @Test
    public void shouldReturnSouthDirectionInstanceWhenDirectionStringIsS() throws InvalidArgumentException {
        Direction south = DirectionFactory.getDirectionInstance("S");
        assertTrue(south instanceof SouthDirection);
    }

    @Test
    public void shouldReturnEastDirectionInstanceWhenDirectionStringIsE() throws InvalidArgumentException {
        Direction east = DirectionFactory.getDirectionInstance("E");
        assertTrue(east instanceof EastDirection);
    }

    @Test
    public void shouldReturnWestDirectionInstanceWhenDirectionStringIsW() throws InvalidArgumentException {
        Direction west = DirectionFactory.getDirectionInstance("W");
        assertTrue(west instanceof WestDirection);
    }
    
    @Test(expected = InvalidArgumentException.class)
    public void shouldThrowInvalidArgumentExceptionWhenDirectionStringIsInvalid() throws InvalidArgumentException {
        Direction crap = DirectionFactory.getDirectionInstance("Sometext");
    }



}
