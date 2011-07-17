package marsrover.app;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class NavigatorTest {

    @Mock
    private FileParser fileParser;

    @Before
    public void setUp(){
       initMocks(this);
    }

    @Test
    public void shouldNavigateTheRoversToFinalPosition() throws InvalidArgumentException {
        ArrayList<Rover> rovers = new ArrayList<Rover>();
        rovers.add(new Rover("1 2 N","LMLMLMLMM", new Plateau(0,0,5,5)));
        rovers.add(new Rover("3 3 E","MMRMMRMRRM", new Plateau(0,0,5,5)));
        when(fileParser.getRovers()).thenReturn(rovers);
        Navigator navigator = new Navigator(fileParser);
        rovers = navigator.getRovers();
        navigator.navigateRoversToFinalPosition();
        assertThat(rovers.get(0).getCurrentPosition(), is(new CoordinatePosition(1, 3)));
        assertThat(rovers.get(0).getCurrentDirection(), is("N"));
        assertThat(rovers.get(1).getCurrentPosition(), is(new CoordinatePosition(5,1)));
        assertThat(rovers.get(1).getCurrentDirection(), is("E"));
    }

    @Test
    public void shouldReturnAStringContainingFinalPositionsOfRovers() throws InvalidArgumentException {
        ArrayList<Rover> rovers = new ArrayList<Rover>();
        rovers.add(new Rover("1 2 N","LMLMLMLMM", new Plateau(0,0,5,5)));
        rovers.add(new Rover("3 3 E","MMRMMRMRRM", new Plateau(0,0,5,5)));
        when(fileParser.getRovers()).thenReturn(rovers);
        Navigator navigator = new Navigator(fileParser);
        rovers = navigator.getRovers();
        navigator.navigateRoversToFinalPosition();
        String finalString = "1 3 N\n" +
                "5 1 E\n";
        assertThat(navigator.getOutput(), is(finalString));
    }

}
