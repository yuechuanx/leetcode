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

/**
 * best solution    
 * 
 * 125 / 125 test cases passed.
 * Status: Accepted
 * Runtime: 8 ms
 * Memory Usage: 39 MB
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int lo = i + 1, hi = nums.length - 1;
                while (lo < hi) {
                    int sum = nums[i] + nums[lo] + nums[hi];
                    if (sum < target) 
                        do lo++; while (lo < hi && nums[lo] == nums[lo-1]);
                    else if (sum > target) 
                        do hi--; while (lo < hi && nums[hi] == nums[hi+1]);
                    else 
                        return sum;
                    res = (Math.abs(target-sum) < Math.abs(target-res)) ? sum : res;
                } 
            }
        }   
        return res;
    }
}