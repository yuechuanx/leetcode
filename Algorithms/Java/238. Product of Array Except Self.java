class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        int[] res = new int[n];
        
        for (int i = 0; i < n; ++i) {
            int product = 1;
            int tmp = nums[i];
            nums[i] = 1;
            for (int j = 0; j < n; ++j) {
                product *= nums[j];
            }
            res[i] = product; 
            nums[i] = tmp;
         }
        
        return res;
    }
}