package com.practice.problems.easy;

public class LowestCommonAncestorOfABinarySearchTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true) {
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else if (q.val < root.val && p.val < root.val) {
                root = root.left;
            } else {
                return root;
            }
        }
    }
}
