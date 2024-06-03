package GameLogic;

import Characters.Player;

import java.util.Scanner;

public class TrapRoomQuest {
    public static void quest (Player player){
        Scanner scanner = new Scanner(System.in);

      int variableOne = (int) (Math.random()*21);
      int variableTwo = (int) (Math.random()*21);

      int result = variableOne-variableTwo;


        System.out.println("The calculation is " + variableOne + "-" +  variableTwo);
        int resultPlayer = scanner.nextInt();

        if (resultPlayer==result){
            System.out.println("That´s correct, clever little head");
        }else {
            System.out.println("MÖÖÖÖÖPPPPP that´s false - you lose 3 healt points");
            System.out.println("The correct answer is" + result);
            player.updateHealthPoints(-3);
        }
    }
}
