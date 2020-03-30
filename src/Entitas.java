/**
 * Entitas
 */
public abstract class Entitas {
    protected Point pos;
    protected boolean die;
    protected char icon;
    protected String type;

    public Point getPos(){
        return this.pos;
    }
    public char getIcon(){
        return this.icon;
    }
    public void setPos(Point P){
        this.pos = P;
    }

    public String getType() {
        return type;
    }
    
    public void isDead(){
        this.die = true;
    };
    public boolean collideWith(Entitas other){
        return ((this.pos.getX() == other.pos.getX())&&(this.pos.getY() == other.pos.getY()));        
    };
    
}