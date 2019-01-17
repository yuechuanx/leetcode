class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backTrace(res, new ArrayList<Integer>(), n, k, 1);
        return res;
    }
    
    private void backTrace(List<List<Integer>> res, List<Integer> path, int n, int k, int start) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = start; i <= n; ++i) {
            path.add(i);
            backTrace(res, path, n, k - 1, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
