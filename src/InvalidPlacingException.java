/**
 * InvalidPlacingException
 * @author Muhamad Hudan Widzamil
 */
public class InvalidPlacingException extends Exception {
    private Entitas entitas;
    public InvalidInputCarException(Entitas entitas){
        this.entitas = entitas;
    }
    public String getMessage(){
        return "Sorry, can't place "+entitas.getType();
    }
}