package com.plataforma_digital.utils;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DateUtils {
    public static boolean validateDate(String date) {
        if (date == null || date.isEmpty()) {
            return false;
        }
        final String DATE_PATTERN = "^((0[1-9]|[12][0-9]|3[01])/(0[13578]|1[02])|((0[1-9]|[12][0-9]|30)/(0[469]|11))|((0[1-9]|[12][0-9])/02))/\\d{4}$";
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
}
