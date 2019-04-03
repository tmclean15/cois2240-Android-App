package ca.cois2240group20.grocerymanagementapp.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class Utility {

    private Utility() {
        // Utility class should not be instantiated
    }

    public static double tryParseDouble(String str) {
        if (str != null) {
            try {
                return Double.parseDouble(str);
            } catch (Exception e) {
                return 0;
            }
        } else return 0;
    }

    public static int tryParseInt(String str) {
        if (str != null) {
            try {
                return Integer.parseInt(str);
            } catch (Exception e) {
                return 0;
            }
        } else return 0;
    }

    public static Date tryParseDate(String str) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        if (str != null) {
            try {
                return dateFormat.parse(str);
            } catch (Exception e) {
                return null;
            }
        } else return null;
    }

    public static String trySetString(String str) {
        if (str == null) return "";
        else return str;
    }

    public static String trySetDateString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        if (date == null) return "";
        else {
            try {
                return dateFormat.format(date);
            } catch (Exception e) {
                return "";
            }
        }

    }
}
