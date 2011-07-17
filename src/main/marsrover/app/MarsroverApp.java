package marsrover.app;

public class MarsroverApp {

    public static void main(String[] arg){
        if(arg.length < 0){
            System.out.println("Usage: FileParser <input file> ");
            return;
        }
        try {
            FileParser fileParser = new FileParser(arg[0]);
            Navigator navigator = new Navigator(fileParser);
            System.out.println(navigator.getOutput());
        } catch (InvalidArgumentException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
