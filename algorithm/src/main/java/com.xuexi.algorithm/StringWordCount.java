package com.xuexi.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringWordCount {

  public static List<String> getWords(String s) {
    List<String> words = new ArrayList<>();
    String regex = "^[a-zA-Z0-9-]+$";
    StringBuilder word = new StringBuilder();
    for (int i = 0;i < s.length();i++) {
      char c = s.charAt(i);
      boolean matches = (c + "").matches(regex);
      if (matches) {
        word.append(c);
      } else if (word.length() > 0){
        words.add(word.toString());
        word = new StringBuilder();
      }
      if (matches && i == s.length() - 1) {
        words.add(word.toString());
      }
    }
    return words;
  }

  public static Map<String, Integer> getWordCount(String s) {
    List<String> words = getWords(s);

    Map<String, Integer> wordCount = new HashMap<>();
    for (String w: words) {
      if (wordCount.containsKey(w)) {
        Integer count = wordCount.get(w);
        wordCount.put(w, ++count);
      } else {
        wordCount.put(w, 1);
      }
    }

    return wordCount;
  }

  public static void main(String[] args) {
    List<String> words = getWords(".asdkl...asdkl...qwert12-...qwerty12..---q");
    System.out.println(words);
    Map<String, Integer> map = getWordCount(".asdkl...asdkl...qwert12-...qwerty12..---q");
    System.out.println(map);
  }

}
