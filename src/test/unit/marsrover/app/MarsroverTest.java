package test.unit.marsrover.app;

import com.sun.javaws.exceptions.InvalidArgumentException;
import cuke4duke.annotation.Before;
import marsrover.app.CoordinatePosition;
import marsrover.app.Marsrover;
import marsrover.app.Rover;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.StringContains.containsString;
public class MarsroverTest {

    private String inputFile = System.getProperty("user.dir")+"/../../data/input1.txt";

    @Test
    public void theUpperCoordinatesFromInputFileIs5And5(){
        Marsrover marsrover = new Marsrover(inputFile);
        CoordinatePosition position = marsrover.getUpperCoordinates();
        assertThat(position.getX(), is(5));
        assertThat(position.getY(), is(5));
    }


    @Test
    public void theFirstRoverPositionIsOneAndTwoNAndCommandStringIsLMLMLMLMMFromInputFile(){
        Marsrover marsrover = new Marsrover(inputFile);
        ArrayList<Rover> rovers = marsrover.getRovers();
        assertThat(rovers.get(0).getCurrentPosition().getX(), is(1));
        assertThat(rovers.get(0).getCurrentPosition().getY(), is(2));
        assertThat(rovers.get(0).getCurrentDirection(), is("N"));
        assertThat(rovers.get(0).getCommandString(), is("LMLMLMLMM"));
    }

    @Test
    public void theSecondRoverPositionIsThreeAndThreeEAndCommandStringIsMMRMMRMRRMFromInputFile(){
        Marsrover marsrover = new Marsrover(inputFile);
        ArrayList<Rover> rovers = marsrover.getRovers();
        assertThat(rovers.get(1).getCurrentPosition().getX(), is(3));
        assertThat(rovers.get(1).getCurrentPosition().getY(), is(3));
        assertThat(rovers.get(1).getCurrentDirection(), is("E"));
        assertThat(rovers.get(1).getCommandString(), is("MMRMMRMRRM"));
    }
    @Test
    public void thereAreTwoRoversFromInputFile(){
        Marsrover marsrover = new Marsrover(inputFile);
        ArrayList<Rover> rovers = marsrover.getRovers();
        assertThat(rovers.size(), is(2));
    }

    @Test
    public void finalRoverPositionsOfRover1Is1_3_NAndRover2Is5_1_EFromInputFile() throws InvalidArgumentException {
        Marsrover marsrover = new Marsrover(inputFile);
        ArrayList<Rover> rovers = marsrover.getRovers();
        marsrover.completeNavigation();
        assertThat(rovers.get(0).getCurrentPosition().getX(), is(1));
        assertThat(rovers.get(0).getCurrentPosition().getY(), is(3));
        assertThat(rovers.get(0).getCurrentDirection(), is("N"));
        assertThat(rovers.get(1).getCurrentPosition().getX(), is(5));
        assertThat(rovers.get(1).getCurrentPosition().getY(), is(1));
        assertThat(rovers.get(1).getCurrentDirection(), is("E"));
    }


}
