package com.practice.problems.easy;

public class MaximumDepthOfBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        return recurse(root);
    }

    private int recurse(TreeNode root) {
        if (root == null) {
           return 1;
        }

        int leftDepth = recurse(root.left) + 1;
        int rightDepth = recurse(root.right) + 1;
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }
}
