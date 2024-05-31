package Rooms;

import Characters.Player;
import GameLogic.DwarfDrinkingGame;


public class TavernRoom extends Room {

    @Override
    public void enter() {
        System.out.println("You enter the tavern and are challenged to a drinking game.");
    }

    @Override
    public boolean surviveRoom(Player player) {
        enter();
        DwarfDrinkingGame.startDrinkGame(player);
        return player.getHealthpoints() > 0;
    }
}