package marsrover.app;


public class EastDirection implements Direction{


    public CoordinatePosition findForward(CoordinatePosition aPosition) {
        return aPosition.goRight();  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Direction findLeft() {
        return new NorthDirection();  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Direction findRight() {
        return new SouthDirection();  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String toString(){
        return "E";
    }
}
