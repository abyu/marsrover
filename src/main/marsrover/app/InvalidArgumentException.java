package marsrover.app;


public class InvalidArgumentException extends Exception{
    private String errorMessage;

    public InvalidArgumentException(String errorMessage){

        this.errorMessage = errorMessage;
    }
    public String toString(){
        return "Exception Occurred: "+errorMessage;
    }
}
