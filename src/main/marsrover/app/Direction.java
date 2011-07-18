package marsrover.app;

public interface Direction {
    public CoordinatePosition findForward(CoordinatePosition aPosition);
    public Direction findLeft();
    public Direction findRight();
}
