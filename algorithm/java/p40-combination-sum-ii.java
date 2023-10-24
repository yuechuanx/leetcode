class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int level) {
        if (target == 0) 
            res.add(new ArrayList<Integer>(path));
        for (int i = level; i < candidates.length && target - candidates[i] >= 0; ++i) {
            if (i > level && candidates[i] == candidates[i-1]) continue;
            path.add(candidates[i]);
            backtrack(res, path, candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
    }
}