/**
 * InvalidBuyingException
 * @author Muhamad Hudan Widzamil
 */
public class InvalidBuyingException extends Exception {
    public InvalidBuyingException(){
    }
    public String getMessage(){
        return "Sorry, can't buy plant ";
    }
}