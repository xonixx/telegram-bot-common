package com.cmlteam.telegram_bot_common;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class TelegramBotWrapper extends TelegramSenderBase {
  private final TelegramBot telegramBot;
  private final JsonHelper jsonHelper;
  private final ErrorReporter errorReporter;

  @Override
  public <T extends BaseRequest, R extends BaseResponse> R execute(
      Update userRequest, BaseRequest<T, R> request) {
    R response = telegramBot.execute(request);
    if (!response.isOk()) {
      String requestStr = jsonHelper.toPrettyString(request.toWebhookResponse());
      errorReporter.reportError(
          new ErrorData(
              userRequest,
              response.errorCode(),
              response.description(),
              requestStr,
              new Exception()));
      log.error(
          "ERROR #{}: {} for request:\n{}",
          response.errorCode(),
          response.description(),
          requestStr);
    }
    return response;
  }
}
