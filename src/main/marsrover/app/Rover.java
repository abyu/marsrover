package marsrover.app;


import com.sun.javaws.exceptions.InvalidArgumentException;

public class Rover {
    private CoordinatePosition currentPosition;
    private String commandString;
    private String currentDirection;

    public Rover(int positionX, int positionY) {
        currentPosition = new CoordinatePosition(positionX, positionY);
    }

    public Rover(String positionString, String commandString) throws InvalidArgumentException {
        this(positionString);
        this.commandString = commandString;
    }

    public Rover(String positionString) throws InvalidArgumentException {
        String[] separated = positionString.split(" ");
        try {
            currentPosition = new CoordinatePosition(Integer.parseInt(separated[0]), Integer.parseInt(separated[1]));
            currentDirection = separated[2];
        } catch (Exception e) {
            throw new InvalidArgumentException(new String[]{"Invalid Argument for positionString", positionString});
        }
    }

    public CoordinatePosition getCurrentPosition() {
        return currentPosition;
    }

    public String getCommandString() {
        return commandString;
    }

    public String getCurrentDirection() {
        return currentDirection;
    }
}
