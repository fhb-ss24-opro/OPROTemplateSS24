package Rooms;

import Characters.Player;

public class StartRoom extends Room {

    @Override
    public void enter() {
        System.out.println("A mighty and new Player entered the game. Let the games begin!");
    }

    @Override
    public boolean surviveRoom(Player player) {
        enter();
        return true;
    }
}