package wee.model.monsters;

public class Monster{
    private String monsterName;
    protected int attack;
    protected int defence;
    protected int health;
    protected int blockChance;
    protected int experienceDroped;

    public Monster(String monsterName){
        this.monsterName = monsterName;
    }

    //Set MonsterName
    public String getMonsterName(){
        return this.monsterName;
    }
    public void setMonsterName(String monsterName){
        this.monsterName = monsterName;
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

    //set ExperienceDroped
    public int getExperienceDroped(){
        return this.experienceDroped;
    }
    public void setExperienceDroped(int experienceDroped){
        this.experienceDroped = experienceDroped;
    }
}