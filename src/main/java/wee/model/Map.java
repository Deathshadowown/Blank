package wee.model;

import java.util.Random;
public class Map{
    private char map[][];
    private int mapSize;
    private Random monsterRandom = new Random();
    public void generateMap(int playerLevel) {
		map = null;
		mapSize = (playerLevel - 1) * 5 + 10 - (playerLevel % 2);
		map = new char[mapSize][mapSize];
        int i = 0;
        int j = 0;
        while (i < mapSize)
        {
            while (j < mapSize)
            {
                map[i][j] = 'O';
                j++;
            }
            j = 0;
            i++;
        }
    }

    public void printMap(){
        int i = 0;
        int j = 0;
        while (i < map.length){
            while(j < map[i].length){
                if (map[i][j] == 'E'){
                    System.out.print("\u001B[31m"+map[i][j]+" "+"\u001B[37m");
                }else if (map[i][j] == 'P'){
                    System.out.print("\u001B[34m"+map[i][j]+" "+"\u001B[37m");
                }else
                    System.out.print(map[i][j]+" ");
                j++;
            }
            System.out.println();
            j = 0;
            i++;
        }
    }

    public void addPlayerToMap(){
        map[(int) Math.ceil(mapSize / 2)][(int) Math.ceil(mapSize / 2)] = 'P';
    }
    public void addMonstersToMap(){
        int i = 0;
        int j = 0;
        int monsterLocation;
        while(i < mapSize){
            while (j < mapSize){
                monsterLocation = monsterRandom.nextInt(100);
                if(monsterLocation >= 50){
                    map[i][j] = 'E';
                }
                j++;
            }
            j = 0;
            i++;
        }
    }

    public int[] findPlayerOnMap(){
        int[] playerPosition = new int[2];
        int y = 0;
        int x = 0;
        int count = 0;
        while(y < map.length){
            while(x < map[y].length){
                if(map[y][x] == 'P'){
                    playerPosition[0] = y;
                    playerPosition[1] = x;
                    count++;
                    break;
                }
                x++;
            }
            if (count == 1)
            break;
            x = 0;
            y++;
        }
        return playerPosition;
    }

    public int moveNorth(){
        // findPlayerOnMapMoveNorth();
        try {
            int[] playerLocation = new int[2];
            playerLocation = findPlayerOnMap();
            int count;
            //Moves North
            if (map[playerLocation[0] - 1][playerLocation[1]] == 'O'){
                map[playerLocation[0] - 1][playerLocation[1]] = 'P';
                map[playerLocation[0]][playerLocation[1]] = 'O';
                count = 1;
                return count;
            }else if (map[playerLocation[0] - 1][playerLocation[1]] == 'E'){
                count = 2;
                return count;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[32m"+"Game won\u001B[37m");
        } catch (Exception e) {
            //TODO: handle exception
        }
        return 0;
    }
    public void afterMoveNorth(){
        try {
            int[] playerLocation = new int[2];
            playerLocation = findPlayerOnMap();
    
            map[playerLocation[0] - 1][playerLocation[1]] = 'P';
            map[playerLocation[0]][playerLocation[1]] = 'O';         
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[32m"+"Game won\u001B[37m");
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public int moveSouth(){
        // findPlayerOnMapMoveSouth();
        try {
            int[] playerLocation = new int[2];
            playerLocation = findPlayerOnMap();
            int count;
            //Moves North
            if (map[playerLocation[0] + 1][playerLocation[1]] == 'O'){
                map[playerLocation[0] + 1][playerLocation[1]] = 'P';
                map[playerLocation[0]][playerLocation[1]] = 'O';
                count = 1;
                return count;
            }else if (map[playerLocation[0] + 1][playerLocation[1]] == 'E'){
                count = 2;
                return count;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[32m"+"Game won\u001B[37m");
        } catch (Exception e) {
            //TODO: handle exception
        }
        return 0;
    }

    public void afterMoveSouth(){
        try {
            int[] playerLocation = new int[2];
            playerLocation = findPlayerOnMap();
    
            map[playerLocation[0] + 1][playerLocation[1]] = 'P';
            map[playerLocation[0]][playerLocation[1]] = 'O';       
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[32m"+"Game won\u001B[37m");
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public int moveEast(){
        try {
            int[] playerLocation = new int[2];
            playerLocation = findPlayerOnMap();
            int count;
            //Moves East
            if (map[playerLocation[0]][playerLocation[1] + 1] == 'O'){
                map[playerLocation[0]][playerLocation[1] + 1] = 'P';
                map[playerLocation[0]][playerLocation[1]] = 'O';
                count = 1;
                return count;
            }else if (map[playerLocation[0]][playerLocation[1] + 1] == 'E'){
                count = 2;
                return count;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[32m"+"Game won\u001B[37m");
        } catch (Exception e) {
            //TODO: handle exception
        }
        return 0;
    }

    public void afterMoveEast(){
        try {
            int[] playerLocation = new int[2];
            playerLocation = findPlayerOnMap();
    
            map[playerLocation[0]][playerLocation[1] + 1] = 'P';
            map[playerLocation[0]][playerLocation[1]] = 'O';     
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[32m"+"Game won\u001B[37m");
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public int moveWest(){
        try {
            int[] playerLocation = new int[2];
            playerLocation = findPlayerOnMap();
            int count;
            //Moves West
            if (map[playerLocation[0]][playerLocation[1] - 1] == 'O'){
                map[playerLocation[0]][playerLocation[1] - 1] = 'P';
                map[playerLocation[0]][playerLocation[1]] = 'O';
                count = 1;
                return count;
            }else if (map[playerLocation[0]][playerLocation[1] - 1] == 'E'){
                count = 2;
                return count;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[32m"+"Game won\u001B[37m");
        } catch (Exception e) {
            //TODO: handle exception
        }
        return 0;
    }

    public void afterMoveWest(){
        try {
            int[] playerLocation = new int[2];
            playerLocation = findPlayerOnMap();
    
            map[playerLocation[0]][playerLocation[1] - 1] = 'P';
            map[playerLocation[0]][playerLocation[1]] = 'O';
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[32m"+"Game won\u001B[37m");
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}