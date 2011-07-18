package marsrover.app;

public class DirectionFactory {
    public static Direction getDirectionInstance(String directionString) throws InvalidArgumentException {
        if(directionString.equals("S"))
            return new SouthDirection();
        if(directionString.equals("E"))
            return new EastDirection();
        if(directionString.equals("W"))
            return new WestDirection();
        if(directionString.equals("N"))
            return new NorthDirection();
        throw new InvalidArgumentException("The Direction String was invalid");
    }
}
