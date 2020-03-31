/**
 * Zombie abstract class
 * @author Muhamad Hudan Widzamil (18218003)
 */
public abstract class Zombie extends Entitas {
    //attributes
    protected int speed;
    protected int health;
    protected int damage;

    //ctor
    public Zombie() {
        type = "zombie";
    }

    //setter
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
    public int getSpeed(){return this.speed;}
    public int getHealth(){return this.health;}
    public int getDamage(){return this.damage;}

    public abstract void move();
    public abstract void attack(Plant p);
}