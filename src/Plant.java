/**
 * Plant abstract class
 * @author Muhamad Hudan Widzamil (18218003)
 */
public abstract class Plant extends Entitas {
    //attributes
    protected int health;
    protected int price;

    //setter
    public void setHealth(int health) {
        this.health = health;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    //getter
    public int getHealth(){return this.health;}
    public int getPrice(){return this.price;}
    
    public abstract void shoot();
    
}