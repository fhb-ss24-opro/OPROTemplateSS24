package Rooms;

import Characters.Farmer;
import Characters.NPC;
import Characters.Player;
import Characters.Villager;

import java.util.ArrayList;
import java.util.List;

public class OrdinaryRoom extends Room {
    private List<NPC> npcs;

    public OrdinaryRoom(int numVillagers, int numFarmers) {
        npcs = new ArrayList<>();
        for (int i = 0; i < numVillagers; i++) {
            npcs.add(new Villager());
        }
        for (int i = 0; i < numFarmers; i++) {
            npcs.add(new Farmer());
        }
    }

    @Override
    public void enter() {
        System.out.println("You enter an ordinary room and listen to the guests.");
        for (NPC npc : npcs) {
            npc.speak();
        }
    }

    @Override
    public boolean surviveRoom(Player player) {
        enter();
        return true;
    }
}
