package Rooms;

import Characters.Player;
import GameLogic.TrapRoomQuest;

public class TrapRoom extends Room {

    @Override
    public void enter() {
        System.out.println("Oh oh... you are trapped... To survive this room, you have to solve a math problem.");
        System.out.println("It looks like you've landed in a room full of traps. A trap room??");
    }

    @Override
    public boolean surviveRoom(Player player) {
        enter();
        TrapRoomQuest.quest(player);
        return player.getHealthpoints() > 0;
    }
}