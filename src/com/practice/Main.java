package com.practice;

import com.practice.problems.easy.ImplementQueueUsingStacks;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        var object = new ImplementQueueUsingStacks();
        var a = new ArrayList<Integer>();
        object.push(1);
        object.push(2);
        System.out.println(object.peek());
        System.out.println(object.pop());
        System.out.println(object.empty());
    }
}
