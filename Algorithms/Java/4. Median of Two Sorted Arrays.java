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