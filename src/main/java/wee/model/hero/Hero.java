package wee.model.hero;

public class Hero{
    private String heroName;
    private String heroClass;
    protected int attack;
    protected int defence;
    protected int health;
    protected int blockChance;
    protected int experience;
    protected int experienceEarned;
    protected int nextLevel = 50;
    protected int heroLevel = 1;

    public Hero(String heroName, String heroClass){
        this.heroName = heroName;
        this.heroClass = heroClass;
    }
    
    // public int nextLevel(int heroLevel){
        // int exponent = 1.5;
        // int baseXP = 1000;
        // return math.floor(baseXP * (heroLevel ^ exponent));
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
        this.experience = experience;
    }





    //set HeroLevel
    public int getHeroLevel(){
        return this.heroLevel;
    }
    public void setHeroLevel(int heroLevel){
        this.heroLevel = heroLevel;
    }
}