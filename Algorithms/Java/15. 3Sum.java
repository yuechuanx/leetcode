class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;
        
        int n = nums.length;
        Arrays.sort(nums);
        
        for (int i = 0; i < n - 2; ++i) {
            // skip same reslut
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            int left = i + 1, right = n - 1;    
            int sum = -1;
            
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left-1]) left++;
                    while (left < right && nums[right] == nums[right+1]) right--;
                }
                if (sum > 0) {
                    right--;
                } 
                if (sum < 0) {
                    left++;
                }
            } // end while 
        } // end for 
        
        return res;
    }
}