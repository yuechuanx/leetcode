class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // check null condition
        if (strs.length == 0) return new ArrayList();
        // in this use 多态
        Map<String, List> res = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray(); // ca means CharArray
            Arrays.sort(ca); 
            String key = String.valueOf(ca); // ?? what is valueOf?
            // if conatins then add, if not, then new a list
            if (!res.containsKey(key)) res.put(key, new ArrayList());
            res.get(key).add(s);
        }
        
        return new ArrayList(res.values());
    }
}