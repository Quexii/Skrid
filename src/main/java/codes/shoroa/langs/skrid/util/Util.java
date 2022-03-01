package codes.shoroa.langs.skrid.util;

import org.apache.commons.lang3.StringUtils;

public class Util {
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static String removeSpaces(String line) {
        String returningString;
        returningString = line.replaceAll("\\s", "");
        returningString = line.replaceAll("\\t", "");
        return returningString;
    }

    public static String getInBetweenParenthesis(String input) {
        return StringUtils.substringBetween(input, "(", ")");
    }

    public static String getInBetweenQuotes(String input) {
        return StringUtils.substringBetween(input, "'", "'");
    }

    public static String getInBetweenBrackets(String input) {
        return StringUtils.substringBetween(input, "{", "}");
    }
}
