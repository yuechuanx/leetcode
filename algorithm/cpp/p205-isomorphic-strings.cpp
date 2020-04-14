class Solution {
public:
    bool isIsomorphic(string s, string t) {
        int map1[256] = {0}, map2[256] = {0}, n = s.size();
        for(int i = 0; i < n; ++i) {
            // 这里存入的字符其实是Unicode的数值，由于if语句在前，所以只需要初始化第一个值
            if(map1[s[i]] != map2[t[i]]) return false;
            map1[s[i]] = i + 1;
            map2[t[i]] = i + 1;
        }
        return true;
    }
};
