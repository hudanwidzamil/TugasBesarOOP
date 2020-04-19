/**
 * Player class
 */
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

// import GamePanel.*;

import java.util.Iterator; 

public class Player {
    private Integer sunflower;
    private ArrayList<Entitas> container;
    private int turn;
    private char[][] map;
    private boolean win = true;
    
    GamePanel gpanel;
    GameInfo ginfo;

    Random rand = new Random();

    public Player(GamePanel gpanel,GameInfo ginfo){
        this.gpanel = gpanel;
        this.ginfo = ginfo;
        this.sunflower = ginfo.sfpts;
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
    public void buyPlant(String onSelect, Point point) throws InvalidPlacingException,InvalidBuyingException{
        boolean canplace = true;
        Point pos = point;
        Plant p;

        if (onSelect.equals("P")) {
            p = new Peashooter(pos);
        }
        else {
            p = new Fumeshroom(pos);
        }

        for (Entitas el : container) {
            if (el.collideWith(p)&& !el.getType().equals("bullet")) {
                canplace = false;
            }
        }

        if (canplace == false) {
            // System.out.println("Sorry, can't place there");
            throw new InvalidPlacingException();
        }
        else {
            if (ginfo.sfpts >= p.price) {
                container.add(p);
                ginfo.sfpts = ginfo.sfpts - p.price;
            }
            else {
                // System.out.println("Sorry, can't buy plant");
                throw new InvalidBuyingException();    
            }
        }
    }

    public void buyPlantGUI(){
        if (gpanel.selectedPos != null) {
            try {
                buyPlant(gpanel.onSelect, gpanel.selectedPos);    
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            gpanel.selectedPos = null;
            gpanel.onSelect = "none";
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

    public void fillGrid(){
        for (GamePanel.PlantButton elmt : gpanel.grid) {
            elmt.setIcon(null);
            elmt.type = "none";
        }
        for (Entitas el : container) {
            for (GamePanel.PlantButton elmt : gpanel.grid) {
                if (el.getPos().distance(elmt.p)==0) {
                    elmt.type = Character.toString(el.getIcon());
                    if (elmt.type.equals("P")) {
                        elmt.setIcon(new ImageIcon("..\\images\\plants\\peashooter_small.gif"));    
                    } else if(elmt.type.equals("F")) {
                        elmt.setIcon(new ImageIcon("..\\images\\plants\\Fume-shroom_small.png"));
                    }else if(elmt.type.equals("Z")) {
                        elmt.setIcon(new ImageIcon("..\\images\\zombies\\zombie1.png"));
                    }else if(elmt.type.equals("N")) {
                        elmt.setIcon(new ImageIcon("..\\images\\zombies\\zombie2.png"));
                    }else if(elmt.type.equals("-")) {
                        elmt.setIcon(new ImageIcon("..\\images\\pea.png"));
                    }else{ // elmt.type.equals("none")
                        elmt.setIcon(null);
                    }
                }
            }
        }
    }
    
    public void showMap(){
        System.out.println("Sun = " + this.getSunflower()+" Turn = "+this.getTurn());
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

    /*method testing */
    public void printContainer() {
        for (Entitas el: container) {
            System.out.println(el.getType()+el.getPos().getX()+el.getPos().getY());
        }
        System.out.println(" ");
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
                boolean canmovezombie = true;
                for (Entitas other: container) {
                    if (other.getType().equals("plant")) {
                        zombiedist = el.getPos().distance(other.getPos());
                        if (zombiedist == z.getSpeed()) {
                            canmovezombie = false;
                            Plant pl = (Plant) other;
                            z.attack(pl);
                        }
                    }
                    else if (other.getType().equals("bullet")) {
                        canmovezombie = true;
                    }
                    else if (z.getPos().getX() - z.getSpeed() < 0) {
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

    public void skipGUI() {
        fillGrid();
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

        fillGrid();
        
        //zombie yg udh ada suruh jalan (kalo masih bisa jalan)
        //zombie yg ada didepan plant attack plantnya
        int zombiedist;
        for (Entitas el: container) {
            if (el.getType().equals("zombie")) {
                Entitas preq = el;
                Zombie z = (Zombie) preq;
                boolean canmovezombie = true;
                for (Entitas other: container) {
                    if (other.getType().equals("plant")) {
                        zombiedist = el.getPos().distance(other.getPos());
                        if (zombiedist == z.getSpeed()) {
                            canmovezombie = false;
                            Plant pl = (Plant) other;
                            z.attack(pl);
                        }
                    }
                    else if (other.getType().equals("bullet")) {
                        canmovezombie = true;
                    }
                    else if (z.getPos().getX() - z.getSpeed() < 0) {
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
        fillMap();
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