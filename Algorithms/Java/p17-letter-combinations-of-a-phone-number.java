class Solution {

    // build a map 
    public static final String[] MAPS = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0 || digits == null) return res;
        backtrack(res, "", digits, 0);
        return res;
    }
    
    private void backtrack(List<String> res, String path, String digits, int start) {
        if (path.length() == digits.length()) {
            res.add(path);
            return;
        }
        String map = MAPS[digits.charAt(start) - '0'];
        for (int i = 0; i < map.length(); ++i) {
            backtrack(res, path + map.charAt(i), digits, start + 1);
        }
    }
}