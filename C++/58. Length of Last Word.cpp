class Solution {
public:
    int lengthOfLastWord(string s) {
        if(s.empty()) return 0;
        int right = s.size()-1;
        int res = 0;
        // 去掉尾部的空格
        while(right > 0 && s[right] == ' ') right--;
        while(right >= 0 && s[right] != ' ') {
            --right;
            res++;
        }
        return res;
    }

};
