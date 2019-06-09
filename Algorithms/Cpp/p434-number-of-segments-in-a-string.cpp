class Solution {
public:
    int countSegments(string s) {
        int res = 0, n = s.size();
        for(int i = 0; i < n; ++i) {
            if(s[i] == ' ') continue;
            res++;
            while(i < n && s[i] != ' ') i++;
        }
        return res;
    }
};
