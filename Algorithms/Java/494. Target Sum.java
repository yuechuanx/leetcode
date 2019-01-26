// Brute Force:
// Complexity Analysis
// Time complexity : O(2^n). Size of recursion tree will be 2^n. n refers to the size of numsnums array.
// Space complexity : O(n). The depth of the recursion tree can go upto nn.
class Solution {
    int cnt = 0;
    
    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return cnt;
    }
    
    private void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S)
                cnt++;  
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }
}