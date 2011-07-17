package marsrover.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class FileParser {
    private String inputFile;
    private BufferedReader bufferedReader;
    private ArrayList<Rover> rovers;
    private CoordinatePosition upperBound;
    public FileParser(String inputFile) {
        this.inputFile = inputFile;
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));
            upperBound = getUpperCoordinates();
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

    public ArrayList<Rover> parseRovers() {
        rovers = new ArrayList<Rover>();
        resetFile();
        readFileLine(); // Ignore First Line
        String fileLine = readFileLine();
        while (fileLine != null) {
            String nextLine = readFileLine();
            if (nextLine != null) {
                try {
                    Plateau plateau = new Plateau(0, 0, upperBound.getX(), upperBound.getY());
                    Rover rover = new Rover(fileLine, nextLine ,plateau);
                    rovers.add(rover);
                } catch (InvalidArgumentException e) {
                    e.printStackTrace();
                }
                fileLine = readFileLine();
            } else {
                break;
            }
        }
        return rovers;
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
