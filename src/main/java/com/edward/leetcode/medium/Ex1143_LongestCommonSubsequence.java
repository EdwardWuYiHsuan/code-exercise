package com.edward.leetcode.medium;

/**
 * <h3> 1143. Longest Common Subsequence
 * <p>
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 *
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 *
 * <p> For example, "ace" is a subsequence of "abcde".
 *
 * <p> A common subsequence of two strings is a subsequence that is common to both strings.
 *
 * <h4> Example 1:
 * <p> Input: text1 = "abcde", text2 = "ace"
 * <p> Output: 3
 * <p> Explanation: The longest common subsequence is "ace" and its length is 3.
 *
 * <h4> Example 2:
 * <p> Input: text1 = "abc", text2 = "abc"
 * <p> Output: 3
 * <p> Explanation: The longest common subsequence is "abc" and its length is 3.
 *
 * <h4> Example 3:
 * <p> Input: text1 = "abc", text2 = "def"
 * <p> Output: 0
 * <p> Explanation: There is no such common subsequence, so the result is 0.
 *
 * <h4> Constraints:
 * <ul>
 *  <li> 1 <= text1.length, text2.length <= 1000
 *  <li> text1 and text2 consist of only lowercase English characters.
 * </ul>
 *
 * <p> 找出LCS，此演算法被用在Git Diff上，使用Dynamic Programming 演算法
 * <p> X = [A, B, C, B, D, A, B]
 * <p> Y = [B, D, C, A, B, A]
 * <p> Common subsequence : 不用連續，但順利要一樣，Ans: [B, D, A]、[B, C, A]....
 * <p> Longest common subsequence：最長的部分，字串刪除某些字元，不改變順序，Ans: [B, D, A, B]、[B, C, A, B]、[B, C, B, A]
 * <p> <a href="https://www.youtube.com/watch?v=rHV2MT2tD7Y">YouTube - Longest Common Subsequence(LCS)問題的演算法介紹</a>
 * <p> <a href="https://www.youtube.com/watch?v=CEnb7Ho7TYc">YouTube - 每日一题 1143. Longest Common Subsequence</a>
 * <p> 解法：src/main/resources/pic/1143_LongestCommonSubsequence.png
 * <p> Time Complexity:O(mn)，Space Complexity:O(mn)
 */
public class Ex1143_LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        text1 = "#" + text1;
        text2 = "#" + text2;

        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
