package wee.view.console_interface;

import wee.model.hero.Hero;
import wee.model.monsters.Monster;
import wee.model.items.Items;
import wee.model.Game;
import wee.model.Rnd;
import java.util.Scanner;
public class Control_Interface{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private Game game;
    private Hero myHero;
    private Items item;
    private Monster selectedMonster;
    private Rnd random = new Rnd();
    public Scanner scan = new Scanner(System.in);
    public Control_Interface(){

    }

    public String userHeroName(){
        String heroName = null;
        while(true){
            System.out.print("Please enter your Hero's Name: ");
            heroName = scan.nextLine();
            if (heroName.equals("")){
                System.out.println("Please enter Hero name.");
            }else
            break;
        }
        return heroName;
    }

    public String userHeroClass(){
        String heroClass = null;
        String heroClassSelect = null;
        System.out.println("Please enter your Hero Class");
        while(true){
            System.out.println("Choices 1) Assassin, 2) Knight, 3) Wizard, Use 1, 2, or 3 to select");
            heroClass = scan.nextLine();
            if(heroClass.equals("1")){
                heroClassSelect = "Assassin";
                break;
            }else if (heroClass.equals("2")){
                heroClassSelect = "Knight";
                break;
            }else if (heroClass.equals("3")){
                heroClassSelect = "Wizard";
                break;
            }
        }
        return heroClassSelect;
    }

    public void helpMessage(){
        System.out.println("Type Help to bring up commands you can use.");
    }

    public String userCommand(Hero hero){
            String userCommand = null;
            myHero = hero;
            while(true){
                userCommand = scan.nextLine();
                if (userCommand.toLowerCase().equals("help")){
                    break;
                }else if (userCommand.toLowerCase().equals("playerinfo")){
                    break;
                }else if (userCommand.toLowerCase().equals("map")){
                    break;
                }else if (userCommand.toLowerCase().equals("north")){
                    break;
                }else if (userCommand.toLowerCase().equals("south")){
                    break;
                }else if (userCommand.toLowerCase().equals("east")){
                    break;
                }else if (userCommand.toLowerCase().equals("west")){
                    break;
                }else if (userCommand.toLowerCase().equals("save")){
                    break;
                }else if (userCommand.toLowerCase().equals("quit")){
                    break;
                }
            }
        return userCommand;       
    }

    public void help(){
        System.out.println("\u001B[34m"+"To move around on the map you type North, South, East, West");
        System.out.println("To View Hero's Stats type PlayerInfo");
        System.out.println("Cheat display map type Map");
        System.out.println("To quit game type Quit");
        System.out.println("To Save game type Save \u001B[37m");
    }

    public void playerInfo(){
        System.out.println("\u001B[32m"+"Hero's Name: "+myHero.getHeroName());
        System.out.println("Hero's Current Weapon: "+myHero.getCurrentWeapon());
        System.out.println("Hero's Current Armor: "+myHero.getCurrentArmor());
        System.out.println("Hero's Current Helm: "+myHero.getCurrentHelm());
        System.out.println("Hero's Class: "+myHero.getHeroClass());
        System.out.println("Hero's Level: "+myHero.getHeroLevel());
        System.out.println("Hero's Health: "+myHero.getHealth());
        System.out.println("Hero's Attack: "+myHero.getAttack());
        System.out.println("Hero's Defence:"+myHero.getDefence());
        System.out.println("Hero's BlockChance: "+myHero.getBlockChance());
        System.out.println("Current Hero's Experience: "+myHero.getExperience());
        System.out.println("Next Level Needed: "+myHero.getHeroNextLevel()+"\u001B[37m");
    }

    public int fightOrFlee(){
        int count = 0;
        String command = null;
        System.out.println("\u001B[31m"+"Hero encountered an enemy!");
        while(true){
            System.out.print("Do you wish to 1)Fight or 2)Flee? Use number: ");
            command = scan.nextLine();
            if (command.equals("1")){
                count = 1;
                break;
            }else if (command.equals("2")){
                count = 2;
                break;
            }
        }
        System.out.println("\u001B[37m");
        return count;
    }
    public void fleeSuccessful(){
        System.out.println("\u001B[34m"+"Flee Successful\u001B[37m");
    }
    public void fleeFailed(){
        System.out.println("\u001B[31m"+"Flee Failed\u001B[37m");
    }

    public int messageSelectedMonsterToFight(Monster monster){
        int randomNumber;
        selectedMonster = monster;
        System.out.println("\u001B[31m"+"Monster appears "+selectedMonster.getMonsterName()+" Hero gets ready to fight"+"\u001B[37m");
        System.out.print("Press enter to roll dice: ");
        scan.nextLine();
        randomNumber = random.randomNumberOneHundred();
        if (randomNumber > 50){
            System.out.println("\u001B[31m"+"Monster gets first attack\u001B[37m");
        }else if(randomNumber <= 50){
            System.out.println("\u001B[34m"+"Hero gets first attack\u001B[37m");
        }
        return randomNumber;
    }

    public void fightReport(int count){
        if (count == 1){
            System.out.println(ANSI_RED+"hero has died, Game Over"+ANSI_WHITE);
            System.exit(0);
        }else if (count == 2){
            System.out.println(ANSI_BLUE+"Monster has died, Hero has earned "+selectedMonster.getExperienceDroped()+" Experience"+ANSI_WHITE);
            myHero.setExperience(selectedMonster.getExperienceDroped());
        }
        
    }

    public String itemDropMessage(int randomNumber, Items gotItem){
        String userReply = "boo";
        item = gotItem;
        if (randomNumber > 50){
            System.out.println(ANSI_BLUE+"You received "+item.getItemName());
            while(true){
                System.out.print("Do you want to equip item? yes no: "+ANSI_WHITE);
                userReply = scan.nextLine();
                if (userReply.toLowerCase().equals("yes")){
                    return userReply;
                }else if (userReply.toLowerCase().equals("no")){
                    return userReply;
                }
            }

        }else if (randomNumber <= 50){
            System.out.println(ANSI_RED+"no item received"+ANSI_WHITE);
        }
        return userReply;
    }
}