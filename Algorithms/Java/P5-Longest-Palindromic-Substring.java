class Solution {
    int palinStart = 0, palinLen = 0;
    
    public String longestPalindrome(String s) {
        if (s.length() < 2 || s == null) return s;
        
        char[] str = s.toCharArray();

        /* 逐个位置检查回文 */
        for (int i = 0; i < s.length(); ++i) {
            helper(str, i, i);
            helper(str, i, i + 1);
        }
        
        return s.substring(palinStart, palinStart + palinLen);
    }
    
    public void helper(char[] str, int left, int right) {
        while(left > -1 && right < str.length && str[left] == str[right]) {
            left--;
            right++;
        }

        int currLen = right -left - 1;  // 出循环时, 多执行了一次 while
        if (currLen > palinLen) {
            palinLen = currLen;
            palinStart = left + 1;
        }
    }
}