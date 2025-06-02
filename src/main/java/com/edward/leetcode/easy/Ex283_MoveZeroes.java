package com.edward.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3> 283. Move Zeroes
 * <p>
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 *
 * <h4> Example 1:
 * <p> Input: nums = [0,1,0,3,12]
 * <p> Output: [1,3,12,0,0]
 *
 * <h4> Example 2:
 * <p> Input: nums = [0]
 * <p> Output: [0]
 *
 * <h4> Constraints:
 * <li> 1 <= nums.length <= 10000
 * <li> -2^31 <= nums[i] <= 2^31 - 1
 */
public class Ex283_MoveZeroes {

    /**
     * Move integer 0 to end of array.
     */
    public void moveZeroes1(int[] nums) {  // Solved by myself. Time Complexity:O(2n)，Space Complexity:O(n)
        List<Integer> scratch = new ArrayList<>();
        for (int i : nums) {
            if (i != 0) {
                scratch.add(i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < scratch.size()) {
                nums[i] = scratch.get(i);
            } else {
                nums[i] = 0;
            }
        }
    }

    public void moveZeroes2(int[] nums) {  // Solved after reading the explanation. Time Complexity: < O(2n)，Space Complexity:0
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {  // move non 0 to front of array.
            if (nums[i] != 0) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        for (int i = idx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
