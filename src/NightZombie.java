/**
 * NightZombie (Zombie 2)
 */
public class NightZombie extends Zombie {
    public NightZombie(Point pos){
        super();
        this.pos = pos; //use random
        this.icon = 'N';
        this.die = false;
        this.health = 100;
        this.speed = 1; //not fixed yet
        this.damage = 20; //not fixed yet
    }

    public void move(){
        this.pos.translate(-this.speed,0);
    }
    public void attack(Plant p){
        p.life-=this.damage;
    }
}