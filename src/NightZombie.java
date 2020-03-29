/**
 * NightZombie (Zombie 2)
 */
public class NightZombie extends Zombie {
    public NightZombie(){
        //this.pos = P; use random
        this.die = false;
        this.health = 100;
        this.speed = 20; //not fixed yet
        this.damage = 20; //not fixed yet
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