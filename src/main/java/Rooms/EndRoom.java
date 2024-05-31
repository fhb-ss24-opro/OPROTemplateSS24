package Rooms;

import Characters.Player;

public class EndRoom extends Room {

    @Override
    public void enter() {
        System.out.println("You have entered the End Room. The journey is almost over.");
    }

    @Override
    public boolean surviveRoom(Player player) {
        enter();

        return true;
    }
}
