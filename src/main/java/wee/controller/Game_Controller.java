package wee.controller;

import wee.model.Game;
import wee.view.console_interface.Control_Interface;
import wee.model.Rnd;
public class Game_Controller{
    public byte userChoiceInterface;
    public Game game = new Game();
    private Rnd random = new Rnd();
    public Control_Interface consoleInterface = new Control_Interface();
    public Game_Controller(byte userChoice){
        userChoiceInterface = userChoice;
        if (userChoice == 1){
            String heroName = consoleInterface.userHeroName();
            String heroClass = consoleInterface.userHeroClass();
            game.createHero(heroName, heroClass);
            game.createMap();
            game.addMonstersToMap();
            game.addPlayerToMap();
            game.printMap();
            consoleInterface.helpMessage();
            startGame();
        }else if (userChoice == 2){

        }
    }

    public void startGame(){
        try {
            String userCommand = null;
            int count = 0;
            int newCount = 0;
            int randomnumber;
            System.out.print("Command: ");
            userCommand = consoleInterface.userCommand(game.getHero());
            if (userCommand.equals("help")){
                consoleInterface.help();
            }else if (userCommand.toLowerCase().equals("playerinfo")){
                consoleInterface.playerInfo();
            }else if (userCommand.toLowerCase().equals("map")){
                game.printMap();
            }else if (userCommand.toLowerCase().equals("north")){
                count = game.playerMoveNorth();
                if (count == 2)
                newCount = fightOrFlee(count);
                if (newCount == 1){
                    game.selectMonsterToFight();
                    randomnumber = consoleInterface.messageSelectedMonsterToFight(game.getMonster());
                    count = game.fightSystem(randomnumber);
                    consoleInterface.fightReport(count);
                    randomnumber = game.itemDrop();
                    userCommand = consoleInterface.itemDropMessage(randomnumber, game.getItem());
                    if (userCommand.equals("yes"))
                    game.equipItem();
                    game.fightNorth();
                }
            }else if (userCommand.toLowerCase().equals("south")){
                count = game.playerMoveSouth();
                if (count == 2)
                newCount = fightOrFlee(count);
                if (newCount == 1){
                    game.selectMonsterToFight();
                    randomnumber = consoleInterface.messageSelectedMonsterToFight(game.getMonster());
                    count = game.fightSystem(randomnumber);
                    consoleInterface.fightReport(count);
                    randomnumber = game.itemDrop();
                    userCommand = consoleInterface.itemDropMessage(randomnumber, game.getItem());
                    if (userCommand.equals("yes"))
                    game.equipItem();
                    game.fightSouth();
                }
            }else if (userCommand.toLowerCase().equals("east")){
                count = game.playerMoveEast();
                if (count == 2)
                newCount = fightOrFlee(count);
                if (newCount == 1){
                    game.selectMonsterToFight();
                    randomnumber = consoleInterface.messageSelectedMonsterToFight(game.getMonster());
                    count = game.fightSystem(randomnumber);
                    consoleInterface.fightReport(count);
                    randomnumber = game.itemDrop();
                    userCommand = consoleInterface.itemDropMessage(randomnumber, game.getItem());
                    if (userCommand.equals("yes"))
                    game.equipItem();
                    game.fightEast();
                }
            }else if (userCommand.toLowerCase().equals("west")){
                count = game.playerMoveWest();
                if (count == 2)
                newCount = fightOrFlee(count);
                if (newCount == 1){
                    game.selectMonsterToFight();
                    randomnumber = consoleInterface.messageSelectedMonsterToFight(game.getMonster());
                    count = game.fightSystem(randomnumber);
                    consoleInterface.fightReport(count);
                    randomnumber = game.itemDrop();
                    userCommand = consoleInterface.itemDropMessage(randomnumber, game.getItem());
                    if (userCommand.equals("yes"))
                    game.equipItem();
                    game.fightWest();
                }
            }else if (userCommand.toLowerCase().equals("save")){
                
            }else if (userCommand.toLowerCase().equals("quit")){
                System.exit(0);
            }
            startGame();
            
        } catch (Exception e) {
            System.out.println("ERROR: Please give error message to support"+e);
            //TODO: handle exception
        }

    }

    public int fightOrFlee(int count){
        int randomnumber;
            count = consoleInterface.fightOrFlee();
            //if Count is 1 you fight if 2 you try to flee
                if (count == 2){
                    randomnumber = random.randomNumber();
                    if (randomnumber <= 4)
                    consoleInterface.fleeSuccessful();
                    else{
                        consoleInterface.fleeFailed();
                        count = 1;
                    }
            }
            return count;
    }
}