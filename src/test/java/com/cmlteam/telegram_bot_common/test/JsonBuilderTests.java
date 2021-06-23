package com.cmlteam.telegram_bot_common.test;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static com.cmlteam.telegram_bot_common.test.JsonBuilder.json;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonBuilderTests {
  private final Gson gson = new Gson();

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  private static class TestClass {
    private int i;
    private String s;
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  private static class A {
    private TestClass t;
  }

  @Test
  void jsonBuilderProduceJson() {
    // WHEN
    String json = json().add("i", 5).add("s", "str").toString();

    // THEN
    TestClass object = gson.fromJson(json, TestClass.class);
    assertEquals(5, object.getI());
    assertEquals("str", object.getS());
  }

  @Test
  void jsonBuilderProduceJson1() {
    // WHEN
    String json = json().add("t", json().add("i", 5).add("s", "str")).toString();

    // THEN
    A object = gson.fromJson(json, A.class);
    assertEquals(5, object.t.getI());
    assertEquals("str", object.t.getS());
  }

  @Test
  void jsonBuilderListShouldSucceed() {
    // WHEN
    String json =
        json()
            .add("list", List.of(Map.of("i", 5, "s", "str"), Map.of("i", 6, "s", "other str")))
            .toString();

    // THEN
    Map map = gson.fromJson(json, Map.class);

    List<?> objects = (List<?>) map.get("list");

    assertEquals(2, objects.size());
    assertEquals(5, ((Number) ((Map) objects.get(0)).get("i")).intValue());
    assertEquals(6, ((Number) ((Map) objects.get(1)).get("i")).intValue());
    assertEquals("str", ((Map) objects.get(0)).get("s"));
    assertEquals("other str", ((Map) objects.get(1)).get("s"));
  }
}
