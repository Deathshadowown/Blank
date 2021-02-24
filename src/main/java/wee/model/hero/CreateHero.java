package wee.model.hero;

import wee.model.hero.Hero;
import java.util.Scanner;

// import jdk.internal.org.jline.reader.ParseContext;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import wee.model.Game;
import wee.model.hero.Hero;
import wee.model.items.Weapons;
import wee.model.items.Armor;
import wee.model.items.Helm;
public class CreateHero{
    public static Game game;
    // public static Hero myHero;
    private static Weapons myWeapon;
    private static Armor myArmor;
    private static Helm myHelm;
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

    public static Hero loadHero(){
        try {
            File newFile = new File("SaveFile.txt");
            if(newFile.exists()){
                Scanner scan = new Scanner(newFile);
                String[] saveInfo = null;
                String fullFile = null;
                while(scan.hasNextLine()){
                    fullFile = scan.nextLine();
                }
                saveInfo = fullFile.split(" ");
                Hero myHero = new Hero(saveInfo[0], saveInfo[1]);
                myHero.heroLevel = Integer.parseInt(saveInfo[2]);
                myWeapon = new Weapons(saveInfo[3]);
                myHero.setCurrentWeapon(myWeapon);
                myArmor = new Armor(saveInfo[4]);
                myHero.setCurrentArmor(myArmor);
                myHelm = new Helm(saveInfo[5]);
                myHero.setCurrentHelm(myHelm);
                myHero.attack = Integer.parseInt(saveInfo[6]);
                myHero.defence = Integer.parseInt(saveInfo[7]);
                myHero.health = Integer.parseInt(saveInfo[8]);
                myHero.blockChance = Integer.parseInt(saveInfo[9]);
                myHero.experience = Integer.parseInt(saveInfo[10]);
                myHero.experienceEarned = Integer.parseInt(saveInfo[11]);
                myHero.nextLevel = Integer.parseInt(saveInfo[12]);
                myHero.heroLevel = Integer.parseInt(saveInfo[13]);
                return myHero;
            }else{
                System.out.println("File does not exist");
                System.exit(0);
            }
            return null;
            
        } catch(IOException e){

        } catch (Exception e) {
            //TODO: handle exception
        }
        return null;
    }
}