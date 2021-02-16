package wee.model.hero;

public class Knight extends Hero{
    public Knight(String heroName){
        super(heroName, "Assassin");
        this.attack = 15;
        this.defence = 20;
        this.health = 100;
        this.blockChance = 50;
        this.experience = 0;
        this.experienceEarned = 0;
    }
}