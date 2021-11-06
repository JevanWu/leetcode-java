package com.practice.problems.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        ArrayList<String> results = new ArrayList<>();
        recurse(results, "(", 1, 0, n);
        return results;
    }

    private void recurse(ArrayList<String> results, String string, int leftCount, int rightCount, int n) {
        if (string.length() == 2*n) {
            if (leftCount == rightCount) {
                results.add(string);
            }
        } else if (leftCount < rightCount) {
            return;
        }

        if (leftCount <= n) {
            recurse(results, string + "(", leftCount + 1, rightCount, n);
        }

        if (rightCount <= n) {
            recurse(results, string + ")", leftCount, rightCount + 1, n);
        }
    }
}
