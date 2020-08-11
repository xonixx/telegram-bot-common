package com.cmlteam.telegram_bot_common;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Emoji {
  SUCCESS("✅"),
  WARN("⚠️"),
  ERROR("❌");

  private final String C;

  String msg(String s) {
    return C + " " + s;
  }
}
