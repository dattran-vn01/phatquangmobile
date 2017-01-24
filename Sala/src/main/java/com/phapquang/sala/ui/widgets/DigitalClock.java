package com.phapquang.sala.ui.widgets;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class DigitalClock extends TextView {
    public DigitalClock(Context context) {
        super(context);

        setupClock();
    }

    private void setupClock() {
        new Timer().scheduleAtFixedRate(new TimerTask() {
            Handler mHandler = new Handler();

            @Override
            public void run() {
                mHandler.post(new Runnable() {
                    public void run() {
                        Calendar mCalendar = Calendar.getInstance();
                        int hours = mCalendar.get(Calendar.HOUR_OF_DAY);
                        int minutes = mCalendar.get(Calendar.MINUTE);
                        int seconds = mCalendar.get(Calendar.SECOND);

                        setText(String.format(Locale.ENGLISH, "%02d:%02d:%02d", hours, minutes, seconds));
                    }
                });
            }
        }, 0, 1000);
    }

    public DigitalClock(Context context, AttributeSet attrs) {
        super(context, attrs);

        setupClock();
    }

    public DigitalClock(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        setupClock();
    }
}