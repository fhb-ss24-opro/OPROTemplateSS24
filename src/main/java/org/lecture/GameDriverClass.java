package org.lecture;

import org.lecture.Characters.Player;
import org.lecture.Filehandler.FileReader;
import org.lecture.rooms.RoomManager;

import java.util.HashMap;
import java.util.Scanner;

public class GameDriverClass {
    static HashMap<Integer, Player> playerHashMap = new HashMap<>();

    public static void main(String[] args) {
        playerHashMap = FileReader.readFile("chars.csv");

        System.out.println(AsciiStringHelper.sword);
        System.out.println("""
                ===========================
                WELCOME TO THE OPRO DUNGEON
                ==========================="""
        );
        System.out.println();
        System.out.println();
        System.out.println("First choose your character");
        System.out.println();

        if (playerHashMap.isEmpty()) {
            System.out.println("No player data found.");
        } else {
            for (Integer i : playerHashMap.keySet()) {
                System.out.println(playerHashMap.get(i).toString());
            }
        }

        System.out.println("Note that the different health points determine the level of difficulty.");
        System.out.println("Which character will you choose? 1, 2 or 3?");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        Player player = playerHashMap.get(choice);

        if (player != null) {
            System.out.println("You have selected: " + player);
            if (player.getHealthpoints() <= 0) {
                player.setHealthpoints(12);
            }
        } else {
            System.out.println("Invalid choice. Please select a valid character.");
            return;
        }

        System.out.println("How many rooms should the game have (minimum 5)?");
        int totalRooms = scanner.nextInt();
        totalRooms = Math.max(totalRooms, 5);

        System.out.println("How many villagers should be in each ordinary room?");
        int numVillagers = scanner.nextInt();

        System.out.println("How many farmers should be in each ordinary room?");
        int numFarmers = scanner.nextInt();

        RoomManager roomManager = new RoomManager(totalRooms, numVillagers, numFarmers);
        roomManager.startGame(player);
    }
}
