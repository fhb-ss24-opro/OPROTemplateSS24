package GameLogic;

import Characters.Player;

import java.util.Random;
import java.util.Scanner;

public class DwarfDrinkingGame {
    public static void startDrinkGame(Player player) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int playerRoll = random.nextInt(20) + 1;
        int dwarfRoll = random.nextInt(20) + 1;

        System.out.println("Rolling d20...");
        System.out.println("Your roll: " + playerRoll);
        System.out.println("Dwarf's roll: " + dwarfRoll);

        if (playerRoll < dwarfRoll) {
            System.out.println("Weakling... you lose 3 health points ");
            player.updateHealthPoints(-3);
        } else {
            System.out.println("You win, you lucky pig!");
            System.out.println(player.getName() + " leaves the Room for his next adventure");
        }

        player.checkHealthPoints();
    }
}
