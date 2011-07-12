package marsrover.cucumber.steps;

import cuke4duke.annotation.I18n.EN.*;
import marsrover.app.Marsrover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class BasicSteps {
    private Marsrover marsrover;

    @Given("^I start my application with \"([^\"]*)\" as my input file$")
    public void startApplication(String inputFile) {
        String file = System.getProperty("user.dir")+"/../../data/"+inputFile+".txt";
        marsrover = new Marsrover(file);
    }

    @Then("^I receive the output as in \"([^\"]*)\" file$")
    public void checkOutput(String outputFile) throws IOException {
        String filePath = System.getProperty("user.dir")+"/../../data/"+outputFile+".txt";
        FileReader file = new FileReader("data/"+outputFile+".txt");
        BufferedReader readFile = new BufferedReader(file);
        assertThat(marsrover.getOutput(), containsString(readFile.readLine()));
    }
}
