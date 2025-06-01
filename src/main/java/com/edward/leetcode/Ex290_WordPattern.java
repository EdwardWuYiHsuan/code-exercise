package com.edward.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * <h3> 290. Word Pattern
 * <p>
 * Given a pattern and a string s, find if s follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 * Specifically:
 * <li> Each letter in pattern maps to exactly one unique word in s.
 * <li> Each unique word in s maps to exactly one letter in pattern.
 * <li> No two letters map to the same word, and no two words map to the same letter.
 *
 * <h4> Example 1:
 * <p> Input: pattern = "abba", s = "dog cat cat dog"
 * <p> Output: true
 * <p> Explanation: The bijection can be established as:
 * <li> 'a' maps to "dog".
 * <li> 'b' maps to "cat".
 *
 * <h4> Example 2:
 * <p> Input: pattern = "abba", s = "dog cat cat fish"
 * <p> Output: false
 *
 * <h4> Example 3:
 * <p> Input: pattern = "aaaa", s = "dog cat cat dog"
 * <p> Output: false
 *
 * <h4> Constraints:
 * <li> 1 <= pattern.length <= 300
 * <li> pattern contains only lower-case English letters.
 * <li> 1 <= s.length <= 3000
 * <li> s contains only lowercase English letters and spaces ' '.
 * <li> s does not contain any leading or trailing spaces.
 * <li> All the words in s are separated by a single space.
 */
public class Ex290_WordPattern {

    /**
     * Checking word is same as pattern
     */
    public boolean wordPattern1(String pattern, String s) {

        String[] sAry = s.split(" ");
        if (pattern.length() != sAry.length) {
            return false;
        }

        String patternRule = "", sRule = "";
        Map<String, Integer> checkBox = new HashMap<>();
        int code = 0;
        for (int i = 0; i < pattern.length(); i++) {  // for-loop pattern and s word. Using integer replace new pattern
            String key = String.valueOf(pattern.charAt(i));
            if (checkBox.containsKey(key)) {
                patternRule += checkBox.get(key);
            } else {
                code = code + 1;
                checkBox.put(key, code);
                patternRule += code;
            }
        }

        checkBox.clear();
        code = 0;
        for (String strElement : sAry) {
            if (checkBox.containsKey(strElement)) {
                sRule += checkBox.get(strElement);
            } else {
                code = code + 1;
                checkBox.put(strElement, code);
                sRule += code;
            }
        }

        return patternRule.equals(sRule);
    }

    public boolean wordPattern2(String pattern, String s) {

        String[] sAry = s.split("\\s+");
        if (pattern.length() != sAry.length) {
            return false;
        }

        Map<Character, String> tmp = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String _s = sAry[i];

            if (tmp.containsKey(c)) {
                if (!tmp.get(c).equals(_s)) {
                    return false;
                }
            } else {
                if (tmp.containsValue(_s)) {
                    return false;
                }
            }

            tmp.put(c, _s);
        }

        return true;
    }
}
