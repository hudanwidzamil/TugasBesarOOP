/**
 * Entitas
 */
public abstract class Entitas {
    protected Point pos;
    protected boolean die;

    public Point getPos(){
        return this.pos;
    }
    public void setPos(Point P){
        this.pos = P;
    }
    public void isDead(){
        this.die = true;
    };
    public boolean collideWith(Entitas other){
        return ((this.pos.getX() == other.pos.getX())&&(this.pos.getY() == other.pos.getY()));        
    };
    
}