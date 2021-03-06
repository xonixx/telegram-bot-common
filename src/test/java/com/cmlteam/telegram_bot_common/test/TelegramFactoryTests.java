package com.cmlteam.telegram_bot_common.test;

import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TelegramFactoryTests {
  private final TelegramFactory telegramFactory = new TelegramFactory();

  @Test
  void testUser() {
    User user = telegramFactory.user(123, "first", "last");
    assertEquals("first", user.firstName());
    assertEquals("last", user.lastName());
    assertEquals(123, user.id());
    assertEquals("123", user.username());
  }

  @Test
  void testPrivateChat() {
    Chat chat = telegramFactory.privateChat(telegramFactory.user(123, "first", "last"));
    assertEquals("first", chat.firstName());
    assertEquals("last", chat.lastName());
    assertEquals(123, chat.id());
    assertEquals("123", chat.username());
  }

  @Test
  void testMessageFromUser() {

    String text = "test message";
    Update update =
        telegramFactory.messageFromUser(telegramFactory.user(123, "first", "last"), text);

    Message message = update.message();
    User user = message.from();
    Chat chat = message.chat();

    assertEquals("first", user.firstName());
    assertEquals("last", user.lastName());
    assertEquals(123, user.id());
    assertEquals("123", user.username());

    assertEquals("first", chat.firstName());
    assertEquals("last", chat.lastName());
    assertEquals(123, chat.id());
    assertEquals("123", chat.username());

    assertEquals(text, message.text());

    System.out.println(update);
  }
}
