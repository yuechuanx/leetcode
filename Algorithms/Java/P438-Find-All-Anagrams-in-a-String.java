class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        // defensive
        if (s == null || s.length() == 0 || s.length() < p.length()) return res;    
        
        // build hash table to record p
        int[] hash = new int[256]; 
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        
        int left = 0, right = 0, cnt = p.length();
        while (right < s.length()) {
            if (hash[s.charAt(right)] >= 1) {
                hash[s.charAt(right)]--;
                right++;
                cnt--;
            }
            if (cnt == 0) res.add(left);
            if (right - left == p.length() && hash[s.charAt(left)] >= 0) {
                hash[s.charAt(left)]++;
                left++;
                cnt++;
            }
        }
        
        return res;
    }
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256]; //character hash
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++)]-- >= 1) count--; 
            
            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);
        
            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }
        
    }
    