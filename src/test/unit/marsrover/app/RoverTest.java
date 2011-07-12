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
}
