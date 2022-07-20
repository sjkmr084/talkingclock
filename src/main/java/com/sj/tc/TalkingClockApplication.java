package com.sj.tc;

import com.sj.tc.service.TalkingClockService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.Optional;

public class TalkingClockApplication {

  public static void main(String[] args) throws IOException {

    TalkingClockService talkingClockService = new TalkingClockService();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String input = bufferedReader.readLine();
    Optional.of(input).ifPresentOrElse(data -> {
      if (input.isEmpty()) {
        printCurrentTimeInReadableFormat(talkingClockService);
      } else {
        printGivenTimeInReadableFormat(talkingClockService, data);
      }
    }, () -> {
      printCurrentTimeInReadableFormat(talkingClockService);
    });
  }

  private static void printCurrentTimeInReadableFormat(TalkingClockService talkingClockService) {
    LocalTime ldt = LocalTime.now();
    String time = ldt.getHour() + ":" + ldt.getMinute();
    printGivenTimeInReadableFormat(talkingClockService, time);
  }

  private static void printGivenTimeInReadableFormat(TalkingClockService talkingClockService, String data) {
    com.sj.tc.model.TalkingClock talkingClock = talkingClockService.createTakingClock(data);
    System.out.println(talkingClock.getHumanReadableTime());
  }
}
