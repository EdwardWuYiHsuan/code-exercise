package com.edward.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <h3> 21. Merge Two Sorted Lists
 * <p>
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 *
 * <h4> Example 1:
 * <p> Input: list1 = [1,2,4], list2 = [1,3,4]
 * <p> Output: [1,1,2,3,4,4]
 *
 * <h4> Example 2:
 * <p> Input: list1 = [], list2 = []
 * <p> Output: []
 *
 * <h4> Example 3:
 * <p> Input: list1 = [], list2 = [0]
 * <p> Output: [0]
 *
 * <h4> Constraints:
 * <li> The number of nodes in both lists is in the range [0, 50].
 * <li> -100 <= Node.val <= 100
 * <li> Both list1 and list2 are sorted in non-decreasing order. 兩個list都是升序過
 */
public class Ex21_MergeTwoSortedLists {

    /**
     * Merge the two lists into one sorted list.
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {  // Solved by myself.

        if (null == list1 && null == list2) {
            return null;  // example.2
        }

        List<Integer> list = new ArrayList<>();
        boolean isList1Done = null == list1;
        boolean isList2Done = null == list2;
        do {
            if (null != list1) {
                list.add(list1.val);
                list1 = list1.next;
            } else {
                isList1Done = true;
            }

            if (null != list2) {
                list.add(list2.val);
                list2 = list2.next;
            } else {
                isList2Done = true;
            }

        } while (!isList1Done || !isList2Done);

        Collections.sort(list);

        ListNode res = new ListNode(list.get(list.size() - 1));
        for (int i = list.size() - 2; i >=0; i--) {
            res = new ListNode(list.get(i), res);
        }
        return res;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {  // Solved after reading the explanation.

        if (null == list1 && null == list2) {
            return null;
        }

        ListNode res = null;
        ListNode dummy = null;
        while (null != list1 || null != list2) {
            if (null == res) {
                res = new ListNode();
                dummy = res;
            } else {
                dummy.next = new ListNode();
                dummy = dummy.next;
            }

            if (null == list1) {
                dummy.val = list2.val;
                list2 = list2.next;
            } else if (null == list2) {
                dummy.val = list1.val;
                list1 = list1.next;
            } else {
                if (list1.val <= list2.val) {
                    dummy.val = list1.val;
                    list1 = list1.next;
                } else {
                    dummy.val = list2.val;
                    list2 = list2.next;
                }
            }
        }

        return res;
    }
}
