package org.lecture.rooms;

import org.lecture.Characters.Player;
import org.lecture.AsciiStringHelper;
import java.util.ArrayList;
import java.util.List;

public class RoomManager {
    private List<Room> rooms;
    private Room startRoom;
    private Room endRoom;

    public RoomManager(int totalRooms, int numVillagers, int numFarmers) {
        rooms = new ArrayList<>();
        RoomFactory factory = new RoomFactory();


        startRoom = new StartRoom();
        rooms.add(startRoom);


        for (int i = 0; i < totalRooms - 2; i++) {
            Room room = factory.createRoom(numVillagers, numFarmers);
            rooms.add(room);
        }


        endRoom = new EndRoom();
        rooms.add(endRoom);


        for (int i = 0; i < rooms.size() - 1; i++) {
            rooms.get(i).setNextRoom(rooms.get(i + 1));
        }
    }

    public void startGame(Player player) {
        Room currentRoom = startRoom;
        while (currentRoom != null) {
            boolean survived = currentRoom.surviveRoom(player);
            if (!survived) {
                System.out.println(AsciiStringHelper.graveyard);
                return;
            }
            if (currentRoom instanceof EndRoom) {
                if (player.getHealthpoints() >= 10) {
                    System.out.println(AsciiStringHelper.firework);
                } else {
                    System.out.println(player.getName() + " has survived with " + player.getHealthpoints() + " health points.");
                }
                return;
            }
            currentRoom = currentRoom.getNextRoom();
        }
    }
}
