package com.sj.tc.service;

import com.sj.tc.exception.BadDataError;
import com.sj.tc.model.TalkingClock;

public class TalkingClockService {
    private static final int MAX_HOURS = 23;
    private static final int MAX_MINUTE = 59;
    String timeRegex = "^\\d{1,2}:\\d{1,2}$";

    public TalkingClock createTakingClock(String time) {
        String[] timeData = validate(time.trim());
        TalkingClock tc = new TalkingClock(timeData[0], timeData[1]);
        return tc;
    }

    private String[] validate(String time) {
        if (!time.matches(timeRegex)) {
            throw new BadDataError("Input data is invalid: " + time);
        }

        String[] timeData = time.split(":");

        if (isHourOutOfRange(timeData[0]) || isMinutesOutOfRange(timeData[1])) {
            throw new BadDataError("Input data is invalid: " + time);
        }
        return timeData;
    }

    private boolean isHourOutOfRange(String hour) {
        return Integer.parseInt(hour) > MAX_HOURS;
    }

    private boolean isMinutesOutOfRange(String minute) {
        return Integer.parseInt(minute) > MAX_MINUTE;
    }
}
