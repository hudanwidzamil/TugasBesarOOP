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
        this.map = new char[4][7];
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
        int y = rand.nextInt(3);
        Point pos = new Point(6, y);
        if (type==0) {
            //TODO            
            //spawn Normal Zombie
            Zombie z = new NormalZombie(pos);
            container.add(z);
        } else {
            //TODO
            //spawn Night Zombie
            Zombie z = new NightZombie(pos);
            container.add(z);
        }
    }
    public void buyPlant(int choice, int x, int y){
        //TODO
        Point pos = new Point(x, y);
        if (choice == 1) {
            Plant p = new Peashooter(x, y);
            container.add(p);
        }
        if (choice == 2) {
            Plant p = new Peashooter(x, y);
            container.add(p);
        }
    }
    public void addSunflower(){
        int newSunflower = rand.nextInt((max - min) + 1) + min;
        this.setSunflower(this.getSunflower()+newSunflower);
    }
    public void fillMap(){
        for (Entitas el : container) {
            map[el.getPos().getY()][el.getPos().getX()] = el.getIcon();
        }
    }
    public void showMap(){
        //TODO
        for (int j = 0, j < 7, j++) {
            System.out.print(map[0][j]);
            System.out.print(" ");
        }
        System.out.println(" ");
        for (int j = 0, j < 7, j++) {
            System.out.print(map[1][j]);
            System.out.print(" ");
        }
        System.out.println(" ");
        for (int j = 0, j < 7, j++) {
            System.out.print(map[2][j]);
            System.out.print(" ");
        }
        System.out.println(" ");
        for (int j = 0, j < 7, j++) {
            System.out.print(map[3][j]);
            System.out.print(" ");
        }
    }
}