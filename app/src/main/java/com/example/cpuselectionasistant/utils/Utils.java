package com.example.cpuselectionasistant.utils;

public class Utils {

    public static boolean isNumber(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != '.') return false;
        }
        return true;
    }
}
