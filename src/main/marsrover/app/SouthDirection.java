package marsrover.app;

public class SouthDirection implements Direction{

    public CoordinatePosition findForward(CoordinatePosition aPosition) {
        return aPosition.goBackward();
    }

    public Direction findLeft() {
        return new EastDirection();
    }

    public Direction findRight() {
        return new WestDirection();  
    }

    public String toString(){
        return "S";
    }
}
