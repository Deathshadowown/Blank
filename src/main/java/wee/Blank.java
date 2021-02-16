package wee;

import java.util.Scanner;
import wee.controller.Game_Controller;
public class Blank 
{
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);
        //Choice between gui or console
        //Console will be implemented first
        byte choice;
        System.out.println();
        while(true){
            System.out.print("Select 1 for Console or 2 for Gui: ");
            choice = scan.nextByte();
            if (choice == 1){
                System.out.println("You picked Console");
                new Game_Controller(choice);
                scan.close();
                break;
            }else if (choice == 2){
                System.out.println("You picked Gui");
                new Game_Controller(choice);
                scan.close();
                break;
            }

        }

    }
}