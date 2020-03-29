/**
 * Player class
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    private int sunflower;
    private ArrayList<Entitas> container;
    private int turn;

    public Player(){
        this.sunflower = 0;
        this.turn = 0;
        this.container = new ArrayList<Entitas>();
    };

    public void setSunflower(int newSunflower){
        this.sunflower = newSunflower;
    }

    public int getSunflower(){
        return this.sunflower;
    }
    public int getTurn(){
        return this.turn;
    }

    public void spawnZombie(){
        //TODO
    }
    public void buyPlant(){
        //TODO
    }
    public void addSunflower(){
        //TODO
    }
    
}