class Solution {
public:
    vector<int> selfDividingNumbers(int left, int right) {
        vector<int> res;
        for(int i = left; i <= right; ++i){
            if(isSDN(i)){
                res.push_back(i);
            }
        }
        return res;
    }

    bool isSDN(int n){
        if(n < 10) return true;
        int p = n;
        while(p > 0) {
            int tmp = p % 10;
            if(tmp == 0) return false;
            if(n % tmp != 0) return false;
            p /= 10;
        }
        return true;
    }
};
