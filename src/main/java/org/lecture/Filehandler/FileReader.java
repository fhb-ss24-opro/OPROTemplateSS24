package org.lecture.Filehandler;

import org.lecture.Characters.Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class FileReader {

    public static HashMap<Integer, Player> readFile(String fileName) {
        Path path = Paths.get("src", "main", "resources", fileName);
        HashMap<Integer, Player> playerHashMap = new HashMap<>();

        if (Files.notExists(path)) {
            System.err.println("Path not found: " + path);
            return playerHashMap;
        }

        try (BufferedReader br = Files.newBufferedReader(path)) {
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                if (split.length < 5) {
                    continue;
                }

                try {
                    int id = Integer.parseInt(split[0]);
                    String name = split[1];
                    String race = split[2];
                    String role = split[3];
                    int healthPoints = Integer.parseInt(split[4]);

                    Player player = new Player(id, race, role, healthPoints, name);
                    playerHashMap.put(id, player);
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing integer from file: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return playerHashMap;
    }
}