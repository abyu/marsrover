package marsrover.app;

public class NorthDirection implements Direction{
    public Direction findLeft() {
        return new WestDirection();  //To change body of created methods use File | Settings | File Templates.
    }

    public Direction findRight() {
        return new EastDirection();  //To change body of created methods use File | Settings | File Templates.
    }

    public CoordinatePosition findForward(CoordinatePosition aPosition) {
        return aPosition.goForward();
    }

    public String toString(){
        return "N";
    }
}

