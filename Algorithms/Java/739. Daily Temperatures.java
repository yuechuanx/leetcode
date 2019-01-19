class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; ++i) {
            for (int j = i + 1; j < T.length; ++j) {
                if (T[j] > T[i]) {
                    res[i] = j - i;   
                    break;
                }
            }
        }
        
        return res;
    }
}