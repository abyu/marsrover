package test.unit.marsrover.app;


import marsrover.app.CoordinatePosition;
import marsrover.app.Plateau;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlateauTest {
    @Test
    public void createsGridWithBoundaries(){
        Plateau plateau = new Plateau(0,0,5,5);
        assertThat(plateau.getMinX(), is(0));
        assertThat(plateau.getMinY(), is(0));
        assertThat(plateau.getMaxX(), is(5));
        assertThat(plateau.getMaxY(), is(5));
    }

    @Test
    public void shouldBlockAPosition(){
        Plateau plateau = new Plateau(0 ,0, 5,5 );
        CoordinatePosition blockedPosition = new CoordinatePosition(3, 3);
        plateau.blockPosition(blockedPosition);
        assertThat(plateau.isBlocked(blockedPosition), is(true));
    }
    
    @Test
    public void returnsFalseWhenAPositionIsNotInTheBlockedList(){
        Plateau plateau = new Plateau(0 , 0, 5, 5);
        CoordinatePosition notBlocked = new CoordinatePosition(2 ,2);
        assertThat(plateau.isBlocked(notBlocked), is(false));
    }

    @Test
    public void shouldNotBlockAPositionWhenItIsOutOfThePlateau(){
        Plateau plateau = new Plateau(0,0,5,5);
        CoordinatePosition notAValidPosition = new CoordinatePosition(6 ,6);
        plateau.blockPosition(notAValidPosition);
        assertThat(plateau.isBlocked(notAValidPosition), is(false));
    }
    
    @Test
    public void shouldReturnFalseWhenAPositionIsNotValid(){
        Plateau plateau = new Plateau(0, 0,5,5);
        CoordinatePosition coordinatePosition = new CoordinatePosition(6 ,6);
        assertThat(plateau.isValid(coordinatePosition), is(false));
    }

    @Test
    public void shouldReturnTrueWhenAPositionIsValid(){
        Plateau plateau = new Plateau(0, 0,5,5);
        CoordinatePosition coordinatePosition = new CoordinatePosition(3 ,3);
        assertThat(plateau.isValid(coordinatePosition), is(true));
    }
}
