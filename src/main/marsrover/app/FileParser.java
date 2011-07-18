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
    private Plateau plateau;
    private CoordinatePosition upperBound;
    public FileParser(String inputFile) {
        this.inputFile = inputFile;
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));
            upperBound = getUpperCoordinates();
            plateau = new Plateau(0, 0, upperBound.getX(), upperBound.getY());
            parseRovers();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    protected CoordinatePosition getUpperCoordinates() {
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

    public Plateau getPlateau(){
        return plateau;
    }

    public ArrayList<Rover> getRovers() {
        return rovers;
    }

    public ArrayList<Rover> parseRovers() throws InvalidArgumentException {
        rovers = new ArrayList<Rover>();
        resetFile();
        readFileLine(); // Ignore First Line
        String fileLine = readFileLine();
        while (fileLine != null) {
            String nextLine = readFileLine();
            if (nextLine != null) {
                rovers.add(createRover(fileLine, nextLine));
                fileLine = readFileLine();
            } else {
                break;
            }
        }
        return rovers;
    }

    private Rover createRover(String fileLine, String nextLine) throws InvalidArgumentException {
        Rover rover = new Rover(fileLine, nextLine ,plateau);
        return rover;
    }

    private String readFileLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
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
