package marsrover.app;

public class CoordinatePosition {
    private int x;
    private int y;

    public CoordinatePosition(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public CoordinatePosition goLeft() {
        int tempX = x - 1;
        int tempY = y;
        return new CoordinatePosition(tempX,tempY);
    }


    public int getX() {
        return x;
    }

    public CoordinatePosition goRight() {
        int tempX = x + 1;
        int tempY = y;
        return new CoordinatePosition(tempX,tempY);
    }

    public int getY() {
        return y;
    }

    public CoordinatePosition goForward() {
        int tempX = x;
        int tempY = y + 1;
        return new CoordinatePosition(tempX,tempY);
    }

    public CoordinatePosition goBackward() {
        int tempX = x;
        int tempY = y - 1;
        return new CoordinatePosition(tempX,tempY);
    }
}
