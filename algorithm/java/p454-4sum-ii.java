// time complexity : O(n^2)
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int key = A[i] + B[j];
                int value = map.getOrDefault(key, 0) + 1;
                map.put(key, value);
            }
        }
        
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int key = C[i] + D[j];
                res += map.getOrDefault(-1 * key, 0);
            }
        }
        
        return res;
    }
    
}