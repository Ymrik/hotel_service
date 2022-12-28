package com.umarbariev.projects.hotel_service.util;

import java.sql.Date;

public class DateHelper {
    public static int getDaysBetweenDates(Date date1, Date date2) {
        var milliesDiff = date2.getTime() - date1.getTime();
        return (int)Math.floor(milliesDiff/1000/60/60/24);
    }
}
