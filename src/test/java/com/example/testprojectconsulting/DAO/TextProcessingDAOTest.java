package com.example.testprojectconsulting.DAO;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;



public class TextProcessingDAOTest {

    private TextProcessingDAO textProcessingDAO;

    @BeforeEach
    public void setUp() {
        textProcessingDAO = new TextProcessingDAO();
    }

    @Test
    @DisplayName("allChars method test")
    public void allChars_shouldReturnMapWithDescValues() {
        textProcessingDAO.setText("test");
        textProcessingDAO.allChars();

        Map<Character, Integer> actual = textProcessingDAO.getCharMap();
        Map<Character, Integer> expected = getTestMap();

        System.out.println(actual);
        System.out.println(expected);

        assertThat(actual).containsExactlyEntriesOf(expected);
    }

    @Test
    @DisplayName("getCheck returns false for empty string")
    public void getCheck_ShouldReturnFalse() {
        textProcessingDAO.setText("");
        boolean actual = textProcessingDAO.getCheck();

        Assertions.assertFalse(actual);
    }

    public Map<Character, Integer> getTestMap() {
        Map<Character, Integer> testMap = new LinkedHashMap<>();

        testMap.put('t', 2);
        testMap.put('e', 1);
        testMap.put('s', 1);

        return testMap;
    }
}
