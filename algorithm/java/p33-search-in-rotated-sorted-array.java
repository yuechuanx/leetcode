class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return (nums[0] == target) ? 0 : -1;
        
        int left = 0, right = nums.length - 1;
        
        while (left != right) { // the left + 1 = right
            int mid = left + (right-left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) {     // nums[start..mid] sorted
                if (target >= nums[left] && target < nums[mid]) {   // if target in the sorted part
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {  // nums[mid..end] sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
        } // END WHILE
        
        if (target == nums[left]) return left;
        if (target == nums[right]) return right;
        
        return -1;
    }
}