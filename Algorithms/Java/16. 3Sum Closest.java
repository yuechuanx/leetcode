class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE, n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(target - sum) < min) {
                        min = Math.abs(target - sum);
                        res = sum;
                    }
                }
            }
        }
        
        return res;
    }
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int res = nums[0] + nums[1] + nums[n - 1];
        
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; ++i) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) return target;
                
                if (sum > target) {
                    right--;
                } else {
                    left++;     
                }
                
                if (Math.abs(target - res) > Math.abs(target - sum)) {
                    res = sum;
                }    
            }
        }
        
        return res;
    }
}