class Solution {
public:
    int titleToNumber(string s) {
        int n = s.size();
        int res = 0;
        int base = 1;
        for(int i =n  - 1; i >= 0; --i) {
            res += (s[i] - 'A' + 1) * base;
            base *= 26;
        }
        return res;
    }
};
