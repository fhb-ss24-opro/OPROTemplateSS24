package org.lecture.Characters;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String name;
    private int id;
    private String race;
    private String role;
    private int healthpoints;


    public Player(int id, String race, String role, int healthpoints, String name) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.role = role;
        this.healthpoints = healthpoints;
    }


    @Override
    public String toString() {
        return "ID: " + id + "\n" +
               "Name: " + name + "\n" +
               "Race: " + race + "\n" +
               "Role: " + role + "\n" +
               "Health Points: " + healthpoints;
    }


    public void updateHealthPoints(int change) {
        this.healthpoints += change;
        System.out.println(name + "'s updated health points: " + this.healthpoints);
    }


    public void checkHealthPoints() {
        if (healthpoints <= 0) {
            System.out.println(name + " has lost. Game over.");
            System.exit(0);
        }
    }
}
