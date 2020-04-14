class Solution {
    public int trap(int[] A) {
        // check special case
        if (A.length < 3) return 0;
        
        int res = 0, l = 0, r = A.length - 1;
        
        // move to position while can hold water
        while (l < r && A[l] <= A[l + 1]) ++l;
        while (l < r && A[r] <= A[r - 1]) --r;
        
        while (l < r) {
            int left = A[l], right = A[r];
            if (left < right) {
                while (l < r && left >= A[++l])
                    res += left - A[l];
            } else {
                while (l < r && A[--r] <= right)
                    res += right - A[r];
            } // END-IF-ELSE
        } // END-WHILE
        
        return res;
    }
}

