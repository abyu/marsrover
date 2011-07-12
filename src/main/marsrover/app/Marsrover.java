package marsrover.app;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


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

    public ArrayList<Rover> getRovers() {
        ArrayList<Rover> rovers = new ArrayList<Rover>();
        resetFile();
        readFileLine(); // Ignore First Line
        String fileLine = readFileLine();
        while(fileLine != null){
            String nextLine = readFileLine();
            if(nextLine != null){
                try {
                    rovers.add(new Rover(fileLine, nextLine));
                } catch (InvalidArgumentException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                fileLine = readFileLine();
            }else{
                break;
            }
        }
        return rovers;  //To change body of created methods use File | Settings | File Templates.
    }

    private void resetFile(){
        try {
            bufferedReader.close();
            bufferedReader = new BufferedReader(new FileReader(inputFile));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void completeNavigation() {
        ArrayList<Rover> rovers = getRovers();
        for(Rover rover:rovers)
            rover.navigateToFinal();
    }
}
