package test.unit.marsrover.app;

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
}
