class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), nums);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums) {
        if (path.size() == nums.length) 
            res.add(new ArrayList<>(path));
        for (int i = 0; i < nums.length; ++i) {
            if (path.contains(nums[i])) continue;
            path.add(nums[i]);
            backtrack(res, path, nums);
            path.remove(path.size() - 1);
        }
    }
}
