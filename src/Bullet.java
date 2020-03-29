/**
 * Bullet
 */
public class Bullet extends Entitas {
    private int damage;
    private int speed;

    public int getDamage(){return this.damage;}
    public int getSpeed(){return this.speed;}
    
    public void setDamage(int newDamage){this.damage = newDamage;}
    public void setSpeed(int newSpeed){this.speed = newSpeed;}

    public void move(){
        this.pos.translate(1,0);
        //TODO
    }
    public void attack(){
        //TODO
    }
}