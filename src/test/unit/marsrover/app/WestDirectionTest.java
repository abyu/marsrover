package marsrover.app;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class WestDirectionTest {

    @Mock
    private CoordinatePosition aPosition;

    private WestDirection west;

    @Before
    public void setUp(){
        initMocks(this);
        west = new WestDirection();
    }

    @Test
    public void turnLeftShouldChangeDirectionToSouth(){
        Direction newDirection = west.findLeft();
        assertTrue(newDirection instanceof SouthDirection);
    }

    @Test
    public void turnRightShouldChangeDirectionToNorth(){
        Direction newDirection = west.findRight();
        assertTrue(newDirection instanceof NorthDirection);
    }

    @Test
    public void moveForwardShouldCallGoLeftOfCoornidatePosition(){
        west.findForward(aPosition);
        verify(aPosition).goLeft();
    }
}

