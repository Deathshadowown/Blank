package wee.model;

import java.util.Random;
public class Rnd{
    Random random = new Random();
    public int randomNumber(){
        int rnNumber = 0;
        rnNumber = random.nextInt(10);
        return rnNumber;
    }
}