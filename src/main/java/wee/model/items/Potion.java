package wee.model.items;

public class Potion extends Items{
    public Potion(String itemName){
        super("Potion", itemName);
        if(itemName.toLowerCase().equals("healingpotion")){
            this.health = 30;
        }else if (itemName.toLowerCase().equals("greaterhealingpotion")){
            this.defence = 50;
        }else if (itemName.toLowerCase().equals("superiorhealingpotion")){
            this.defence = 75;
        }else if (itemName.toLowerCase().equals("supremehealingpotion")){
            this.defence = 100;
        }
    }
}