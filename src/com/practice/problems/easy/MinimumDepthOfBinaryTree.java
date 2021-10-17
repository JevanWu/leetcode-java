package com.practice.problems.easy;

public class MinimumDepthOfBinaryTree {
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

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return recurse(root);
    }

    private int recurse(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftDepth = Integer.MAX_VALUE;
        int rightDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            leftDepth = recurse(root.left) + 1;
        }

        if (root.right != null) {
            rightDepth = recurse(root.right) + 1;
        }

        return Math.min(leftDepth, rightDepth);
    }
}
