/**
 * Bullet
 * @author Carissa Aurelia (18217501)
 */
public class Bullet extends Entitas {
    private int damage;
    private int speed;

    public Bullet(int damage, Point P){
        this.icon = '-';
        this.speed = 1;
        this.damage = damage;
        this.type = "bullet";
        this.pos = P;
    }
    public int getDamage(){return this.damage;}
    public int getSpeed(){return this.speed;}
    
    public void setDamage(int newDamage){this.damage = newDamage;}
    public void setSpeed(int newSpeed){this.speed = newSpeed;}

    public void move(){
        this.pos.translate(this.speed, 0);
    }
    public void attack(Zombie z){
        z.health = z.health - damage;
    }
}