package wee.model.hero;

import wee.model.hero.Hero;
public class CreateHero{
    public static Hero newHero(String heroName, String heroClass){
        switch (heroClass) {
            case "Assassin":
                return (new Assassin(heroName));
                // break;
            case "Knight":
                return (new Knight(heroName));
                // break;
            case "Wizard":
                return (new Wizard(heroName));
                // break;
            default:
                break;
        }
        return null;
    }
}