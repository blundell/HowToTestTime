package com.blundell.tut.howtotesttime;

import org.junit.Assert;
import org.junit.Test;

public class WelcomeMessageGeneratorTest {

    @Test
    public void givenItIsBeforeMidday_thenRedMorningGreeting() throws Exception {
        WelcomeMessageGenerator generator = new WelcomeMessageGenerator();

        WelcomeMessage message = generator.generate();

        assertEquals(R.string.good_morning, R.color.morning_blue, message);
    }

    @Test
    public void givenItIsAfterMidday_thenBlueEveningGreeting() throws Exception {
        WelcomeMessageGenerator generator = new WelcomeMessageGenerator();

        WelcomeMessage message = generator.generate();

        assertEquals(R.string.good_evening, R.color.evening_red, message);
    }

    private void assertEquals(int textResId, int colorResId, WelcomeMessage message) {
        Assert.assertEquals("Wrong text resource id!", textResId, message.getTextResId());
        Assert.assertEquals("Wrong color resource id!", colorResId, message.getColorResId());
    }
}
