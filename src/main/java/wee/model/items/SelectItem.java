package wee.model.items;

import wee.model.items.Items;
public class SelectItem{
    public static Items newItem(String itemType, String itemName){
        if (itemType.toLowerCase().equals("weapon")){
            return (new Weapons(itemName));
        }else if (itemType.toLowerCase().equals("armor")){
            return (new Armor(itemName));
        }else if (itemType.toLowerCase().equals("helm")){
            return (new Helm(itemName));
        }else if (itemType.toLowerCase().equals("potion")){
            return (new Potion(itemName));
        }
        return null;
    }
}