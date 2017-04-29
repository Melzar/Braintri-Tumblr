package com.matuszew.braintri_tumblr.common.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by matuszewski on 29/04/2017.
 */

public class DateFormatter {

    public static String formatDateFromString(String sourceFormat, String targetFormat, String date){
        try {
            return new SimpleDateFormat(targetFormat)
                    .format(new SimpleDateFormat(sourceFormat).parse(date));
        } catch (ParseException e) {
            e.printStackTrace(); // TODO add integration with error notificator like rollbar or
            return "";           // something similar
        }
    }
}
