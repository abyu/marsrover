package marsrover.app;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class SouthDirectionTest {

    @Mock
    public CoordinatePosition aPosition;

    private SouthDirection south;

    @Before
    public void setUp(){
        initMocks(this);
        south = new SouthDirection();
    }
    @Test
    public void turnLeftShouldChangeDirectionToEast(){
        Direction newDirection = south.findLeft();
        assertTrue(newDirection instanceof EastDirection);
    }

    @Test
    public void turnRightShouldChangeDirectionToWest(){
        Direction newDirection = south.findRight();
        assertTrue(newDirection instanceof WestDirection);
    }

    @Test
    public void moveForwardShouldCallGoBackwardOfCoordinatePosition(){
        south.findForward(aPosition);
        verify(aPosition).goBackward();
    }
}
