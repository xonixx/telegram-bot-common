package com.cmlteam.telegram_bot_common.test;

import com.pengrad.telegrambot.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TelegramFactoryTests {
  private final TelegramFactory telegramFactory = new TelegramFactory();

  @Test
  void test1() {
    User user = telegramFactory.user(123, "first", "last");
    assertEquals("first", user.firstName());
    assertEquals("last", user.lastName());
    assertEquals(123, user.id());
    assertEquals("123", user.username());
  }
}
