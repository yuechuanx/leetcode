class Solution {
    /**
     *  wrong solution.
     */
    public boolean isMatch(String s, String p) {
        // 思路是 根据 p 匹配 s 的长度，如果能够完全匹配则返回 true，不能则返回 false
        int len1 = s.length(), len2 = p.length();
        int i = 0, j= 0;
        while (j < len2 && i < len1) {
            if (p.charAt(j) == '*' && i == 0) {
                return false;
            } else if (p.charAt(j) == s.charAt(i)) {
                i++;
                j++;
            } else if (p.charAt(j) == '.') {
                i++;
                j++;
            } else if (p.charAt(j) == '*' && s.charAt(i) == s.charAt(i - 1)) {
                i++;
            } else if (p.charAt(j) == '*' && s.charAt(i) != s.charAt(i - 1)) {
                i++;
                j++;
            }  else {
                if (p.charAt(j + 1) == '*' && j < len2 - 1) {
                    if (j + 2 >= len2) break;
                    j += 2;
                } else {
                    break;    
                }
                
            }
                
        }
        
        return (i == len1) ? true : false;
    }
}

/**
 *  递归解法
 * 
 */
class Solution {
    public boolean isMatch(String text, String pattern) {
        
        /* 如果 pattern 为空，那么只能匹配到空字符串 */
        if (pattern.isEmpty()) return text.isEmpty();
        
        /* 实际是存储上一个匹配状态 */
        boolean first_match = (!text.isEmpty() &&
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
        
        /* 递归地匹配后面的字符串 */
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}