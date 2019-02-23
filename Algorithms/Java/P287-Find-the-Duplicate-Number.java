// O(n^2)
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; ++i) {
            for(int j = i + 1; j < n; ++j) {
                if (nums[i] == nums[j]) return nums[i];
            }
        }
        
        return -1;
    }
}

// need more soluton...