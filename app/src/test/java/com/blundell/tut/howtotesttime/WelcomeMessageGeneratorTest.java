package com.blundell.tut.howtotesttime;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

public class WelcomeMessageGeneratorTest {

    @Test
    public void givenItIsBeforeMidday_thenRedMorningGreeting() throws Exception {
        SettableClock clock = new SettableClock();
        clock.time = getHourMinuteSecondAsTimeInMillis(11, 59, 59);
        WelcomeMessageGenerator generator = new WelcomeMessageGenerator(clock);

        WelcomeMessage message = generator.generate();

        assertEquals(R.string.good_morning, R.color.morning_blue, message);
    }

    @Test
    public void givenItIsAfterMidday_thenBlueEveningGreeting() throws Exception {
        SettableClock clock = new SettableClock();
        clock.time = getHourMinuteSecondAsTimeInMillis(12, 0, 1);
        WelcomeMessageGenerator generator = new WelcomeMessageGenerator(clock);

        WelcomeMessage message = generator.generate();

        assertEquals(R.string.good_evening, R.color.evening_red, message);
    }

    @Test
    public void givenItIsMidday_thenRedMorningGreeting() throws Exception {
        SettableClock clock = new SettableClock();
        clock.time = getHourMinuteSecondAsTimeInMillis(12, 0, 0);
        WelcomeMessageGenerator generator = new WelcomeMessageGenerator(clock);

        WelcomeMessage message = generator.generate();

        assertEquals(R.string.good_morning, R.color.morning_blue, message);
    }

    private long getHourMinuteSecondAsTimeInMillis(int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        return calendar.getTimeInMillis();
    }

    private void assertEquals(int textResId, int colorResId, WelcomeMessage message) {
        Assert.assertEquals("Wrong text resource id!", textResId, message.getTextResId());
        Assert.assertEquals("Wrong color resource id!", colorResId, message.getColorResId());
    }

    private class SettableClock extends Clock {
        private long time;

        @Override
        public long currentTimeMillis() {
            return time;
        }
    }
}
