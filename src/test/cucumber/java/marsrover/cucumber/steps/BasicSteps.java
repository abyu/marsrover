package marsrover.cucumber.steps;

import cuke4duke.annotation.I18n.EN.*;
import marsrover.app.FileParser;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BasicSteps {
    private FileParser fileParser;

    @Given("^I start my application with \"([^\"]*)\" as my input file$")
    public void startApplication(String inputFile) {
        String file = System.getProperty("user.dir")+"/data/"+inputFile+".txt";
        fileParser = new FileParser(file);
    }

    @Then("^I receive the output as in \"([^\"]*)\" file$")
    public void checkOutput(String outputFile) throws Exception {
        String filePath = System.getProperty("user.dir")+"/data/"+outputFile+".txt";
        FileReader file = new FileReader("data/"+outputFile+".txt");
        BufferedReader readFile = new BufferedReader(file);
        String allData = "" ;
        String fileLine =readFile.readLine();
        while(fileLine != null){
            allData += fileLine +"\n";
            fileLine = readFile.readLine();
        }
        assertThat(fileParser.getOutput(), is(allData));
    }
}
