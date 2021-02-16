package wee.model;

import wee.model.hero.Hero;
import wee.controller.Game_Controller;
import wee.model.hero.CreateHero;
import wee.model.monsters.Monster;
import wee.model.monsters.CreateMonster;
import wee.model.Map;
import wee.model.Rnd;
import java.util.concurrent.TimeUnit;
// import java.util.Scanner;
public class Game{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private Hero userHero;
    private Monster selectedMonster;
    private Map map = new Map();
    private static final String[] listOfMonsters = {"Dragon", "Orge", "Skeleton", "Bat"};
    private Rnd random = new Rnd();

    public Hero getHero(){
        return userHero;
    }

    public Monster getMonster(){
        return selectedMonster;
    }
    public Game(){
    }

    public void createHero(String heroName, String heroClass){
        userHero = CreateHero.newHero(heroName, heroClass);
    }

    public void selectMonsterToFight(){
        int randomMonster = random.randomNumberOfFour();
        System.out.println(randomMonster);
        System.out.println(listOfMonsters[randomMonster]+" --Weeeeeeeeeeeee");
        selectedMonster = CreateMonster.newMonster(listOfMonsters[randomMonster]);
        // return selectedMonster;
    }

    public void createMap(){
        try {
            map.generateMap(userHero.getHeroLevel());
        } catch (Exception e) {
            System.out.println("ERROR: cant creat map"+e);
        }
    }

    public void addPlayerToMap(){
        try {
            System.out.println(ANSI_BLUE+"Adding Player to map \u001B[34m"+ANSI_WHITE);
            TimeUnit.SECONDS.sleep(5);
            map.addPlayerToMap();
        } catch (Exception e) {
            System.out.println("ERROR: "+e);
        }
    }
    
    public void addMonstersToMap(){
        try {
            System.out.println(ANSI_RED+"Adding Monsters to map"+ANSI_WHITE);
            TimeUnit.SECONDS.sleep(5);
            map.addMonstersToMap();        
        } catch (Exception e) {
            System.out.println("ERROR: "+e);
        }
    }

    public void printMap(){
        System.out.println(ANSI_GREEN+"Printing Map"+ANSI_WHITE);
        map.printMap();
    }

    public void findPlayerOnMap(){
        map.findPlayerOnMap();
    }

    public int playerMoveNorth(){
        int count = map.moveNorth();
        if (count == 2){
            return count;
        }
        return count;
    }

    public void fightNorth(){
        selectMonsterToFight();
        map.afterMoveNorth();
    }

    public int playerMoveSouth(){
        int count = map.moveSouth();
        if (count == 2){
            return count;
        }
        return count;
    }

    public void fightSouth(){
        map.afterMoveSouth();
    }

    public int playerMoveEast(){
        int count = map.moveEast();
        if (count == 2){
            return count;
        }
        return count;
    }

    public void fightEast(){
        map.afterMoveEast();
    }

    public int playerMoveWest(){
        int count = map.moveWest();
        if (count == 2){
            return count;
        }
        return count;
    }

    public void fightWest(){
        map.afterMoveWest();
    }
}