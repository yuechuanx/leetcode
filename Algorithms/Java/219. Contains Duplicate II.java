// brute force 
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 1; j <= k && i + j < nums.length; ++j) {
                if (nums[i] == nums[i + j]) return true;    
            } 
        }
        
        return false;
    }
}

// use set
public boolean containsNearbyDuplicate(int[] nums, int k) {
    Set<Integer> set = new HashSet<Integer>();
    for(int i = 0; i < nums.length; i++){
        if(i > k) set.remove(nums[i-k-1]);
        if(!set.add(nums[i])) return true;
    }
    return false;
}

// use map
public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(nums[i])) {
            if (i - map.get(nums[i]) <= k) return true;
        }
        map.put(nums[i], i);
    }
    return false;
}