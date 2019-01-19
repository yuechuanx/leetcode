class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums2.length; ++i) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; ++i) {
            int index = map.get(nums1[i]);
            res[i] = search(nums2, index, nums1[i]);
        }
        
        return res;
    }
    
    private int search(int[] nums, int index, int target) {
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] > target) {
                return nums[i];
            }
        }
        
        return -1;
    }
}