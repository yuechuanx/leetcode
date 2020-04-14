class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        backtrack(res, "", 0, 0, n);
        return res;
    }
    
    private void backtrack(List<String> res, String curr, int open, int close, int max) {
        // condition return
        if (curr.length() == max * 2) {
            res.add(curr);
            return;
        }
        
        if (open < max) {
            backtrack(res, curr + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(res, curr + ")", open, close + 1, max);
        }
    }
}

