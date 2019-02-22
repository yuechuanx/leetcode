class Solution:
    def longestCommonPrefix(self, strs: 'List[str]') -> 'str':
        # traverse strs, each time take 1 char to compare
        # res = ""
        # for c in str
        #     for str in strs:
        
        # check input is not null
        if not strs:
            return ""
        # sort by each char in str, then sort by length
        # In [5]: strs = ["flower","flow","flight"]
        # In [6]: strs.sort()
        # In [7]: strs
        # Out[7]: ['flight', 'flow', 'flower']
        # strs = ['flower', 'flow', flowers] then strs.sort()
        # In [18]: strs
        # Out[18]: ['flow', 'flower', 'flowers']
        strs.sort()
        first = strs[0]
        last = strs[-1]
        
        i = 0
        while i < len(first) and i < len(last) and first[i] == last[i]:
            i += 1
        return first[:i]
        
            