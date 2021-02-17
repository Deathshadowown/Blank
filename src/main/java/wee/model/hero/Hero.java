package wee.model.hero;

import wee.model.items.Weapons;
import wee.model.items.Armor;
import wee.model.items.Helm;
import wee.model.items.Items;
import wee.model.items.Potion;
import java.lang.Math;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;
import java.io.FileWriter;
public class Hero{
    private String heroName;
    private String heroClass;
    protected Weapons weapon;
    protected Armor armor;
    protected Helm helm;
    protected Potion potion;
    protected int attack;
    protected int defence;
    protected int health;
    protected int blockChance;
    protected int experience;
    protected int experienceEarned;
    protected int nextLevel = 1000;
    protected int heroLevel = 1;

    public Hero(String heroName, String heroClass){
        this.heroName = heroName;
        this.heroClass = heroClass;
    }
    
    // public int nextLevel(int heroLevel){
    //     int exponent = 1.5;
    //     int baseXP = 1000;
    //     return math.floor(baseXP * (heroLevel ^ exponent));
    // }

    //Set HeroName
    public String getHeroName(){
        return this.heroName;
    }
    public void setHeroName(String heroName){
        this.heroName = heroName;
    }

    //set HeroClass
    public String getHeroClass(){
        return this.heroClass;
    }
    public void setHeroClass(String heroClass){
        this.heroClass = heroClass;
    }

    //set CurrentWeapon
    public String getCurrentWeapon(){
        return this.weapon.getItemName();
    }
    
    public void setCurrentWeapon(Weapons weapon){
        this.weapon = weapon;
    }

    public void setChangeCurrentWeapon(Items item){
        int totalAttack = getAttack();
        totalAttack -= this.weapon.getAttack();
        this.weapon = new Weapons(item.getItemName());
        totalAttack += this.weapon.getAttack();
        setAttack(totalAttack);
    }
    
    //set CurrentArmor
    public String getCurrentArmor(){
        return this.armor.getItemName();
    }

    public void setCurrentArmor(Armor armor){
        this.armor = armor;
    }

    public void setChangeCurrentArmor(Items item){
        int totalArmor = getDefence();
        totalArmor -= this.armor.getDefence();
        this.armor = new Armor(item.getItemName());
        totalArmor +=  this.armor.getDefence();
        setDefence(totalArmor);
    }

    //set CurrentHelm
    public String getCurrentHelm(){
        return this.helm.getItemName();
    }
    
    public void setCurrentHelm(Helm helm){
        this.helm = helm;
    }

    public void setChangeCurrentHelm(Items item){
        int totalHelm = getHealth();
        totalHelm -= this.helm.getHealth();
        if (totalHelm <= 0){
            System.out.println("Cant uniquip helm, Hero would die.");
        }else{
            this.helm = new Helm(item.getItemName());
            totalHelm += this.helm.getHealth();
            setHealth(totalHelm);
        }
    }

    //Set Potion
    public void setAndUsePotion(Items item){
        int addHealth = getHealth();
        this.potion = new Potion(item.getItemName());
        addHealth += potion.getHealth();
        setHealth(addHealth);
    }

    //set Attack
    public int getAttack(){
        return this.attack;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }

    //set Defence
    public int getDefence(){
        return this.defence;
    }
    public void setDefence(int defence){
        this.defence = defence;
    }

    //set Health
    public int getHealth(){
        return this.health;
    }
    public void setHealth(int health){
        this.health = health;
    }
    
    //set BlockChance
    public int getBlockChance(){
        return this.blockChance;
    }
    public void setBlockChance(int blockChance){
        this.blockChance = blockChance;
    }

    //set Experience
    public int getExperience(){
        return this.experience;
    }
    public void setExperience(int experience){
        this.experience += experience;
        if (this.experience >= getHeroNextLevel()){
            this.heroLevel++;
            setHeroNextLevel(heroLevel);
            System.out.println("\u001B[34m"+"congratulations, "+heroName+" You have reached level "+heroLevel+"\u001B[37m");
            this.experience = 0;
        }
    }

    //set HeroLevel
    public int getHeroLevel(){
        return this.heroLevel;
    }
    public void setHeroLevel(int heroLevel){
        this.heroLevel += heroLevel;
    }

    //set HeroNextLevel
    public int getHeroNextLevel(){
        return this.nextLevel;
    }
    public void setHeroNextLevel(int nextLevel){
        this.nextLevel *= nextLevel;
    }
    public void saveGame(){
        try {
            File newFile = new File("SaveFile.txt");
            // System.out.println("are we really here?");
            if (newFile.exists()){
                FileWriter write = new FileWriter("SaveFile.txt");
                write.write(this.heroName+" "+this.heroClass+" "+this.heroLevel+" "+this.weapon.getItemName()+" "
                +this.armor.getItemName()+" "+this.helm.getItemName()+" "+this.attack+" "
                +this.defence+" "+this.health+" "+this.getBlockChance()
                +" "+this.experience+" "+this.experienceEarned+" "+this.nextLevel+" "+this.heroLevel);
                write.close();
            }else{
                newFile.createNewFile();
                System.out.println("Save File been created.");
                Scanner scan = new Scanner("SaveFile.txt");
                FileWriter write = new FileWriter("SaveFile.txt");
                write.write(this.heroName+" "+this.heroClass+" "+this.heroLevel+" "+this.weapon.getItemName()+" "
                +this.armor.getItemName()+" "+this.helm.getItemName()+" "+this.attack+" "
                +this.defence+" "+this.health+" "+this.getBlockChance()
                +" "+this.experience+" "+this.experienceEarned+" "+this.nextLevel+" "+this.heroLevel);
                write.close();
            }
        } catch (IOException e){
            System.out.println("ERROR: File");
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}