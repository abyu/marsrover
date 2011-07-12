package marsrover.app;


public class Rover {
    private CoordinatePosition currentPosition;

    public Rover(int positionX, int positionY) {
        currentPosition = new CoordinatePosition(positionX, positionY);
    }

    public CoordinatePosition getCurrentPosition() {
        return currentPosition;
    }
}
