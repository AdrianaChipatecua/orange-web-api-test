package com.orange.web.api.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleVariable {
  public static String getShuffleString(String word) {
    List<Character> characters = new ArrayList<>();
    for (char c : word.toCharArray()) {
      characters.add(c);
    }
    Collections.shuffle(characters);

    StringBuilder sb = new StringBuilder();
    for (char c : characters) {
      sb.append(c);
    }

    return sb.toString();
  }
}
