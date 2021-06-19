package com.cmlteam.telegram_bot_common.test;

import com.pengrad.telegrambot.request.BaseRequest;

import java.util.ArrayList;
import java.util.List;

public class BotReply {
    private final List<BaseRequest> botReplies = new ArrayList<>();

    void add(BaseRequest request) {
    botReplies.add(request);
    }
}
