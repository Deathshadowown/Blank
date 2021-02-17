package wee.model;

import wee.model.hero.Hero;
import wee.controller.Game_Controller;
import wee.model.hero.CreateHero;
import wee.model.monsters.Monster;
import wee.model.monsters.CreateMonster;
import wee.model.items.Items;
import wee.model.items.SelectItem;
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
    private Items item;
    private static final String[] listOfMonsters = {"Dragon", "Orge", "Skeleton", "Bat"};
    private static final String[] listBatMonsterItems = {"batsword", "batarmor", "bathelm", "healingpotion", "greaterhealingpotion"};
    private static final String[] listSkeletonMonsterItems = {"bonesword", "bonearmor", "bonehelm", "healingpotion", "greaterhealingpotion"};
    private static final String[] listOrgeMonsterItems = {"orgesword", "orgearmor", "orgehelm", "healingpotion", "greaterhealingpotion", "superiorhealingpotion"};
    private static final String[] listDragonMonsterItems = {"dragonsword", "dragonarmor", "dragonhelm", "healingpotion", "greaterhealingpotion", "superiorhealingpotion", "supremehealingpotion"};
    private Rnd random = new Rnd();

    public Hero getHero(){
        return userHero;
    }

    public Monster getMonster(){
        return selectedMonster;
    }
    public Game(){
    }

    public Items getItem(){
        return item;
    }

    public void createHero(String heroName, String heroClass){
        userHero = CreateHero.newHero(heroName, heroClass);
    }

    public void selectMonsterToFight(){
        int randomMonster = random.randomNumberOfFourOne();
        System.out.println(randomMonster);
        System.out.println(listOfMonsters[randomMonster]+" --Weeeeeeeeeeeee");
        selectedMonster = CreateMonster.newMonster(listOfMonsters[randomMonster]);
        // return selectedMonster;
    }

    public void getItem(String itemType, String itemName){
        item = SelectItem.newItem(itemType, itemName);
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
        // selectMonsterToFight();
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

    public int fightSystem(int randomnumber){
        int newHeroHealth;
        int newMonsterHealth;
        int count = 0;
        while(true){
            if(randomnumber > 50){
                newHeroHealth = userHero.getHealth() - selectedMonster.getAttack();
                userHero.setHealth(newHeroHealth);
                if (userHero.getHealth() <= 0){
                    count = 1;
                    break;
                }
                newMonsterHealth = selectedMonster.getHealth() - userHero.getAttack();
                selectedMonster.setHealth(newMonsterHealth);
                if (selectedMonster.getHealth() <= 0){
                    count = 2;
                    break;
                }
            }else if (randomnumber <= 50){
                newMonsterHealth = selectedMonster.getHealth() - userHero.getAttack();
                selectedMonster.setHealth(newMonsterHealth);
                if (selectedMonster.getHealth() <= 0){
                    count = 2;
                    break;
                }
                newHeroHealth = userHero.getHealth() - selectedMonster.getAttack();
                userHero.setHealth(newHeroHealth);
                if (userHero.getHealth() <= 0){
                    count = 1;
                    break;
                }
            }
        }
        return count;
    }

    public int itemDrop(){
        int randomNumber;
        int randomItemDrop;
        // boolean isFound = text.contains("Java8");
        randomNumber = random.randomNumberOneHundred();

        if (randomNumber > 50){
            if (selectedMonster.getMonsterName().equals("Dragon")){
                randomItemDrop = random.randomNumberOfSix();
                if (listDragonMonsterItems[randomItemDrop].contains("sword")){
                    getItem("weapon", listDragonMonsterItems[randomItemDrop]);
                }else if (listDragonMonsterItems[randomItemDrop].contains("armor")){
                    getItem("armor", listDragonMonsterItems[randomItemDrop]);
                }else if (listDragonMonsterItems[randomItemDrop].contains("helm")){
                    getItem("helm", listDragonMonsterItems[randomItemDrop]);
                }else if (listDragonMonsterItems[randomItemDrop].contains("potion")){
                    getItem("potion", listDragonMonsterItems[randomItemDrop]);
                }
            }else if (selectedMonster.getMonsterName().equals("Orge")){
                randomItemDrop = random.randomNumberOfFive();
                if (listOrgeMonsterItems[randomItemDrop].contains("sword")){
                    getItem("weapon", listOrgeMonsterItems[randomItemDrop]);
                }else if (listOrgeMonsterItems[randomItemDrop].contains("armor")){
                    getItem("armor", listOrgeMonsterItems[randomItemDrop]);
                }else if (listOrgeMonsterItems[randomItemDrop].contains("helm")){
                    getItem("helm", listOrgeMonsterItems[randomItemDrop]);
                }else if (listOrgeMonsterItems[randomItemDrop].contains("potion")){
                    getItem("potion", listOrgeMonsterItems[randomItemDrop]);
                }
            }else if (selectedMonster.getMonsterName().equals("Bat")){
                randomItemDrop = random.randomNumberOfFour();
                if (listBatMonsterItems[randomItemDrop].contains("sword")){
                    getItem("weapon", listBatMonsterItems[randomItemDrop]);
                }else if (listBatMonsterItems[randomItemDrop].contains("armor")){
                    getItem("armor", listBatMonsterItems[randomItemDrop]);
                }else if (listBatMonsterItems[randomItemDrop].contains("helm")){
                    getItem("helm", listBatMonsterItems[randomItemDrop]);
                }else if (listBatMonsterItems[randomItemDrop].contains("potion")){
                    getItem("potion", listBatMonsterItems[randomItemDrop]);
                }
            }else if (selectedMonster.getMonsterName().equals("Skeleton")){
                randomItemDrop = random.randomNumberOfFour();
                if (listSkeletonMonsterItems[randomItemDrop].contains("sword")){
                    getItem("weapon", listSkeletonMonsterItems[randomItemDrop]);
                }else if (listSkeletonMonsterItems[randomItemDrop].contains("armor")){
                    getItem("armor", listSkeletonMonsterItems[randomItemDrop]);
                }else if (listSkeletonMonsterItems[randomItemDrop].contains("helm")){
                    getItem("helm", listSkeletonMonsterItems[randomItemDrop]);
                }else if (listSkeletonMonsterItems[randomItemDrop].contains("potion")){
                    getItem("potion", listSkeletonMonsterItems[randomItemDrop]);
                }
            }
        }else if (randomNumber <= 50){

        }
        return randomNumber;
    }

    public void equipItem(){
        String nameOfItem = item.getItemName();
        if(nameOfItem.contains("sword")){
            userHero.setChangeCurrentWeapon(item);
        }else if (nameOfItem.contains("armor")){
            userHero.setChangeCurrentArmor(item);
        }else if (nameOfItem.contains("helm")){
            userHero.setChangeCurrentHelm(item);
        }else if (nameOfItem.contains("potion")){
            userHero.setAndUsePotion(item);
        }
    }
}