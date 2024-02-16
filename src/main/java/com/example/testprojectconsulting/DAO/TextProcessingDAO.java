package com.example.testprojectconsulting.DAO;

import com.example.testprojectconsulting.models.TextProcessing;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class TextProcessingDAO {
    private final TextProcessing textProcessing = new TextProcessing();
    private Map<Character, Integer> charMap;

    public TextProcessingDAO() {}

    public String getText() {
        return textProcessing.getInpText();
    }

    public void setText(String text) {
        textProcessing.setInpText(text);
    }

    public boolean getCheck() {
        return textProcessing.getChecked();
    }

    public void setCheck(boolean check) {
        textProcessing.setChecked(check);
    }

    public Map<Character, Integer> getCharMap() {
        return charMap;
    }

    public void setCharMap(Map<Character, Integer> charMap) {
        this.charMap = charMap;
    }

    public void allChars() {
        String input = getText();
        Map<Character, Integer> result = new LinkedHashMap<>();

        for(int i = 0; i < input.length(); i++) {
            result.put(input.charAt(i), result.getOrDefault(input.charAt(i), 0) + 1);
        }

        Map<Character, Integer> sorted = result.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new
                ));

        setCharMap(sorted);
    }
}
