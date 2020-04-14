class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        int mid;
        while (left < right) {
            // mid = (left + right) / 2;
            // mid = (left + right) >> 1;
            mid = (left + right) >>> 1; // what is >>> mean
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid;
            else left = mid + 1;
        }
        
        return -1;
    }
}


class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        
        return -1;
    }
}