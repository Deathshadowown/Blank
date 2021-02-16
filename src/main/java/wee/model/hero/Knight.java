package wee.model.hero;

import wee.model.items.Weapons;
import wee.model.items.Armor;
import wee.model.items.Helm;
public class Knight extends Hero{
    public Knight(String heroName){
        super(heroName, "Knight");
        this.attack = 15;
        this.defence = 20;
        this.health = 100;
        this.blockChance = 50;
        this.experience = 0;
        this.experienceEarned = 0;
        this.weapon = new Weapons("defaultSword");
        this.armor =  new Armor("defaultarmor");
        this.helm = new Helm("defaulthelm");
    }
}