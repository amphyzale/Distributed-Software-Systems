package com.enfor.myapp.service;

import com.enfor.myapp.entity.Message;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;

@Service
public class DiagramService {


    public Map<String, Integer> getCrashMap(Set<Message> messages) {
        Map<String, Integer> crashMap = new HashMap<>();
        for (int i = 1; i < 13; i++) {
            crashMap.put(Month.of(i).getDisplayName(TextStyle.FULL_STANDALONE, Locale.forLanguageTag("ru")),
                    getCrashesForMonth(i, messages));
        }

        return crashMap;
    }

    public int getCrashesForMonth(int monthNum, Set<Message> messages) {
        int count = 0;
        List<Message> list = new ArrayList(messages);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDateOfCrash().getMonthValue() == monthNum) {
                count++;
            }
        }
        return count;
    }
}
