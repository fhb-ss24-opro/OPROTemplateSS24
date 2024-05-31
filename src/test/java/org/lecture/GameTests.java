package org.lecture;

import Characters.Player;
import org.junit.jupiter.api.Test;
import Rooms.*;

import static org.junit.jupiter.api.Assertions.*;

class GameTests {

    @Test
    void testPlayerHealthPointsUpdate() {
        Player player = new Player(1, "Orc", "Warrior", 12, "Cell");
        player.updateHealthPoints(-3);
        assertEquals(9, player.getHealthpoints(), "Health points should be updated correctly.");
    }

    @Test
    void testPlayerSurvivesMagicRoom() {
        Player player = new Player(2, "Human", "Warlock", 14, "Lucifer");
        Room magicRoom = new MagicRoom();
        assertTrue(magicRoom.surviveRoom(player), "Player should survive the magic room.");
    }


    @Test
    void testPlayerSurvivesTrapRoomWithCorrectAnswer() {
        Player player = new Player(1, "Elf", "Archer", 10, "Legolas");
        Room trapRoom = new TrapRoom();
        // Simulate correct answer in quest
        assertTrue(trapRoom.surviveRoom(player), "Player should survive the trap room with a correct answer.");
    }

    @Test
    void testRoomFactoryCreatesCorrectRooms() {
        RoomFactory factory = new RoomFactory();
        Room room = factory.createRoom(2, 2);
        assertNotNull(room, "Room should be created by factory.");
    }
}
