class Solution {
public:
    string reverseString(string s) {
        int left = 0, right = s.size() - 1;
        while(left < right) {
            swap(s[left++], s[right--]);
        }
        return s;
    }
};
