// O(n)
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; ++i) {
            if (A[i] > A[i + 1])
                return i;
        }
        
        return -1;
    }
}

// O(logN)
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int left = 0, right = A.length - 1;        
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (A[mid - 1] < A[mid] && A[mid] > A[mid +1]) {
                return mid;
            } else {
                if (A[mid - 1] > A[mid]) right = mid - 1;
                else left = mid + 1;
            }    
        }
        
        return mid;
    }
}