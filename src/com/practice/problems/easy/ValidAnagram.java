package com.practice.problems.easy;

import java.util.HashMap;

public class ValidAnagram {


    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> dic = new HashMap<Character, Integer>();
        boolean isAnagram = true;
        for (Character character : s.toCharArray()) {
            dic.merge(character, 1, Integer::sum);
        }

        for (Character character : t.toCharArray()) {
            var count = dic.get(character);
            if (count == null || count == 0) {
                isAnagram = false;
                break;
            }
            dic.put(character, count - 1);
        }

        isAnagram = isAnagram && !dic.values().stream().anyMatch(a -> a > 0);

        return isAnagram;
    }
}
