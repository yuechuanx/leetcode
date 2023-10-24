// O(n) 
class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else j++;
        }
        
        return (i == m) ? true : false;
    }
}

// much improvement
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        
        int index = 0;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index);
            if (index == -1) return false;
            index++;
        }
        
        return true;
    }
}

