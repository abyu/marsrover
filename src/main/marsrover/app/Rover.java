package marsrover.app;


import com.sun.javaws.exceptions.InvalidArgumentException;

public class Rover {
    private CoordinatePosition currentPosition;
    private String commandString;
    private String currentDirection;
    private int executed;
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

    public void navigateToFinal() {

    }

    public void moveForward() {
        if(currentDirection.equals("N")){
            currentPosition = currentPosition.goForward();
        }
        if(currentDirection.equals("S")){
            currentPosition = currentPosition.goBackward();
        }
        if(currentDirection.equals("W")){
            currentPosition = currentPosition.goLeft();
        }
        if(currentDirection.equals("E")){
            currentPosition = currentPosition.goRight();
        }
    }

    public void turnLeft() {
        if(currentDirection.equals("N")){
            currentDirection = "W";
            return;
        }
        if(currentDirection.equals("S")){
            currentDirection = "E";
            return;
        }
        if(currentDirection.equals("W")){
            currentDirection = "S";
            return;
        }
        if(currentDirection.equals("E")){
            currentDirection = "N";
        }
    }

    public void turnRight() {
        if(currentDirection.equals("N")){
            currentDirection = "E";
            return;
        }
        if(currentDirection.equals("S")){
            currentDirection = "W";
            return;
        }
        if(currentDirection.equals("W")){
            currentDirection = "N";
            return;
        }
        if(currentDirection.equals("E")){
            currentDirection = "S";
            return;
        }
    }

    public void step() {
        if(commandString.charAt(executed) == 'M')
            moveForward();
        if(commandString.charAt(executed) == 'L')
            turnLeft();
        if(commandString.charAt(executed) == 'R')
            turnRight();
        executed++;
    }
}
