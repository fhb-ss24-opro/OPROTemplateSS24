package org.lecture.rooms;

import java.util.concurrent.ThreadLocalRandom;

public class RoomFactory {

    public Room createRoom(int numVillagers, int numFarmers) {
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 22);
        if (randomNumber % 5 == 0) {
            return new MagicRoom();
        } else if (randomNumber % 4 == 0) {
            return new TavernRoom();
        } else if (randomNumber % 3 == 0) {
            return new OrdinaryRoom(numVillagers, numFarmers);
        } else {
            return new TrapRoom();
        }
    }
}
