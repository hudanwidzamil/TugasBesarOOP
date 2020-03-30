/**
 * NormalZombie (Zombie 1)
 */
public class NormalZombie extends Zombie {
    public NormalZombie(Point pos){
        this.pos = pos; //random pos
        this.icon = 'Z';
        this.die = false;
        this.health = 100;
        this.speed = 10; //not fixed yet
        this.damage = 10; //not fixed yet
    }
    public void move(){
        this.pos.translate(-1,0);
        //TODO
    }
    public void attack(Plant p){
        p.life-=this.damage;
        //TODO
    }
}