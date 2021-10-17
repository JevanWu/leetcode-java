package com.practice.problems.medium;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateBinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return recurse(root, null, null);
    }

    private boolean recurse(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if (min != null && node.val <= min) return false;
        if (max != null && node.val >= max) return false;

        return recurse(node.left, min, node.val) && recurse(node.right, node.val, max);
    }

    /**
     * 第二种解法 - 中序遍历
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        int minValue = -Integer.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.val <= minValue) {
                return false;
            }
            minValue = root.val;

            root = root.right;
        }
        return true;
    }
}
