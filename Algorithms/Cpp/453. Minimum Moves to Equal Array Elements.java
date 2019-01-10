class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        
        // min
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < min)
                min = nums[i];
        }
        
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res += nums[i] -min;   
        }            
        
        return res;
    }
}