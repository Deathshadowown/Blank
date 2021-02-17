package wee.model.monsters;

public class Bat extends Monster{
    public Bat(){
        super("Bat");
        this.attack = 5;
        // this.attack = 0;
        this.defence = 10;
        this.health = 100;
        this.blockChance = 10;
    }
}