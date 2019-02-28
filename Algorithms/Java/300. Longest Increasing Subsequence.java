class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        /* 构建 dp 表 */
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) { // 0 ~ i 之间的下标
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        
        /* 找到 dp 表里的最大值，以及下标 */
        int len = 0, index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }
        
//         int[] res = new int[len];
//         res[--len] = nums[index];
//         for (int i = index; i >= 0; --i) {
//             if (nums[i] < nums[index] && dp[i] == dp[index] - 1) {
//                 res[--len] = nums[i];
//                 index = i;
//             }
//         }
        
        return len;
    }
}