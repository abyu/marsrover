package marsrover.app;

import java.util.ArrayList;

public class Navigator {

    private ArrayList<Rover> rovers;
    public Navigator(FileParser fileParser) {
        rovers = fileParser.getRovers();
    }

    public ArrayList<Rover> getRovers() {
        return rovers;
    }

    public void navigateRoversToFinalPosition() throws InvalidArgumentException {
        for(Rover aRover : rovers)
            aRover.navigateToFinal();
    }


    public String getOutput() throws InvalidArgumentException {
        navigateRoversToFinalPosition();
        String output = "";
        for(Rover rover: rovers){
            output += rover.getCurrentPosition().getX()+" "+rover.getCurrentPosition().getY()+" "+rover.getCurrentDirectionString()+"\n";
        }
        return output;
    }
}
