class Solution {
public:
    bool isPowerOfTwo(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += (n & 1);
            n >>= 1;
        }
        return cnt == 1;
    }
};


class Solution {
public:
    bool isPowerOfTwo(int n) {
        if(n <= 0) return false;
        while(n > 1) {
            if(n%2 != 0) return false;
            n /= 2;
          }
          return n == 1;
      }
};
