package com.cmlteam.telegram_bot_common.test;

import com.cmlteam.telegram_bot_common.BotUpdateHandler;
import com.cmlteam.telegram_bot_common.TelegramBotWrapper;
import com.cmlteam.telegram_bot_common.TelegramSender;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.User;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.response.BaseResponse;

public class BotTester {
  private final BotUpdateHandler botUpdateHandler;
  private final TelegramFactory telegramFactory;

  public BotTester(BotUpdateHandler botUpdateHandler) {
    this.botUpdateHandler = botUpdateHandler;
    telegramFactory = new TelegramFactory();
  }

  public BotReply processUserText(User user, String text) {
    BotReply botReply = new BotReply();
    botUpdateHandler.processUpdate(
        new TelegramBotWrapper() {
          @Override
          public <T extends BaseRequest, R extends BaseResponse> R execute(
              Update userRequest, BaseRequest<T, R> request) {
            botReply.add(request);
            return null; // TODO
          }
        },
        telegramFactory.messageFromUser(user, text));
    return botReply;
  }
}
