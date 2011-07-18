package marsrover.app;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


import static org.junit.Assert.assertTrue;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.Mockito.verify;

public class NorthDirectionTest{

    @Mock
    private CoordinatePosition aPosition;

    private NorthDirection north;

    @Before
    public void setUp(){
        initMocks(this);
        north = new NorthDirection();
    }
    @Test
    public void turnLeftShouldChangeDirectionToWest(){
        Direction newDirection = north.findLeft();
        assertTrue(newDirection instanceof WestDirection);
    }

    @Test
    public void turnRightShouldChangeDirectionToEast(){
        Direction newDirection = north.findRight();
        assertTrue(newDirection instanceof EastDirection);
    }

    @Test
    public void moveForwardShouldCallGoForwardOfCoornidatePosition(){
        north.findForward(aPosition);
        verify(aPosition).goForward();
    }
}