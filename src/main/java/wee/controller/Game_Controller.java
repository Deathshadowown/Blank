package wee.controller;

import wee.model.Game;
import wee.view.console_interface.Control_Interface;
public class Game_Controller{
    public byte userChoiceInterface;
    public Game game = new Game();
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
                if (count == 2){
                    count = consoleInterface.fightOrFlee();
                    game.fightOrFleeNorth(count);
                }
            }else if (userCommand.toLowerCase().equals("south")){
                game.playerMoveSouth();
            }else if (userCommand.toLowerCase().equals("east")){
                game.playerMoveEast();
            }else if (userCommand.toLowerCase().equals("west")){
                game.playerMoveWest();
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
}