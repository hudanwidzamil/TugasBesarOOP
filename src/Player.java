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
        this.map = new char[4][9];
    }

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
        int type = rand.nextInt(10);
        int y = rand.nextInt(3);
        Point pos = new Point(8, y);
        boolean canplace = true;
        Zombie z;

        if (type % 2 == 0) {         
            //spawn Normal Zombie
            z = new NormalZombie(pos);
        } else {
            //spawn Night Zombie
            z = new NightZombie(pos);
        }

        for (Entitas el : container) {
            if (el.collideWith(z)) {
                canplace = false;
            }
        }

        if (canplace == true) {
            container.add(z);
        }
    }

    public void buyPlant(int choice, int x, int y){
        boolean canplace = true;
        Point pos = new Point(x, y);
        Plant p;

        if (choice == 1) {
            p = new Peashooter(pos);
        }
        else {
            p = new Fumeshroom(pos);
        }

        for (Entitas el : container) {
            if (el.collideWith(p)) {
                canplace = false;
            }
        }

        if (canplace == false) {
            System.out.println("Sorry, can't place there");
        }
        else {
            if (this.sunflower >= p.price) {
                container.add(p);
                this.sunflower = this.sunflower - p.price;
            }
            else {
                System.out.println("Sorry, can't buy plant");
            }
        }
    }

    public void addSunflower(){
        int newSunflower = rand.nextInt((15 - 5) + 1) + 5;
        this.setSunflower(this.getSunflower()+newSunflower);
    }

    public void fillMap(){
        for (Entitas el : container) {
            map[el.getPos().getY()][el.getPos().getX()] = el.getIcon();
        }
    }
    
    public void showMap(){
        System.out.println("Sun = " + this.getSunflower());
        this.fillMap();
        System.out.println("******************************************************************");
        for (int j = 0; j < 9; j++) {
            System.out.print(map[0][j] + "\t");
        }
        System.out.println("\n");
        System.out.println("******************************************************************");
        for (int j = 0; j < 9; j++) {
            System.out.print(map[1][j] + "\t");
        }
        System.out.println("\n");
        System.out.println("******************************************************************");
        for (int j = 0; j < 9; j++) {
            System.out.print(map[2][j] + "\t");
        }
        System.out.println("\n");
        System.out.println("******************************************************************");
        for (int j = 0; j < 9; j++) {
            System.out.print(map[3][j] + "\t");
        }
        System.out.println("\n");
        System.out.println("******************************************************************");
    }
}