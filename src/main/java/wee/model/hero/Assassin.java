package wee.model.hero;

import wee.model.items.Weapons;
import wee.model.items.Armor;
import wee.model.items.Helm;
public class Assassin extends Hero{
    public Assassin(String heroName){
        super(heroName, "Assassin");
        // this.attack = 20;
        this.attack = 50;
        this.defence = 15;
        this.health = 100;
        this.blockChance = 25;
        this.experience = 0;
        this.weapon = new Weapons("defaultSword");
        this.armor =  new Armor("defaultarmor");
        this.helm = new Helm("defaulthelm");
    }
}