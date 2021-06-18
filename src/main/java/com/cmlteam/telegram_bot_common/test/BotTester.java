package com.cmlteam.telegram_bot_common.test;

import com.cmlteam.telegram_bot_common.BotUpdateHandler;
import com.cmlteam.telegram_bot_common.TelegramSender;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.User;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.response.BaseResponse;

public class BotTester {
  private final BotUpdateHandler botUpdateHandler;
  private final TelegramSender telegramSender;

  public BotTester(BotUpdateHandler botUpdateHandler) {
    this.botUpdateHandler = botUpdateHandler;
    telegramSender =
        new TelegramSender() {
          @Override
          public <T extends BaseRequest, R extends BaseResponse> R execute(
              Update userRequest, BaseRequest<T, R> request) {
            return null;
          }
        };
  }

  public void processUserText(User user, String text) {


  }
}
