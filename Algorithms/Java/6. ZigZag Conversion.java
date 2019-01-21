class Solution {
    public String convert(String s, int numRows) {
        StringBuffer[] res = new StringBuffer[numRows];
        for (int i = 0; i < numRows; ++i) {
            res[i] = new StringBuffer();
        }
        int i = 0;
        
        while (i < s.length()) {
            for (int j = 0; j < numRows && i < s.length(); ++j) {
                res[j].append(s.charAt(i++));
            }
            for (int j = numRows - 2; j > 0 && i < s.length(); j--) { // j > 0
                res[j].append(s.charAt(i++));
            }
        }
        
        for (int j = 1; j < numRows; ++j) {
            res[0].append(res[j]);
        }
        
        return new String(res[0]);
    }
}