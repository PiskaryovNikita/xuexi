package com.xuexi.algorithm;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class StringWordCountTest {

    @Test
    public void testGetWords() {
        List<String> words = StringWordCount.getWords(".asdkl...asdkl...qwert12-...qwerty12..---q");

        assertEquals(5, words.size());
        assertTrue(words.contains("asdkl"));
        assertTrue(words.contains("qwerty12"));
        assertTrue(words.contains("qwert12-"));
        assertTrue(words.contains("---q"));
    }

    @Test
    public void testGetWordCount() {
        Map<String, Integer> wordCount = StringWordCount.getWordCount(".asdkl...asdkl...qwert12-...qwerty12..---q");

        assertEquals(4, wordCount.size());
        assertEquals(Integer.valueOf(2), wordCount.get("asdkl"));
        assertEquals(Integer.valueOf(1), wordCount.get("qwerty12"));
        assertEquals(Integer.valueOf(1), wordCount.get("qwert12-"));
        assertEquals(Integer.valueOf(1), wordCount.get("---q"));
    }

}