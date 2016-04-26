package com.blundell.tut.howtotesttime;

import java.util.Calendar;
import java.util.Date;

public class WelcomeMessageGenerator {

    private static final WelcomeMessage AM_INFO = new WelcomeMessage(R.string.good_morning, R.color.morning_blue);
    private static final WelcomeMessage PM_INFO = new WelcomeMessage(R.string.good_evening, R.color.evening_red);

    public WelcomeMessage generate() {
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
