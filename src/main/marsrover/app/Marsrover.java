package marsrover.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Marsrover {
    private String inputFile;
    private BufferedReader bufferedReader;
    private ArrayList<Rover> rovers;
    private CoordinatePosition upperBound;
    public Marsrover(String inputFile) {
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

    public void completeNavigation() throws InvalidArgumentException {

        for (Rover rover : rovers)
            rover.navigateToFinal();
    }

    public String getOutput() throws InvalidArgumentException {
        completeNavigation();
        String output = "";
        for(Rover rover: rovers){
            output += rover.getCurrentPosition().getX()+" "+rover.getCurrentPosition().getY()+" "+rover.getCurrentDirection()+"\n";
        }
        return output;
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
                    Rover rover = new Rover(fileLine, nextLine);
                    rover.setBounds(0,0,upperBound.getX(),upperBound.getY());
                    rovers.add(rover);
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

    public static void main(String[] arg){
        if(arg.length < 0){
            System.out.println("Usage: Marsrover <input file> ");
            return;
        }

        try {
            Marsrover marsrover = new Marsrover(arg[0]);
            System.out.println(marsrover.getOutput());
        } catch (InvalidArgumentException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
