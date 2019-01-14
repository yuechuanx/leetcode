class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (int key : map.keySet()) {
            int cnt = map.get(key);
            if (bucket[cnt] == null) {
                bucket[cnt] = new ArrayList<>();
            }
            bucket[cnt].add(key);
        }
        
        List<Integer> res = new ArrayList<>();
        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        
        return res;
    }
}