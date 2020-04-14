// time complexity: O(n), space complexity:O(n)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // use HashMap to store, and 
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < n; ++i) {
            map.put(nums[i], i);
        }
                              
        for (int i = 1; i <= n; ++i) {
            if (!map.containsKey(i)) {
                res.add(i);
            }
        }
                              
        return res;
    }
}

// time complexity: O(n), space complexity: 0
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        
        
        for (int i = 0; i < n; ++i) {
            int idx = Math.abs(nums[i]) - 1;    // use Math.abs() to make sure idx is positive
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }
        
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        
        return res;
    }
}

// use counter solution
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] counter = new int[n + 1];
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < n; ++i) {
            int idx = nums[i];
            counter[idx]++;
        }
        
        for (int i = 1; i <= n; ++i) {
            if (counter[i] == 0) {
                res.add(i);
            }
        }
        
        return res;
    }
}