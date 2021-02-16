package wee.model.items;

public class Weapons extends Items{
    public Weapons(String itemName){
        super("Weapon", itemName);
        if (itemName.toLowerCase().equals("defaultSword")){
            this.attack = 2;
        }else if(itemName.toLowerCase().equals("dragonsword")){
            this.attack = 20;
        }else if (itemName.toLowerCase().equals("bonesword")){
            this.attack = 10;
        }else if (itemName.toLowerCase().equals("orgesword")){
            this.attack = 15;
        }else if (itemName.toLowerCase().equals("batsword")){
            this.attack = 5;
        }
    }
}