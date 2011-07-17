package test.unit.marsrover.app;

import marsrover.app.CoordinatePosition;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
    
    @Test
    public void goForwardOfPositionTwoAndTwoIsTwoAndThree(){
        CoordinatePosition twoTwo = new CoordinatePosition(2,2);
        CoordinatePosition twoThree = twoTwo.goForward();
        assertThat(twoThree.getY(), is(3));
    }

    @Test
    public void goForwardOfPositionTwoAndFiveIsTwoAndSix(){
        CoordinatePosition twoFive = new CoordinatePosition(2,5);
        CoordinatePosition twoSix  =  twoFive.goForward();
        assertThat(twoSix.getY(), is(6));
    }

    @Test
    public void goBackwardOfPositionTwoAndTwoIsTwoAndOne(){
        CoordinatePosition twoTwo = new CoordinatePosition(2,2);
        CoordinatePosition twoOne = twoTwo.goBackward();
        assertThat(twoOne.getY() , is(1));
    }
    @Test
    public void goBackwardOfPositionTwoAndFiveIsTwoAndFour(){
        CoordinatePosition twoFive = new CoordinatePosition(2,5);
        CoordinatePosition twoFour = twoFive.goBackward();
        assertThat(twoFour.getY() , is(4));
    }

    @Test
    public void doesNotCrossTheTopBoundaryWhenMoveForwardFromTheTopMostPoint(){
        CoordinatePosition fiveFive = new CoordinatePosition(5 ,5);
        fiveFive.setBounds(0,0,5,5);
        CoordinatePosition same = fiveFive.goForward();
        assertThat(same.getX(), is(5));
        assertThat(same.getY(), is(5));
    }

    @Test
    public void doesNotCrossTheBottomBoundaryWhenMoveBackwardFromTheBottomMostPoint(){
        CoordinatePosition zeroZero = new CoordinatePosition(0 ,0);
        zeroZero.setBounds(0,0,5,5);
        CoordinatePosition same = zeroZero.goBackward();
        assertThat(same.getX(), is(0));
        assertThat(same.getY(), is(0));
    }

    @Test
    public void doesNotCrossTheLeftBoundaryWhenMoveLeftFromTheLeftMostPoint(){
        CoordinatePosition zeroOne = new CoordinatePosition(0 ,1);
        zeroOne.setBounds(0,0,5,5);
        CoordinatePosition same = zeroOne.goLeft();
        assertThat(same.getX(), is(0));
        assertThat(same.getY(), is(1));
    }

    @Test
    public void doesNotCrossTheRightBoundaryWhenMoveRightFromTheRighttMostPoint(){
        CoordinatePosition zeroOne = new CoordinatePosition(5 ,1);
        zeroOne.setBounds(0,0,5,5);
        CoordinatePosition same = zeroOne.goRight();
        assertThat(same.getX(), is(5));
        assertThat(same.getY(), is(1));
    }

    @Test
    public void twoCoordinatePositionsAreEqualIfTheXandYAreEqual(){
        CoordinatePosition coordinatePosition1 = new CoordinatePosition(1, 2);
        CoordinatePosition samePosition = new CoordinatePosition(1 ,2);
        assertTrue(coordinatePosition1.equals(samePosition));

    }
}
