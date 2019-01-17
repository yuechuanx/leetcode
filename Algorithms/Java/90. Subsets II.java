class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; ++i) {
            if (i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            path.add(nums[i]);
            backtrack(res, path, nums, i + 1);
            path.remove(path.size() - 1);
        }    
    }
    
}