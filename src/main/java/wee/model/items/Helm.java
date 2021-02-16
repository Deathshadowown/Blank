package wee.model.items;

public class Helm extends Items{
    public Helm(String itemName){
        super("Helm", itemName);
        if(itemName.toLowerCase().equals("dragonhelm")){
            this.defence = 75;
        }else if (itemName.toLowerCase().equals("bonehelm")){
            this.defence = 40;
        }else if (itemName.toLowerCase().equals("orgehelm")){
            this.defence = 50;
        }else if (itemName.toLowerCase().equals("bathelm")){
            this.defence = 30;
        }
    }
}