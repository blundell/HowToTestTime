package com.blundell.tut.howtotesttime;

import java.util.Calendar;
import java.util.Date;

public class InformationCalculator {

    private static final Information AM_INFO = new Information(R.string.good_morning, R.color.morning_blue);
    private static final Information PM_INFO = new Information(R.string.good_evening, R.color.evening_red);

    public Information calculate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date now = new Date(System.currentTimeMillis());
        Date midday = calendar.getTime();
        if (now.after(midday)) {
            return PM_INFO;
        } else {
            return AM_INFO;
        }
    }

}
