package org.lecture.gamelogic;

import org.lecture.Characters.Player;

import java.util.Random;
import java.util.Scanner;

public class StoneScissorPaper {
    public static void playBestOfThree(Player player) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] choices = {"Rock", "Scissors", "Paper", "Lizard", "Spock"};

        int userScore = 0;
        int computerScore = 0;

        while (userScore < 3 && computerScore < 3) {
            System.out.println("Choose: Rock, Scissors, Paper, Lizard, Spock");
            if (!scanner.hasNextLine()) {
                System.out.println("No input detected. Exiting the game.");
                return;
            }
            String userChoice = scanner.nextLine();
            String computerChoice = choices[random.nextInt(choices.length)];

            System.out.println("Computer chose: " + computerChoice);
            String result = determineWinner(userChoice, computerChoice);
            System.out.println(result);

            if (result.contains("You win!")) {
                userScore++;
                player.updateHealthPoints(3);
            } else if (result.contains("Computer wins!")) {
                computerScore++;
                player.updateHealthPoints(-5);
            } else {

            }

            System.out.println("Score: You " + userScore + " : Computer " + computerScore);
        }

        System.out.println("Final health points: " + player.getHealthpoints());
    }

    private static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equalsIgnoreCase(computerChoice)) {
            return "It's a draw!";
        }

        switch (userChoice.toLowerCase()) {
            case "rock":
                return (computerChoice.equalsIgnoreCase("Scissors") || computerChoice.equalsIgnoreCase("Lizard")) ? "You win!" : "Computer wins!";
            case "scissors":
                return (computerChoice.equalsIgnoreCase("Paper") || computerChoice.equalsIgnoreCase("Lizard")) ? "You win!" : "Computer wins!";
            case "paper":
                return (computerChoice.equalsIgnoreCase("Rock") || computerChoice.equalsIgnoreCase("Spock")) ? "You win!" : "Computer wins!";
            case "lizard":
                return (computerChoice.equalsIgnoreCase("Spock") || computerChoice.equalsIgnoreCase("Paper")) ? "You win!" : "Computer wins!";
            case "spock":
                return (computerChoice.equalsIgnoreCase("Scissors") || computerChoice.equalsIgnoreCase("Rock")) ? "You win!" : "Computer wins!";
            default:
                return "Invalid input. Please choose Rock, Scissors, Paper, Lizard, or Spock.";
        }
    }
}
