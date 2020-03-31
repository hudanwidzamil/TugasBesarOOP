/**
 * Player class
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator; 

public class Player {
    private int sunflower;
    private ArrayList<Entitas> container;
    private int turn;
    private char[][] map;
    private boolean win = true;
    public static int score = 0;

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
    public void addTurn(){
        this.turn++;
    }
    public int getSunflower(){
        return this.sunflower;
    }
    public int getTurn(){
        return this.turn;
    }
    public boolean getWin(){
        return win;
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
        System.out.println("Ditambahkan "+newSunflower+" sunflower point");
        this.setSunflower(this.getSunflower()+newSunflower);
    }

    public void fillMap(){
        //clear map
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 9; j++) {
                map[i][j] = ' ';
            }
        }

        for (Entitas el : container) {
            map[el.getPos().getY()][el.getPos().getX()] = el.getIcon();
        }
    }
    
    public void showMap(){
        System.out.println("Sun = " + this.getSunflower()+" Turn = "+this.getTurn());
        System.out.println("Score = " + score);
        this.fillMap();
        System.out.println("0\t1\t2\t3\t4\t5\t6\t7\t8\t");
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

    /*method testing */
    public void printContainer() {
        for (Entitas el: container) {
            System.out.println(el.getType());
        }
    }

    public void skip () {

        //tambahin sun
        this.addSunflower();
        
        //spawn zombie
        int spawnornot = rand.nextInt(10);
        if (spawnornot % 2 == 0) {
            this.spawnZombie();
        }

        //plant yg udah ada shoot bullet
        ArrayList<Bullet> newbullet = new ArrayList<Bullet>();
        for (Entitas el: container) {
            if (el.getType().equals("plant")) {
                Plant pl = (Plant) el;
                Bullet bp = pl.shoot();
                newbullet.add(bp);
            }
        }
        container.addAll(newbullet);

        for (Entitas ent : container) {
            System.out.println(ent.getIcon()+" "+ent.getType()+" "+ent.getPos().getX()+","+ent.getPos().getY());
        }
        showMap();
        
        //zombie yg udh ada suruh jalan (kalo masih bisa jalan)
        //zombie yg ada didepan plant attack plantnya
        int zombiedist;
        for (Entitas el: container) {
            if (el.getType().equals("zombie")) {
                Entitas preq = el;
                Zombie z = (Zombie) preq;
                // System.out.println("el "+el.getClass());
                // System.out.println("preq "+preq.getClass());
                // System.out.println("z "+z.getClass());
                boolean canmovezombie = true;
                for (Entitas other: container) {
                    // System.out.println("other "+other.getClass());
                    // System.out.println("other "+other.getType()+" "+other.getIcon());
                    // System.out.println("other "+other.getPos().getX()+","+other.getPos().getY());
                    zombiedist = el.getPos().distance(other.getPos());
                    if (zombiedist == z.getSpeed()) {
                        canmovezombie = false;
                        if (other.getType().equals("plant")) {
                            Plant pl = (Plant) other;
                            z.attack(pl);
                        }
                    }
                    if (z.getPos().getX() - z.getSpeed() < 0) {
                        canmovezombie = false;
                        win = false;
                        break;
                    }
                }
                if (canmovezombie == true) {
                    z.move();
                }
            }
        }

        //bullet yg udh dishoot move
        for (Entitas el: container) {
            if (el.getType().equals("bullet")) {
                Entitas prev = el;
                Bullet b = (Bullet) prev;
                // System.out.println("el "+el.getClass());
                // System.out.println("prev "+prev.getClass());
                // System.out.println("b "+b.getClass());
                // System.out.println("el "+el.getPos().getX()+","+el.getPos().getX());
                if (el.getPos().getX() + b.getSpeed() > 8) {
                    //bullet diilangin dari layar (karena udh keluar jangkauan layar)
                    b.isDead();
                }
                else {
                    b.move();
                    //bullet ngedamage zombie dan diilangin dari layar
                    for (Entitas other: container) {
                        if (other.getType().equals("zombie")) {
                            Zombie zdmg = (Zombie) other;
                            if (b.collideWith(zdmg)) {
                                b.attack(zdmg);
                                b.isDead();
                            }
                        }
                    }
                }
            }
        }

        //zombie & plant yg udh mati dimark mati
        for (Entitas el: container) {
            if (el.getType().equals("plant")) {
                Plant pldead = (Plant) el;
                if (pldead.getLife() < 0) {
                    pldead.isDead();
                }
            }
            else if (el.getType().equals("zombie")) {
                Zombie zdead = (Zombie) el;
                if (zdead.getHealth() < 0) {
                    zdead.isDead();
                }
            }
        }
        //entitas yg udh mati dibuang dari layar
        Iterator itr = container.iterator(); 
        while (itr.hasNext()) 
        { 
            Entitas eldead = (Entitas) itr.next(); 
            if (eldead.getDie()) 
                itr.remove(); 
        }
    }
}