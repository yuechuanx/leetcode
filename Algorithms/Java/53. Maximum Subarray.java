class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE, currSum = 0;
        
        for (int num : nums) {
            currSum = Math.max(currSum + num, num);
            res = Math.max(currSum, res);
        }
        
        return res;
    }
}