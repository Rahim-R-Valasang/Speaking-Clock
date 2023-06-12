package com.example.clockproject.clock.service;



import com.example.clockproject.clock.utility.NumberToWords;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class TimeConverterService {
    public String convertTimeToWords(LocalTime time) {
        int hour = time.getHour();
        int minute = time.getMinute();

        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Invalid time provided.");
        }

        if (hour == 12 && minute == 00) {
            return "It's Midday";
        } else if (hour == 00 && minute == 00) {
            return "It's Midnight";
        }

        String hourInWords = NumberToWords.convertNumberToWords(hour);
        String minuteInWords = NumberToWords.convertNumberToWords(minute);

        StringBuilder sb = new StringBuilder();
        sb.append("It's ");
        sb.append(hourInWords);
        sb.append(" ");
        sb.append(getMinuteWord(minute));

        return sb.toString();
    }

    private String getMinuteWord(int minute) {
        if (minute == 0) {
            return "o'clock";
        } else if (minute < 10) {
            return "oh " + NumberToWords.convertNumberToWords(minute);
        } else {
            return NumberToWords.convertNumberToWords(minute);
        }
    }
}




