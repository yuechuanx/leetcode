// Forward declaration of guess API.
// @param num, your guess
// @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
int guess(int num);

class Solution {
public:
    int guessNumber(int n) {
        // if(guess(n) == 0) return n;
        int left = 1, right = n;
        while(left < right) {
            int mid = left + (right - left) / 2;
            int t = guess(mid);
            if(t == 0) return mid;
            else if(t == 1) left = mid;
            else right = mid;
        }
        return left;
    }
};
