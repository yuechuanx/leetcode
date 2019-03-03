class NumArray {
    int[] sums;
    
    public NumArray(int[] nums) {
        if (nums.length == 0) return;
        
        sums = new int[nums.length];
        sums[0] = nums[0];
        
        for (int i = 1; i < nums.length; ++i) {
            sums[i] = sums[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return (i == 0) ? sums[j] :sums[j] - sums[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */