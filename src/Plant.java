/**
 * Plant abstract class
 * @author Muhamad Hudan Widzamil (18218003)
 */
public abstract class Plant {
    //attributes
    private String type;
    private Point position;
    private int health;
    private int damage;
    private int price;

    //setter
    public void setType(String type) {
        this.type = type;
    }
    public void setPosition(Point position) {
        this.position = position;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    //getter
    public String getType(){return this.type;}
    public Point getPosition(){return this.position;}
    public int getHealth(){return this.health;}
    public int getDamage(){return this.damage;}
    public int getPrice(){return this.price;}
    
    public abstract void shoot();
    
}