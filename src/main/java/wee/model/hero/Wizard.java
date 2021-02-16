package wee.model.hero;

import wee.model.items.Weapons;
import wee.model.items.Armor;
import wee.model.items.Helm;
public class Wizard extends Hero{
    public Wizard(String heroName){
        super(heroName, "Wizard");
        this.attack = 30;
        this.defence = 10;
        this.health = 100;
        this.blockChance = 15;
        this.experience = 0;
        this.experienceEarned = 0;
        this.weapon = new Weapons("defaultSword");
        this.armor =  new Armor("defaultarmor");
        this.helm = new Helm("defaulthelm");
    }
}