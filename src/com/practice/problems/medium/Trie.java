package com.practice.problems.medium;

import java.util.*;

public class Trie {

    private static class TreeNode {
        Boolean isEnd = false;
        String val;
        //TODO: 将children改为map，增加查询和搜索效率
        List<TreeNode> children = new ArrayList<>();
        TreeNode(String val) { this.val = val; }
        void addChild(TreeNode node) {
            this.children.add(node);
        }
        void setIsEnd(Boolean isEnd) {
            this.isEnd = isEnd;
        }
    }


    TreeNode root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TreeNode("");
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        String matchValue = "";
        var lastSearchedNode = root;
        for(char character : word.toCharArray()) {
            matchValue += character;
            var searchedNode = searchNode(matchValue, lastSearchedNode);
            if (searchedNode == null) {
                var node = new TreeNode(matchValue);
                lastSearchedNode.addChild(node);
                lastSearchedNode = node;
            } else {
                lastSearchedNode = searchedNode;
            }
        }
        lastSearchedNode.setIsEnd(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        var searchedNode = searchNode(word, root);
        return searchedNode != null && searchedNode.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        var searchedNode = searchNode(prefix, root);
        return searchedNode != null;
    }

    private TreeNode searchNode(String word, TreeNode fromNode) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(fromNode);
        while(queue.size() != 0 ) {
            var node = queue.poll();
            node.children.forEach((childNode) -> queue.add(childNode) );
            if (Objects.equals(node.val, word)) {
               return node;
            }
        }
        return null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
