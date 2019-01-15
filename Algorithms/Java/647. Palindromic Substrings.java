class Solution {
    public int countSubstrings(String s) {
        if (s.length() <= 1) return s.length();
        
        for (int step = 1; step < s.length(); step++) {
            for (int i = 0; i < s.length() - step; ++i) {
                int left = i, right = left + step;
                if (isPalindromic(s, left, right)) 
                    cnt++;
            } 
        }
        
        return cnt;
    }
    
    boolean isPalindromic(String s, int left, int right) {
        char[] str = s.toCharArray();
        
        while (left < right) {
            if (str[left] != str[right]) return false;
            left++;
            right--;
        }
        
        return true;
    }
}