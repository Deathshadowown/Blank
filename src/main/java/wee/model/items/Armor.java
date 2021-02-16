package wee.model.items;

public class Armor extends Items{
    public Armor(String itemName){
        super("Armor", itemName);
        if(itemName.toLowerCase().equals("dragonarmor")){
            this.defence = 20;
        }else if (itemName.toLowerCase().equals("bonearmor")){
            this.defence = 10;
        }else if (itemName.toLowerCase().equals("orgearmor")){
            this.defence = 15;
        }else if (itemName.toLowerCase().equals("batarmor")){
            this.defence = 5;
        }
    }
}