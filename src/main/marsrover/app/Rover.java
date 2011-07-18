package marsrover.app;

public class Rover {
    private CoordinatePosition currentPosition;
    private String commandString;
    private int executed;
    private Plateau plateau;
    private Direction currentDirection;

    public Rover(int positionX, int positionY) {
        currentPosition = new CoordinatePosition(positionX, positionY);
    }

    public Rover(String positionString, String commandString) throws InvalidArgumentException {
        this(positionString);
        this.commandString = commandString;
        plateau = new Plateau(0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public Rover(String positionString) throws InvalidArgumentException {
        String[] separated = positionString.split(" ");
        try {
            currentPosition = new CoordinatePosition(Integer.parseInt(separated[0]), Integer.parseInt(separated[1]));
            currentDirection = DirectionFactory.getDirectionInstance(separated[2]);
        }catch (InvalidArgumentException e){
            throw e;
        }
        catch (NumberFormatException e) {
            throw new InvalidArgumentException("Invalid Argument for positionString");
        }
    }

    public Rover(String positionString, String commandString, Plateau plateau) throws InvalidArgumentException {
        this(positionString, commandString);
        this.plateau = plateau;
    }

    public CoordinatePosition getCurrentPosition() {
        return currentPosition;
    }

    public String getCommandString() {
        return commandString;
    }

    public String getCurrentDirectionString() {
        return currentDirection.toString();
    }

    public void navigateToFinal() throws InvalidArgumentException {
        while(executed < commandString.length())
            step();
    }

    public void moveForward() {
        CoordinatePosition newPosition;
        newPosition = currentDirection.findForward(currentPosition);
        if(plateau.isValid(newPosition))
            currentPosition = newPosition;
    }

    public void turnLeft() {
        currentDirection = currentDirection.findLeft();
    }

    public void turnRight() {
        currentDirection = currentDirection.findRight();
    }

    public void step() throws InvalidArgumentException {
        if(commandString.charAt(executed) == 'M')
            moveForward();
        else if(commandString.charAt(executed) == 'L')
            turnLeft();
        else if(commandString.charAt(executed) == 'R')
            turnRight();
        else{
            executed = commandString.length();
            throw new InvalidArgumentException("The Instruction was Invalid");
        }
        executed++;
    }
}
