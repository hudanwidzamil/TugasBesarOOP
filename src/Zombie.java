/**
 * Zombie abstract class
 * @author Muhamad Hudan Widzamil (18218003)
 */
public abstract class Zombie {
    //attributes
    private String type;
    private Point position;
    private int speed;
    private int health;
    private int damage;

    //setter
    public void setType(String type) {
        this.type = type;
    }
    public void setPosition(Point position) {
        this.position = position;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    //getter
    public String getType(){return this.type;}
    public Point getPosition(){return this.position;}
    public int getSpeed(){return this.speed;}
    public int getHealth(){return this.health;}
    public int getDamage(){return this.damage;}

    public abstract void move();
}