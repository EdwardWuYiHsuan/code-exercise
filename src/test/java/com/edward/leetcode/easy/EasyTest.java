package com.edward.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EasyTest {

    @Test
    public void ex100_sameTree() {
        Ex100_SameTree ex100SameTree = new Ex100_SameTree();
        Assertions.assertTrue(ex100SameTree.isSameTree(
                new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                new TreeNode(1, new TreeNode(2), new TreeNode(3))));

        Assertions.assertFalse(ex100SameTree.isSameTree(
                new TreeNode(1, new TreeNode(2), null),
                new TreeNode(1, null, new TreeNode(2))));

        Assertions.assertFalse(ex100SameTree.isSameTree(
                new TreeNode(1, new TreeNode(2), new TreeNode(1)),
                new TreeNode(1, new TreeNode(1), new TreeNode(2))));
    }

    @Test
    public void ex21_mergeTowSortedLists() {
        Ex21_MergeTwoSortedLists ex21MergeTwoSortedLists = new Ex21_MergeTwoSortedLists();
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ex21MergeTwoSortedLists.mergeTwoLists2(list1, list2);
    }
}
