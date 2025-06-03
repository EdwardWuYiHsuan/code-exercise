package com.edward.leetcode.easy;

/**
 * <h3> 101. Symmetric Tree
 * <p>
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * <h4> Example 1:
 * <p> Input: root = [1,2,2,3,4,4,3]
 * <p> Output: true
 *
 * <h4> Example 2:
 * <p> Input: root = [1,2,2,null,3,null,3]
 * <p> Output: false
 *
 * <h4> Constraints:
 * <ul>
 *     <li> The number of nodes in the tree is in the range [1, 1000].
 *     <li> -100 <= Node.val <= 100
 * <ul/>
 *
 * <p> <a href="https://www.youtube.com/watch?v=ULk7EuK0n9Q">YouTube - 贾考博 LeetCode 101. Symmetric Tree</a>
 */
public class Ex101_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode symLeft, TreeNode symRight) {  // compare TreeNode itself.
        if (symLeft == null && symRight == null) {
            return true;
        }  // One of two symmetric TreeNode is not null.


        if (symLeft == null || symRight == null) {
            return false;
        }

        if (symLeft.val != symRight.val) {
            return false;
        }

        /*
         *      | | | |                                 | | | |
         *      0     0                                   0 0
         */
        return helper(symLeft.left, symRight.right) && helper(symLeft.right, symRight.left);  // !Important
    }
}
