class Solution {
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < A.length; ++i) {
            if (map.containsKey(A[i]))
                return A[i];
            map.put(A[i], i);
        }
        
        return 0;
    }
}