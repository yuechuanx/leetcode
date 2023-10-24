class Solution {
    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums.length == 0 ? 0 : nums[0];
        }
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < n; ++i) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
            
        return dp[n - 1];
    }
}

    // int rob(vector<int>& nums) {
    //     if (nums.size() <= 1) return nums.empty() ? 0 : nums[0];
    //     vector<int> dp = {nums[0], max(nums[0], nums[1])};
    //     for (int i = 2; i < nums.size(); ++i) {
    //         dp.push_back(max(nums[i] + dp[i-2], dp[i-1]));
    //     }
    //     return dp.back();
    // }