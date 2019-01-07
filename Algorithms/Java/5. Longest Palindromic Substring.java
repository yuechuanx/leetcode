class Solution {
    int palinStart = 0, palinLen = 0;
    
    public String longestPalindrome(String s) {
        if (s.length() < 2 || s == null) return s;
        
        char[] str = s.toCharArray();
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

        // sample: "aba", right -left = 2,  rightLen = right -left + 1
        // after while loop: left--, right++, rightLen -= 2;
        int currLen = right -left - 1;
        if (currLen > palinLen) {
            palinLen = currLen;
            palinStart = left + 1;  // remember after while loop left -= 1;
        }
    }
}

public class Solution {
    
    int palinStart = 0;
    int palinLen = 0;
    
    public String longestPalindrome(String s) {
        
        if(s.length()<2 || s==null) return s;
        
        char[] chars = s.toCharArray();
        
        for(int i=0; i<chars.length-1; i++){
            checkThisPos(chars, i, i);
            checkThisPos(chars, i, i+1);
        }
        return s.substring(palinStart, palinStart+palinLen);
    }
    
    public void checkThisPos(char[] chars, int left, int right){
        
        while(left>=0 && right<chars.length && chars[left]==chars[right]){
            left--;
            right++;
        }
        if(right-left-1>palinLen){
            palinLen = right-left-1;
            palinStart = left+1;
            // System.out.println("palinStart: "+ palinStart+" palinLen: "+palinLen);
        }
        
    }
}