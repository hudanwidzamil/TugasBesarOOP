/**
 * Point
 */
import java.lang.Math;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y){
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

    public int distance(Point P){
        if (this.y==P.getY()) {
          return Math.abs(this.x-P.getX());
        } else{
            return -1;
        }
    }

}