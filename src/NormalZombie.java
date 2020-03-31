/**
 * NormalZombie (Zombie 1)
 */
public class NormalZombie extends Zombie {
    public NormalZombie(Point pos){
        super();
        this.pos = pos; //random pos
        this.icon = 'Z';
        this.die = false;
        this.health = 100;
        this.speed = 1; //not fixed yet
        this.damage = 10; //not fixed yet
    }
    public void move(){
        this.pos.translate(-this.speed,0);
    }
    public void attack(Plant p){
        p.life-=this.damage;
        System.out.println("A normal zombie at "+(pos.getX()+1)+","+(pos.getY()+1)+" has attacked a plant by "+this.damage+" pts");
    }
}