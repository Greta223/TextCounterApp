package com.example.fintechapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class TextCounterTest {

    @Test
    public void testCountWords_emptyString_returnsZero() {
        assertEquals(0, TextCounter.countWords(""));
    }

    @Test
    public void testCountWords_nullInput_returnsZero() {
        assertEquals(0, TextCounter.countWords(null));
    }

    @Test
    public void testCountWords_onlySpaces_returnsZero() {
        assertEquals(0, TextCounter.countWords("     "));
    }

    @Test
    public void testCountWords_normalText_returnsCorrectCount() {
        assertEquals(4, TextCounter.countWords("This is a test"));
    }

    @Test
    public void testCountWords_multipleSpaces_returnsCorrectCount() {
        assertEquals(4, TextCounter.countWords("  This   is   a test  "));
    }

    @Test
    public void testCountWords_tabsAndNewlines_returnsCorrectCount() {
        assertEquals(3, TextCounter.countWords("Hello\tworld\nagain"));
    }

    @Test
    public void testCountCharacters_emptyString_returnsZero() {
        assertEquals(0, TextCounter.countCharacters(""));
    }

    @Test
    public void testCountCharacters_nullInput_returnsZero() {
        assertEquals(0, TextCounter.countCharacters(null));
    }

    @Test
    public void testCountCharacters_normalText_returnsCorrectCount() {
        assertEquals(14, TextCounter.countCharacters("Hello world!!!"));
    }

    @Test
    public void testCountCharacters_onlySpaces_returnsCorrectCount() {
        assertEquals(5, TextCounter.countCharacters("     "));
    }
}
