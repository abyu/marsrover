package test.unit.marsrover.app;

import marsrover.app.CoordinatePosition;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CoordinatePositionTest {

    @Test
    public void goLeftOfPositionThreeAndTwoIsTwoAndTwo(){
        CoordinatePosition threeTwo = new CoordinatePosition(3,2);
        CoordinatePosition twoTwo = threeTwo.goLeft();
        assertThat(twoTwo.getX(), is(2));
    }

    @Test
    public void goLeftOfPositionTwoAndTwoIsOneAndTwo(){
        CoordinatePosition twoTwo = new CoordinatePosition(2,2);
        CoordinatePosition oneTwo = twoTwo.goLeft();
        assertThat(oneTwo.getX(), is(1));
    }

    @Test
    public void goRightOfPositionThreeAndTwoIsFourAndTwo(){
        CoordinatePosition threeTwo = new CoordinatePosition(3,2);
        CoordinatePosition fourTwo = threeTwo.goRight();
        assertThat(fourTwo.getX(), is(4));
    }

    @Test
    public void goRightOfPositionFiveAndTwoIsSixAndTwo(){
        CoordinatePosition fiveTwo = new CoordinatePosition(5,2);
        CoordinatePosition sixTwo = fiveTwo.goRight();
        assertThat(sixTwo.getX(), is(6));
    }

}
