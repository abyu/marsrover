package marsrover.app;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class EastDirectionTest {
    private EastDirection east;

    @Mock
    private CoordinatePosition aPosition;

    @Before
    public void setUp(){
        initMocks(this);
        east = new EastDirection();
    }
    @Test
    public void turnLeftShouldChangeDirectionToNorth(){
        Direction newDirection = east.findLeft();
        assertTrue(newDirection instanceof NorthDirection);
    }

    @Test
    public void turnRightShouldChangeDirectionToSouth(){
        Direction newDirection = east.findRight();
        assertTrue(newDirection instanceof SouthDirection);
    }

    @Test
    public void moveForwardShouldCallGoRightOfCoordinatePosition(){
        east.findForward(aPosition);
        verify(aPosition).goRight();
    }

}
