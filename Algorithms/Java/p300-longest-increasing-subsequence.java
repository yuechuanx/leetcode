/* 
 * 24 / 24 test cases passed.
 * Status: Accepted
 * Runtime: 13 ms
 * Memory Usage: 34.2 MB
 */ 
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

/**
 * Not pass. 
 * 
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        /* 初始化 dp，ends */
        int[] dp = new int[nums.length];  // dp[i] 表示 nums[0...i] 时 LIS 的长度
        int[] ends = new int[nums.length];  // ends[i] 表示长度为 i 时，最小结尾数的值
        dp[0] = 1;
        ends[0] = dp[0];
        
        /* 更新 dp，ends 数组 */ 
        int l = 0, m = 0, r = 0;
        int len = 0;  // LIS 的长度
        for (int i = 1; i < nums.length; ++i) {
            l = 0;
            r = len;
            /* 二分法，找到 nums[i] 在 ends 中的插入位置 */
            while (l <= r) {  
                m = (l + r) / 2;  
                if (nums[i] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }  // END-WHILE
            len = Math.max(len, l);
            ends[l] = nums[i];
            dp[i] = l + 1;
        }
        
        /* 通过 dp，ends 数组构建序列 */
        // todo
        
        return dp[nums.length - 1];
    }
}

