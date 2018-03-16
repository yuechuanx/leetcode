class Solution {
public:
    bool isPerfectSquare(int num) {
        long left = 1, right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2, t = mid * mid;
            if (t == num) return true;
            else if (t > num) right = mid - 1;
            else {
                left = mid + 1;
            }
        }
        return false;
    }
};
