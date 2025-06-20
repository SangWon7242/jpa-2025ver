package com.sbs.jpa.standard.util;

import lombok.SneakyThrows;

public class Ut {
  public static class thread {
    /**
     * 현재 스레드를 지정된 시간(밀리초) 동안 일시 정지합니다.
     *
     * @param millis 일시 정지할 시간(밀리초)
     */
    @SneakyThrows
    public static void sleep(int millis) {
      Thread.sleep(millis);
    }
  }
}
