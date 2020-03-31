import java.awt.Point;

/**
 * Plant abstract class
 * @author Muhamad Hudan Widzamil (18218003)
 * @author Carissa Aurelia (18217501)
 */
public abstract class Plant extends Entitas {
    //attributes
    protected int life;
    protected int price;
    protected int damage;

    //ctor
    public Plant() {
        type = "plant";
    }

    //setter
    public void setLife(int life) {
        this.life = life;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    //getter
    public int getLife(){return this.life;}
    public int getPrice(){return this.price;}
    public int getDamage(){return this.damage;}
    
    public Bullet shoot(){
        Point p = new Point(this.pos.getX()+1,this.pos.getX()+1);
        return new Bullet(this.damage, p);
    }
    
}