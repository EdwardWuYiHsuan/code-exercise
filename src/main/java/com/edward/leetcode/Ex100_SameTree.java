package com.edward.leetcode;

/**
 * 100. Same Tree
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 * Example 1:
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 *
 * Example 2:
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 *
 * Example 3:
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *
 * Constraints:
 * - The number of nodes in both trees is in the range [0, 100].
 * - -104 <= Node.val <= 104
 */
public class Ex100_SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        } else if ((null != p && null == q) || (null == p && null != q) || (p.val != q.val)) {
            return false;
        }

        if (p.left == null && null == q.left && p.right == null && null == q.right) {
            return true;
        }

        if ((null != p.left && null == q.left) || (null == p.left && null != q.left)) {
            return false;
        } else if (null != p.left && null != q.left && p.left.val != q.left.val) {
            return false;
        }

        if ((null != p.right && null == q.right) || (null == p.right && null != q.right)) {
            return false;
        } else if (null != p.right && null != q.right && p.right.val != q.right.val) {
            return false;
        }

        if (!this.isSameTree(p.left, q.left)) {
            return false;
        }

        if (!this.isSameTree(p.right, q.right)) {
            return false;
        }

        return true;
    }
}