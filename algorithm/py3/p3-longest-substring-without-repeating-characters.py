class Solution:
    def lengthOfLongestSubstring(self, s: 'str') -> 'int':
        last_seen = {} # map<K, V> := <char, index>
        start = 0
        longest = 0

        for i, c in enumerate(s):
            if c in last_seen and last_seen[c] >= start:
                start = last_seen[c] + 1
            else:
                longest = max(longest, i - start + 1)
            last_seen[c] = i

        return longest

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0

        left = 0
        lookup = set()
        maxlen = 0
        curlen = 0
        for i in range(len(s)):
            curlen += 1
            while s[i] in lookup:
                lookup.remove(s[left])
                left += 1
                curlen -= 1
            maxlen = max(maxlen, curlen)
            lookup.add(s[i])
        return maxlen