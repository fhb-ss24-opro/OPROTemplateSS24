package org.lecture;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        FurnitureOrderService furnitureOrderService = new FurnitureOrderService();
        // furnitureOrderService.orderFurniture();

        zonedDateTime();
        //localDateTime();


    }

    private static void zonedDateTime() {
        ZonedDateTime zdt = ZonedDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(dtf.format(zdt));
        dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(dtf.format(zdt));
        dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        System.out.println(dtf.format(zdt));
        dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        System.out.println(dtf.format(zdt));
    }

    private static void localDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                        .withLocale(Locale.UK));
        System.out.println(localDateTime);
        localDateTime
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                        .withLocale(Locale.UK));
        System.out.println(localDateTime);

        localDateTime
                .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                        .withLocale(Locale.UK));
        System.out.println(localDateTime);
    }
}