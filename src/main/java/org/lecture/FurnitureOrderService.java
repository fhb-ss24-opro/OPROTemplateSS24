package org.lecture;

import org.lecture.factory.AbstractFactory;
import org.lecture.factory.Chair;
import org.lecture.factory.Couch;

import java.util.Scanner;

public class FurnitureOrderService {
    /**
     * This method decides through the AbstractFacotry, which furniture can be ordered. The User inputs the furniture
     * type and accoridng to the furniture type, the correct Factory is used.
     */
    public void orderFurniture() {
        do {
            AbstractFactory factory = null;

            System.out.println("Order furniture");
            System.out.println("Enter the furniture type");
            System.out.println("V - Victorian");
            System.out.println("M - Modern");
            Scanner scanner = new Scanner(System.in);
            String furnitureType = scanner.nextLine().toUpperCase();

            //TODO add decision-branches

            Couch couch;
            Chair chair;

            if (factory != null) {
                chair = factory.createChair();
                couch = factory.createCouch();
                chair.sitOn();
                System.out.println("The couch has " + couch.getNumberOfLegs() + " legs");
            }

        } while (true);
    }
}
