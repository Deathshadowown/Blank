package wee.model.monsters;

import wee.model.monsters.Monster;
public class CreateMonster{
    public static Monster newMonster(String monsterName){
        switch (monsterName) {
            case "Dragon":
                return (new Dragon());
            case "Orge":
                return (new Orge());
            case "Bat":
                return (new Bat());
            case "Skeleton":
                return (new Skeleton());
            default:
                break;
        }
        return null;
    }
}