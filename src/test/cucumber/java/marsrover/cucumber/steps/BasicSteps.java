package marsrover.cucumber.steps;

import cuke4duke.annotation.I18n.EN.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.matchers.JUnitMatchers.containsString;

public class BasicSteps {
    private Marsrover marsrover;

    @Given("^I start my application with \"([^\"]*)\" as my input file$")
    public void startApplication(String inputFile) {
        marsrover = new Marsrover(inputFile);
    }

    @Then("^I receive the output as in \"([^\"]*)\" file$")
    public void checkOutput(String outputFile) throws IOException {
        FileReader file = new FileReader(outputFile);
        BufferedReader readFile = new BufferedReader(file);
        assertThat(marsrover.getOutput(), containsString(readFile.readLine()));
    }
}
