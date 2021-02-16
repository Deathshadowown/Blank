package wee.model.hero;

public class Wizard extends Hero{
    public Wizard(String heroName){
        super(heroName, "Assassin");
        this.attack = 30;
        this.defence = 10;
        this.health = 100;
        this.blockChance = 15;
        this.experience = 0;
        this.experienceEarned = 0;
    }
}