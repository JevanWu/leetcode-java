package com.practice.problems.easy;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

    private final HashMap<Character, Character> parentheses = new HashMap<Character, Character>() {{
        put('(', ')');
        put('{', '}');
        put('[', ']');
    }};

    public boolean isValid(String s) {
        var stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {
            if (parentheses.containsKey(c)) stack.push(parentheses.get(c));
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.size() == 0;
    }
}
