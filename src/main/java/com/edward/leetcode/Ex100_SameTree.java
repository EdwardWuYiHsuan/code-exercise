package com.edward.leetcode;

/**
 * <h3> 100. Same Tree
 * <p>
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 * <h4> Example 1:
 * <p> Input: p = [1,2,3], q = [1,2,3]
 * <p> Output: true
 *
 * <h4> Example 2:
 * <p> Input: p = [1,2], q = [1,null,2]
 * <p> Output: false
 *
 * <h4> Example 3:
 * <p> Input: p = [1,2,1], q = [1,1,2]
 * <p> Output: false
 *
 * <h4> Constraints:
 * <li> The number of nodes in both trees is in the range [0, 100].
 * <li> -10000 <= Node.val <= 10000
 */
public class Ex100_SameTree {

    /**
     * Determining two TreeNode are same include structure.
     */
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