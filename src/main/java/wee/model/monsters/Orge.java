package wee.model.monsters;

public class Orge extends Monster{
    public Orge(){
        super("Orge");
        this.attack = 20;
        // this.attack = 0;
        this.defence = 10;
        this.health = 100;
        this.blockChance = 15;
        this.experienceDroped = 250;
    }
}