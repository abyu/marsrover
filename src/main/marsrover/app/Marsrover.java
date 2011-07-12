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
    private ArrayList<Rover> rovers;

    public Marsrover(String inputFile) {
        this.inputFile = inputFile;
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));
            parseRovers();
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public CoordinatePosition getUpperCoordinates() {
        int tempX = 0;
        int tempY = 0;
        try {
            resetFile();
            String[] coordinateString = readFileLine().split(" ");
            tempX = Integer.parseInt(coordinateString[0]);
            tempY = Integer.parseInt(coordinateString[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new CoordinatePosition(tempX, tempY);
    }


    public ArrayList<Rover> getRovers() {
        return rovers;
    }

    public void completeNavigation() throws InvalidArgumentException {
        for (Rover rover : rovers)
            rover.navigateToFinal();
    }


    public String getOutput() {
        return "";
    }

    private void parseRovers() {
        rovers = new ArrayList<Rover>();
        resetFile();
        readFileLine(); // Ignore First Line
        String fileLine = readFileLine();
        while (fileLine != null) {
            String nextLine = readFileLine();
            if (nextLine != null) {
                try {
                    rovers.add(new Rover(fileLine, nextLine));
                } catch (InvalidArgumentException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                fileLine = readFileLine();
            } else {
                break;
            }
        }
    }

    private String readFileLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return "";
        }
    }

    private void resetFile() {
        try {
            bufferedReader.close();
            bufferedReader = new BufferedReader(new FileReader(inputFile));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
