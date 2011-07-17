package marsrover.app;

public class CoordinatePosition {
    private int x;
    private int y;
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;
    private boolean boundsSet;

    public CoordinatePosition(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public CoordinatePosition goLeft() {
        int tempX = x - 1;
        int tempY = y;
        if (!boundsSet || (boundsSet && isValidMove(tempX, tempY)))
            return new CoordinatePosition(tempX, tempY);
        else
            return this;
    }

    public int getX() {
        return x;
    }

    public CoordinatePosition goRight() {
        int tempX = x + 1;
        int tempY = y;
        if (!boundsSet || (boundsSet && isValidMove(tempX, tempY)))
            return new CoordinatePosition(tempX, tempY);
        else
            return this;
    }

    public int getY() {
        return y;
    }

    public CoordinatePosition goForward() {
        int tempX = x;
        int tempY = y + 1;
        if (!boundsSet || (boundsSet && isValidMove(tempX, tempY)))
            return new CoordinatePosition(tempX, tempY);
        else
            return this;
    }

    public CoordinatePosition goBackward() {
        int tempX = x;
        int tempY = y - 1;
        if (!boundsSet || (boundsSet && isValidMove(tempX, tempY)))
            return new CoordinatePosition(tempX, tempY);
        else
            return this;
    }

    @Deprecated
    public void setBounds(int minX, int minY, int maxX, int maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
        boundsSet = true;
    }

    private boolean isValidMove(int nextX, int nextY) {
        return (nextX >= minX && nextX <= maxX) && (nextY >= minY && nextY <= maxY);
    }

    public boolean equals(Object aPosition){
        CoordinatePosition coordinatePosition = (CoordinatePosition) aPosition;
        return coordinatePosition.getX() == x && coordinatePosition.getY() == y;
    }

    public int hashCode(){

        return x;
    }
            
}
