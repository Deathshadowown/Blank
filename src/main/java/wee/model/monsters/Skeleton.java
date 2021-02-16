package wee.model.monsters;

public class Skeleton extends Monster{
    public Skeleton(){
        super("Skeleton");
        this.attack = 10;
        this.defence = 10;
        this.health = 100;
        this.blockChance = 10;
    }
}