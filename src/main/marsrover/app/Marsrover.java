package marsrover.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Marsrover {
    private String inputFile;
    private BufferedReader bufferedReader;

    public Marsrover(String inputFile) {
        this.inputFile = inputFile;
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public String readFileLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return "";
        }
    }

    public String getOutput() {
        return "";
    }

    public CoordinatePosition getUpperCoordinates() {
        int tempX = 0;
        int tempY = 0;
        try{
            resetFile();
            String[] coordinateString = readFileLine().split(" ");
            tempX = Integer.parseInt(coordinateString[0]);
            tempY = Integer.parseInt(coordinateString[1]);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new CoordinatePosition(tempX, tempY);
    }

    private void resetFile(){
        try {
            bufferedReader.close();
            bufferedReader = new BufferedReader(new FileReader(inputFile));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public Rover[] getRovers() {
        return new Rover[0];  //To change body of created methods use File | Settings | File Templates.
    }
}
