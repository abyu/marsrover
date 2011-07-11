package test.unit.marsrover.app;

import marsrover.app.Marsrover;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.StringContains.containsString;

public class MarsroverTest {

    private String inputFile = System.getProperty("user.dir")+"/../../data/input1.txt";
    @Test
    public void readALineFromTheInputFile(){
        Marsrover marsrover = new Marsrover(inputFile);
        assertThat(marsrover.readFileLine(), containsString("5 5"));
    }

    @Test
    public void readMoreLinesFromTheInputFile(){
        Marsrover marsrover = new Marsrover(inputFile);
        assertThat(marsrover.readFileLine(), containsString("5 5"));
        assertThat(marsrover.readFileLine(), containsString("1 2 N"));
        assertThat(marsrover.readFileLine(), containsString("LMLMLMLMM"));
    }
}
