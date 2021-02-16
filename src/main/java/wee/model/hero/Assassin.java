package wee.model.hero;

public class Assassin extends Hero{
    public Assassin(String heroName){
        super(heroName, "Assassin");
        this.attack = 20;
        this.defence = 15;
        this.health = 100;
        this.blockChance = 25;
        this.experience = 0;
    }
}