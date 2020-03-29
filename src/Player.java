/**
 * Player class
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Player {
    private int sunflower;
    private ArrayList<Entitas> container;
    private int turn;
    private char[][] map;

    Random rand = new Random();

    public Player(){
        this.sunflower = 0;
        this.turn = 0;
        this.container = new ArrayList<Entitas>();
        this.map = new char[7][4];
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
        int type = rand.nextInt(1);
        if (type==0) {
            //TODO            
            //spawn Normal Zombie
        } else {
            //TODO
            //spawn Night Zombie
        }
    }
    public void buyPlant(int choice){
        //TODO
    }
    public void addSunflower(){
        int newSunflower = rand.nextInt((max - min) + 1) + min;
        this.setSunflower(this.getSunflower()+newSunflower);
    }
    public void fillMap(){
        for (Entitas el : container) {
            map[el.getPos().getX()][el.getPos().getY()] = el.getIcon();
        }
    }
    public void showMap(){
        //TODO
    }
}