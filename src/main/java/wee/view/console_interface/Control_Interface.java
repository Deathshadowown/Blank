package wee.view.console_interface;

import wee.model.hero.Hero;
import wee.model.Game;
import java.util.Scanner;
public class Control_Interface{
    private Game game;
    private Hero myHero;
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
        System.out.println("Hero's Class: "+myHero.getHeroClass());
        System.out.println("Hero's Level: "+myHero.getHeroLevel());
        System.out.println("Hero's Health"+myHero.getHealth());
        System.out.println("Hero's Attack: "+myHero.getAttack());
        System.out.println("Hero's Defence:"+myHero.getDefence());
        System.out.println("Hero's BlockChance: "+myHero.getBlockChance());
        System.out.println("Current Hero's Experience: "+myHero.getExperience()+"\u001B[37m");
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
}