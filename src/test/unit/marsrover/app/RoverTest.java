package test.unit.marsrover.app;

import com.sun.javaws.exceptions.InvalidArgumentException;
import marsrover.app.Rover;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RoverTest {
    @Test
    public void roverCreatedWithPosition1And2ReturnsThePositionXAndYAs1And2(){
        Rover rover = new Rover(1,2);
        assertThat(rover.getCurrentPosition().getX(), is(1));
        assertThat(rover.getCurrentPosition().getY(), is(2));
    }

    @Test
    public void roverCreatedWithPosition3And4ReturnsThePositionXAndYAs3And4(){
        Rover rover = new Rover(3,4);
        assertThat(rover.getCurrentPosition().getX(), is(3));
        assertThat(rover.getCurrentPosition().getY(), is(4));
    }
    
    @Test
    public void positionString1_3_NCreatesRoverWithOneAndThreeAsCurrentPositionAnd_N_AsCurrentDirection() throws InvalidArgumentException {
        Rover rover = new Rover("1 3 N");
        assertThat(rover.getCurrentPosition().getX(), is(1));
        assertThat(rover.getCurrentPosition().getY(), is(3));
        assertThat(rover.getCurrentDirection(), is("N"));
    }

    @Test
    public void throwsAnInvalidArgumentExceptionWhenRoverCreatedWithInvalidPositionString(){
        try{
            Rover rover = new Rover("Invalid");
            throw new AssertionError("Expected an InvalidArgumentException but found none");
        }catch(InvalidArgumentException e){
            //Its fine
        }

    }
    
    @Test
    public void positionStringOf2_3_NAndCommandStringOfMLMLMLMMCreatesRoverWith2And3AsCurrentPositionAnd_N_AsCurrentDirectionWithMLMLMLMMAsCommandString() throws InvalidArgumentException {
        Rover rover = new Rover("2 3 N", "MLMLMLMM");
        assertThat(rover.getCurrentPosition().getX(), is(2));
        assertThat(rover.getCurrentPosition().getY(), is(3));
        assertThat(rover.getCurrentDirection(), is("N"));
        assertThat(rover.getCommandString(), is("MLMLMLMM"));
    }

    @Test
    public void positionOfRoverWhenMovedForwardAt_N_From1_2Is1_3() throws InvalidArgumentException {
        Rover rover = new Rover("1 2 N", "M");
        rover.moveForward();
        assertThat(rover.getCurrentPosition().getY(), is(3));
    }

    @Test
    public void positionOfRoverWhenMovedForwardAt_S_From1_3Is1_2() throws InvalidArgumentException {
        Rover rover = new Rover("1 3 S", "M");
        rover.moveForward();
        assertThat(rover.getCurrentPosition().getY(), is(2));
    }

    @Test
    public void positionOfRoverWhenMovedForwardAt_W_From2_3Is1_3() throws InvalidArgumentException {
        Rover rover = new Rover("2 3 W", "M");
        rover.moveForward();
        assertThat(rover.getCurrentPosition().getX(), is(1));
    }

    @Test
    public void positionOfRoverWhenMoveForwardAt_E_From2_3Is3_3() throws InvalidArgumentException {
        Rover rover = new Rover("2 3 E", "M");
        rover.moveForward();
        assertThat(rover.getCurrentPosition().getX(), is(3));
    }

    @Test
    public void directionOfRoverFrom_N_WhenTurnLeftIs_W() throws InvalidArgumentException {
        Rover rover = new Rover("1 1 N", "L");
        rover.turnLeft();
        assertThat(rover.getCurrentDirection(), is("W"));
    }

    @Test
    public void directionOfRoverFrom_S_WhenTurnLeftIs_E() throws InvalidArgumentException{
        Rover rover = new Rover("1 1 S", "L");
        rover.turnLeft();
        assertThat(rover.getCurrentDirection(), is("E"));
    }

    @Test
    public void directionOfRoverFrom_W_WhenTurnLeftIs_S() throws InvalidArgumentException{
        Rover rover = new Rover("1 1 W", "L");
        rover.turnLeft();
        assertThat(rover.getCurrentDirection(), is("S"));
    }

    @Test
    public void directionOfRoverFrom_E_WhenTurnLeftIs_N() throws InvalidArgumentException{
        Rover rover = new Rover("1 1 E", "L");
        rover.turnLeft();
        assertThat(rover.getCurrentDirection(), is("N"));
    }
    @Test
     public void directionOfRoverFrom_N_WhenTurnRightIs_E() throws InvalidArgumentException {
           Rover rover = new Rover("1 1 N", "R");
           rover.turnRight();
           assertThat(rover.getCurrentDirection(), is("E"));
       }
    @Test
    public void directionOfRoverFrom_S_WhenTurnRightIs_W() throws InvalidArgumentException{
        Rover rover = new Rover("1 1 S", "R");
        rover.turnRight();
        assertThat(rover.getCurrentDirection(), is("W"));
    }

    @Test
    public void directionOfRoverFrom_W_WhenTurnRightIs_N() throws InvalidArgumentException{
        Rover rover = new Rover("1 1 W", "R");
        rover.turnRight();
        assertThat(rover.getCurrentDirection(), is("N"));
    }

    @Test
    public void directionOfRoverFrom_E_WhenTurnRightIs_S() throws InvalidArgumentException{
        Rover rover = new Rover("1 1 E", "R");
        rover.turnRight();
        assertThat(rover.getCurrentDirection(), is("S"));
    }

    @Test
    public void commandStringOfMLOnRoverWith_1_2_NResultsInRoverWithNextPosition_1_3_N() throws InvalidArgumentException {
        Rover rover = new Rover("1 2 N", "ML");
        rover.step();
        assertThat(rover.getCurrentPosition().getX(), is(1));
        assertThat(rover.getCurrentPosition().getY(), is(3));
        assertThat(rover.getCurrentDirection(), is("N"));
    }

    @Test
    public void commandStringOfLLOnRoverWith_1_2_NResultsInRoverWithNextPosition_1_2_W() throws InvalidArgumentException {
        Rover rover = new Rover("1 2 N", "LL");
        rover.step();
        assertThat(rover.getCurrentPosition().getX(), is(1));
        assertThat(rover.getCurrentPosition().getY(), is(2));
        assertThat(rover.getCurrentDirection(), is("W"));
    }

    @Test
    public void commandStringOfRMOnRoverWith_1_2_NResultsInRoverWithNextPosition_1_2_E() throws InvalidArgumentException {
        Rover rover = new Rover("1 2 N", "RM");
        rover.step();
        assertThat(rover.getCurrentPosition().getX(), is(1));
        assertThat(rover.getCurrentPosition().getY(), is(2));
        assertThat(rover.getCurrentDirection(), is("E"));
    }

    @Test
    public void finalPositionOfRoverWith_1_2_NAndCommandStringMRMRMRMIs_1_2_W() throws InvalidArgumentException {
        Rover rover = new Rover("1 2 N", "MRMRMRM");
        rover.navigateToFinal();
        assertThat(rover.getCurrentPosition().getX(), is(1));
        assertThat(rover.getCurrentPosition().getY(), is(2));
        assertThat(rover.getCurrentDirection(), is("W"));
    }

    @Test
    public void finalPositionOfRoverWith_1_2_NAndCommandStringLMLMLMLMMIs_1_3_N() throws InvalidArgumentException {
        Rover rover = new Rover("1 2 N", "LMLMLMLMM");
        rover.navigateToFinal();
        assertThat(rover.getCurrentPosition().getX(), is(1));
        assertThat(rover.getCurrentPosition().getY(), is(3));
        assertThat(rover.getCurrentDirection(), is("N"));
    }

    @Test
    public void finalPositionOfRoverWith_3_3_EAndCommandStringMMRMMRMRRMIs_5_1_E() throws InvalidArgumentException {
        Rover rover = new Rover("3 3 E","MMRMMRMRRM");
        rover.navigateToFinal();
        assertThat(rover.getCurrentPosition().getX(), is(5));
        assertThat(rover.getCurrentPosition().getY(), is(1));
        assertThat(rover.getCurrentDirection(), is("E"));

    }

}