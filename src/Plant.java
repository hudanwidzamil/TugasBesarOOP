/**
 * Plant abstract class
 * @author Muhamad Hudan Widzamil (18218003)
 */
public abstract class Plant extends Entitas {
    //attributes
    protected int life;
    protected int price;

    //setter
    public void setLife(int life) {
        this.life = life;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    //getter
    public int getLife(){return this.life;}
    public int getPrice(){return this.price;}
    
    /*public void shoot(){
        //TODO

    }*/
    
}