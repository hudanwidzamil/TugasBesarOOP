/**
 * Point
 */
public class Point {
    private int x;
    private int y;
    
    public void Point(){
        x = 0;
        y = 0;
    }
    public void Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void translate(int x, int y){
        this.x +=x;
        this.y +=y;
    }

    public void translate(Point P){
        this.x +=P.getX();
        this.y +=P.getY();
    }

}