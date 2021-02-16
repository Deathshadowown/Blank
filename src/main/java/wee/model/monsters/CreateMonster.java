package wee.model.monsters;

import wee.model.monsters.Monster;
public class CreateMonster{
    public static Monster newMonster(String monsterName){
        switch (monsterName) {
            case "Dragon":
                return (new Dragon(monsterName));
            case "Orge":
                return (new Dragon(Orge));
            case "Bat":
                return (new Bat(Orge));
            case "Skeleton":
                return (new Skeleton(Orge));
            default:
                break;
        }
        return null;
    }
}