package edu.pingpong.javaindocker.domain.regex;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class RegexDictionaryTest {

    private RegexRomanNumber regex = new RegexRomanNumber();
    private Map<String, String> test1 = new HashMap<>();

    @Before
    public void setupRegex() {
        test1.put("Test regex", "value");
        regex.addRegex("Test regex", "value");
    }

    @Test
    public void testgetRegexDictionary() {
        assertEquals(test1, regex.getRegex());
    }

    @Test
    public void testGetKeyRegex() {
        assertEquals(test1.get("Test regex"), regex.getNameRegex("Test regex"));
    }

    @Test
    public void testGetValueRegex() {
        assertEquals(test1.values().toString(), regex.getValueRegex().toString());
    }

    @Test
    public void testGetLengthRegex() {
        assertEquals(1, regex.getLengthRegexDictionary());
    }
}

