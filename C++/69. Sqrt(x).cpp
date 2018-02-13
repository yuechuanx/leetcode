class Solution {
public:
    int mySqrt(int x) {
        long long left = 0, right = (x / 2) + 1;
        while(left <= right) {
            long long mid = (left + right) / 2;
            long long sq = mid * mid;
            if(sq == x) return mid;
            else if (sq < x) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }
};
