package com.phapquang.sala.ui.widgets;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

import com.phapquang.sala.services.MeditationListener;

import java.util.Calendar;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class CountDown extends TextView implements MeditationListener {
    public CountDown(Context context) {
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

    public CountDown(Context context, AttributeSet attrs) {
        super(context, attrs);

        setupClock();
    }

    public CountDown(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        setupClock();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}