package test.unit.marsrover.app;

import marsrover.app.CoordinatePosition;
import marsrover.app.Marsrover;
import marsrover.app.Rover;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.StringContains.containsString;

public class MarsroverTest {

    private String inputFile = System.getProperty("user.dir")+"/../../data/input1.txt";
    @Test
    public void readALineFromTheInputFile(){
        Marsrover marsrover = new Marsrover(inputFile);
        assertThat(marsrover.readFileLine(), containsString("5 5"));
    }

    @Test
    public void readMoreLinesFromTheInputFile(){
        Marsrover marsrover = new Marsrover(inputFile);
        assertThat(marsrover.readFileLine(), containsString("5 5"));
        assertThat(marsrover.readFileLine(), containsString("1 2 N"));
        assertThat(marsrover.readFileLine(), containsString("LMLMLMLMM"));
    }

    @Test
    public void theUpperCoordinatesFromInputFileIs5And5(){
        Marsrover marsrover = new Marsrover(inputFile);
        CoordinatePosition position = marsrover.getUpperCoordinates();
        assertThat(position.getX(), is(5));
        assertThat(position.getY(), is(5));
    }

    @Test
    public void theFirstRoverPositionIsOneAndTwoAndCommandStringIsLMLMLMLMMFromInputFile(){
        Marsrover marsrover = new Marsrover(inputFile);
        Rover[] rovers = marsrover.getRovers();
        assertThat(rovers[0].getCurrentPosition().getX(), is(1));
        assertThat(rovers[0].getCurrentPosition().getY(), is(2));

    }
}
