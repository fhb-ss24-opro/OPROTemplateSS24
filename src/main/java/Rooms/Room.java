package Rooms;

import Characters.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Room {
    private Room nextRoom;

    public abstract boolean surviveRoom(Player player);

    public abstract void enter();
}
