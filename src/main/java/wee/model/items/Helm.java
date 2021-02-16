package wee.model.items;

public class Helm extends Items{
    public Helm(String itemName){
        super("Helm", itemName);
        if (itemName.toLowerCase().equals("defaulthelm")){
            this.health = 15;
        }else if(itemName.toLowerCase().equals("dragonhelm")){
            this.health = 75;
        }else if (itemName.toLowerCase().equals("bonehelm")){
            this.health = 40;
        }else if (itemName.toLowerCase().equals("orgehelm")){
            this.health = 50;
        }else if (itemName.toLowerCase().equals("bathelm")){
            this.health = 30;
        }
    }
}