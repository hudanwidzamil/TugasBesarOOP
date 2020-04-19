/**
 * InvalidPlacingException
 * @author Muhamad Hudan Widzamil
 */
public class InvalidPlacingException extends Exception {
    public InvalidPlacingException(){
    }
    public String getMessage(){
        return "Sorry, can't place ";
    }
}