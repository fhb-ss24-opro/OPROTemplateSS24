package org.lecture.rooms;

import org.lecture.Characters.Player;
import org.lecture.gamelogic.DwarfDrinkingGame;


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