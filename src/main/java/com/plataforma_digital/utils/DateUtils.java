package com.plataforma_digital.utils;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DateUtils {
    public static boolean validateDate(String date) {
        final String DATE_PATTERN = "^\\d{2}/\\d{2}/\\d{4}$";
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
}
