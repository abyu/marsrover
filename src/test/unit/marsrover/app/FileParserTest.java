package test.unit.marsrover.app;

import marsrover.app.FileParser;
import marsrover.app.InvalidArgumentException;
import marsrover.app.CoordinatePosition;
import marsrover.app.Rover;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
public class FileParserTest {

    private String inputFile = System.getProperty("user.dir")+"/../../data/input1.txt";

    @Test
    public void theUpperCoordinatesFromInputFileIs5And5(){
        FileParser fileParser = new FileParser(inputFile);
        CoordinatePosition position = fileParser.getUpperCoordinates();
        assertThat(position.getX(), is(5));
        assertThat(position.getY(), is(5));
    }


    @Test
    public void theFirstRoverPositionIsOneAndTwoNAndCommandStringIsLMLMLMLMMFromInputFile(){
        FileParser fileParser = new FileParser(inputFile);
        ArrayList<Rover> rovers = fileParser.getRovers();
        assertThat(rovers.get(0).getCurrentPosition().getX(), is(1));
        assertThat(rovers.get(0).getCurrentPosition().getY(), is(2));
        assertThat(rovers.get(0).getCurrentDirection(), is("N"));
        assertThat(rovers.get(0).getCommandString(), is("LMLMLMLMM"));
    }

    @Test
    public void theSecondRoverPositionIsThreeAndThreeEAndCommandStringIsMMRMMRMRRMFromInputFile(){
        FileParser fileParser = new FileParser(inputFile);
        ArrayList<Rover> rovers = fileParser.getRovers();
        assertThat(rovers.get(1).getCurrentPosition().getX(), is(3));
        assertThat(rovers.get(1).getCurrentPosition().getY(), is(3));
        assertThat(rovers.get(1).getCurrentDirection(), is("E"));
        assertThat(rovers.get(1).getCommandString(), is("MMRMMRMRRM"));
    }
    @Test
    public void thereAreTwoRoversFromInputFile(){
        FileParser fileParser = new FileParser(inputFile);
        ArrayList<Rover> rovers = fileParser.getRovers();
        assertThat(rovers.size(), is(2));
    }

    @Test
    public void finalRoverPositionsOfRover1Is1_3_NAndRover2Is5_1_EFromInputFile() throws InvalidArgumentException {
        FileParser fileParser = new FileParser(inputFile);
        ArrayList<Rover> rovers = fileParser.getRovers();
        fileParser.completeNavigation();
        assertThat(rovers.get(0).getCurrentPosition().getX(), is(1));
        assertThat(rovers.get(0).getCurrentPosition().getY(), is(3));
        assertThat(rovers.get(0).getCurrentDirection(), is("N"));
        assertThat(rovers.get(1).getCurrentPosition().getX(), is(5));
        assertThat(rovers.get(1).getCurrentPosition().getY(), is(1));
        assertThat(rovers.get(1).getCurrentDirection(), is("E"));
    }


}
