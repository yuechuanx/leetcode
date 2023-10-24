class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        m = {}
        for word in strs:
            key = "".join(sorted(word))
            if key not in m:
                m[key] = [word]
            else:
                m[key].append(word)
        return list(m.values())