class Solution {
    public int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0) return 0;
        
        int left = 0, right = 0;
        int res = S.length();
        char[] str = S.toCharArray();
        
        for (int i = 0; i < S.length(); ++i) {
            if (str[i] == '(' ) {
                left++;
            } 
            if (str[i] == ')') {
                if (left == 0) right++;
                else left--;
            }
        }
        
        res = left + right;
        
        return res;
    }
}