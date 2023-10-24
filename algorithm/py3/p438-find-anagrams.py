class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        def isAnagrams(s1, s2):
            return "".join(sorted(s1)) == "".join(sorted(s2))

        slen, plen = len(s), len(p)

        if slen < plen:
            return []

        ans = []
        i = 0
        while i <= slen-plen:
            if isAnagrams(s[i:i+plen], p):
                ans.append(i)
            i += 1
        return ans