// backtrack. Time
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int level) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(path));
        }
        for (int i = level; i < candidates.length && target - candidates[i] >= 0; ++i) {
                path.add(candidates[i]);
                backtrack(res, path, candidates, target - candidates[i], i);
                path.remove(path.size() - 1);
        }
    }
}
