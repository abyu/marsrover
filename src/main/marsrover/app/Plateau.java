package marsrover.app;

import java.util.ArrayList;

public class Plateau {
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;
    private ArrayList<CoordinatePosition> blockedPositions;

    public Plateau(int minx, int minY, int maxX, int maxY) {
        this.minX = minx;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
        blockedPositions = new ArrayList<CoordinatePosition>();
    }

    public int getMinX() {
        return minX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxX() {
        return maxX;  //To change body of created methods use File | Settings | File Templates.
    }

    public int getMaxY() {
        return maxY;
    }

    public void blockPosition(CoordinatePosition blockedPosition) {
        if(isValid(blockedPosition))
            blockedPositions.add(blockedPosition);
    }

    public boolean isBlocked(CoordinatePosition coordinatePosition) {
        return blockedPositions.contains(coordinatePosition);  //To change body of created methods use File | Settings | File Templates.
    }

    public boolean isValid(CoordinatePosition coordinatePosition) {
        int x = coordinatePosition.getX();
        int y = coordinatePosition.getY();
        boolean validX = (x >= minX && x <= maxX);
        boolean validY = (y >= minY && y <= maxY);
        return validX && validY;  //To change body of created methods use File | Settings | File Templates.
    }
}
