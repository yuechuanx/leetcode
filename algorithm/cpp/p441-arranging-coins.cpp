class Solution {
public:
    int arrangeCoins(int n) {
        if(n == 1 || n == 0) return n;
        int res = 1;
        while(n > 0) {
            n -= res;
            if(n <= 0) break;
            res++;
        }
        if(n == 0) return res;
        if(n < 0) return --res;
    }
};
