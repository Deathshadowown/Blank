package wee.model.monsters;

public class Dragon extends Monster{
    public Dragon(){
        super("Dragon");
        this.attack = 30;
        // this.attack = 0;
        this.defence = 15;
        this.health = 100;
        this.blockChance = 25;
        this.experienceDroped = 300;
    }
}