class Solution {
public:
    string convertToBase7(int num) {
        if(num == 0) return "0";
        bool flag = 0;
        if(num < 0) {
            flag = 1;
            num = abs(num);
        }
        string res = "";
        while(num > 0) {
            int tmp = num % 7;
            num /= 7;
            res = to_string(tmp) + res;
        }
        if(flag)
            return "-" + res;
        else
            return res;
    }
};
