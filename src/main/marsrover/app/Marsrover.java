package marsrover.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Marsrover {
    private String inputFile;
    private BufferedReader bufferedReader;

    public Marsrover(String inputFile) {
        //To change body of created methods use File | Settings | File Templates.
        this.inputFile = inputFile;
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public String getOutput() {
        return "";
    }

    public String readFileLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return "";
        }
    }
}
