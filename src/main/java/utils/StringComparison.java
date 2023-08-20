package utils;

public class StringComparison {
    public static String[] findShortestAndLongestLine(String data) {
        String[] lines = data.split("\n");
        String shortestString = null;
        String longestString = null;
        String[] shortestAndLongest = new String[10000];

        for (String line : lines) {
            if (shortestString == null || line.length() < shortestString.length()) {
                shortestString = line;
                shortestAndLongest[0] = shortestString;
            }
            if (longestString == null || line.length() > longestString.length()) {
                longestString = line;
                shortestAndLongest[1] = longestString;
            }
        }

        return shortestAndLongest;

    }
}