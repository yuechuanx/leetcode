class Solution {
    public String toLowerCase(String str) {
        char[] ca = str.toCharArray();
        for (int i = 0; i < ca.length; ++i) {
            if (ca[i] >= 'A' && ca[i] <= 'Z') 
                ca[i] = (char)(ca[i] - 'A' + 'a');
        }
        
        return new String(ca);
    }
}