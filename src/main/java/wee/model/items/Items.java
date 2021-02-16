package wee.model.items;

public class Items{
    private String itemName = null;
    private String itemType = null;
    protected int attack;
    protected int defence;
    protected int health;

    public Items(String itemType,String itemName){
        this.itemType = itemType;
        this.itemName = itemName;
    }

    //Set ItemName
    public String getItemName(){
        return this.itemName;
    }
    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    //Set ItemType
    public String getItemType(){
        return this.itemType;
    }
    public void setItemType(String itemType){
        this.itemType = itemType;
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

}