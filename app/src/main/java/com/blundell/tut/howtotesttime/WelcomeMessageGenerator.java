package com.blundell.tut.howtotesttime;

import java.util.Calendar;
import java.util.Date;

public class WelcomeMessageGenerator {

    private static final WelcomeMessage AM_INFO = new WelcomeMessage(R.string.good_morning, R.color.morning_blue);
    private static final WelcomeMessage PM_INFO = new WelcomeMessage(R.string.good_evening, R.color.evening_red);

    private final Clock clock;

    public WelcomeMessageGenerator(Clock clock) {
        this.clock = clock;
    }

    public WelcomeMessage generate() {
        Date now = new Date(clock.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date midday = calendar.getTime();
        if (now.after(midday)) {
            return PM_INFO;
        } else {
            return AM_INFO;
        }
    }

}
