package com.cmlteam.telegram_bot_common.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.User;

import static com.cmlteam.telegram_bot_common.test.JsonBuilder.json;

public class TelegramFactory {
  private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

  public User user() {
    return user(7);
  }

  public User user(int id) {
    return user(id, "John", "Doe");
  }

  public User user(int id, String firstName, String lastName) {
    return gson.fromJson(
        json()
            .add("id", id)
            .add("username", "" + id)
            .add("first_name", firstName)
            .add("last_name", lastName)
            .toString(),
        User.class);
  }

  public Chat privateChat(User ofUser) {
    return gson.fromJson(
        json()
            .add("id", ofUser.id())
            .add("username", "" + ofUser.username())
            .add("first_name", ofUser.firstName())
            .add("last_name", ofUser.lastName())
            .add("type", "private")
            .toString(),
        Chat.class);
  }
}
