package org.lecture.rooms;

import org.lecture.Characters.Player;
import org.lecture.gamelogic.StoneScissorPaper;

public class MagicRoom extends Room {

    @Override
    public void enter() {
        System.out.println("You enter a magical room");
        System.out.println("A wizard appears and challenges you to a round of rock, scissors, paper, lizard, spock.");
    }

    @Override
    public boolean surviveRoom(Player player) {
        enter();
        StoneScissorPaper.playBestOfThree(player);
        player.checkHealthPoints();
        return player.getHealthpoints() > 0;
    }
}