package com.sj.tc;

import com.sj.tc.service.TalkingClockService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TalkingClockApplication {

  public static void main(String[] args) throws IOException {

    TalkingClockService talkingClockService = new TalkingClockService();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String input = bufferedReader.readLine();
    System.out.println(talkingClockService.process(input));
  }

}
