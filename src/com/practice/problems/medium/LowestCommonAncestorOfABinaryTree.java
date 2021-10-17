package com.practice.problems.medium;

public class LowestCommonAncestorOfABinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    TreeNode lowestCommonAncestor;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurse(root, p, q);
        return lowestCommonAncestor;
    }

    private Boolean recurse(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }

        Boolean lson = recurse(node.left, p, q);
        Boolean rson = recurse(node.right, p, q);
        Boolean succeedCondition = (lson && rson) || ((node == q || node == p) && (lson || rson));
        if (succeedCondition) {
           lowestCommonAncestor = node;
        }

        return succeedCondition;
    }

}
