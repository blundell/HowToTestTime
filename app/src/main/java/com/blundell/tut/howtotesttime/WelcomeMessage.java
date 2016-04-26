package com.blundell.tut.howtotesttime;

import android.support.annotation.ColorInt;
import android.support.annotation.StringRes;

public class WelcomeMessage {
    @StringRes
    private final int textResId;

    @ColorInt
    private final int colorResId;

    public WelcomeMessage(int textResId, int colorResId) {
        this.textResId = textResId;
        this.colorResId = colorResId;
    }

    public int getTextResId() {
        return textResId;
    }

    public int getColorResId() {
        return colorResId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WelcomeMessage)) {
            return false;
        }

        WelcomeMessage that = (WelcomeMessage) o;

        return textResId == that.textResId && colorResId == that.colorResId;

    }

    @Override
    public int hashCode() {
        int result = textResId;
        result = 31 * result + colorResId;
        return result;
    }
}
