package com.cmlteam.telegram_bot_common;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.response.BaseResponse;

public interface TelegramSender {
  <T extends BaseRequest, R extends BaseResponse> R execute(
      Update userRequest, BaseRequest<T, R> request);
}
