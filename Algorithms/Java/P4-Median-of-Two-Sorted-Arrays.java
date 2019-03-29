// Merge Sort Solution
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sorted = mergeSort(nums1, nums2);
        
        if (sorted.length % 2 == 1) {
            return sorted[sorted.length / 2] / 1.0;
        } else {
            return (sorted[(sorted.length -1)/2] + sorted[sorted.length/2]) / 2.0;    
        }
    }
    
    public int[] mergeSort(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int total = m + n;
        int[] res = new int[total];
        int i = 0, j = 0, k = 0;
        
        while (i < m && j < n) {
            res[k++] = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
        }
        
        for (; i < m; ++i) {
            res[k++] = nums1[i];
        }       
        for (; j < n; ++j) {
            res[k++] = nums2[j];
        }
        
        return res;
    }
}

/* 官方题解 */

class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;

        if (m > n) { // to ensure m<=n
            return findMedianSortedArrays(B, A);
        }
        
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}