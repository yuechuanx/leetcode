class Solution {
    public String addBinary(String a, String b) {
        int m = a.length(), n = b.length();
        int i = 0, carry = 0;
        String res = "";
        
        // traverse length is max(m, n)
        while (i < m || i < n) {
            int p = i < m ? a.charAt(m - 1 - i) - '0' : 0;
            int q = i < n ? b.charAt(n - 1 - i) - '0' : 0;
            int tmp = p + q + carry;
            carry = tmp / 2;
            res = tmp % 2 + res;
            i++;
        }
        
        return carry == 0 ? res : "1" + res;
    }
}