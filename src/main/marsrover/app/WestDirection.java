package marsrover.app;

/**
 * Created by IntelliJ IDEA.
 * User: kishorek
 * Date: 7/18/11
 * Time: 11:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class WestDirection implements Direction{


    public CoordinatePosition findForward(CoordinatePosition aPosition) {
        return aPosition.goLeft();  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Direction findLeft() {
        return new SouthDirection();  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Direction findRight() {
        return new NorthDirection();  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String toString(){
        return "W";
    }
}
