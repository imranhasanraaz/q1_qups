package utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class DayNumber {
    public static int getDayNumber() {

        LocalDate currentDate = LocalDate.now();
        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        String dayName = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault());
        return switch (dayName.toLowerCase()) {
            case "saturday" -> 0;
            case "sunday" -> 1;
            case "monday" -> 2;
            case "tuesday" -> 3;
            case "wednesday" -> 4;
            case "thursday" -> 5;
            case "friday" -> 6;
            default -> -1;
        };
    }
}