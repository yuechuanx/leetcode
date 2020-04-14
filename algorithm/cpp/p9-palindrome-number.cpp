class Solution {
public:
    bool isPalindrome(int x) {
      if(x < 0) {
        return false;
      }
      
      /* 取出最高位数 */
      int div = 1;
      while(x / div >= 10) div *= 10;
      
      while(x > 0) {
        int left = x / div;
        int right = x % 10;
        if(left != right) {
          return false;
        }
        x = (x % div) / 10;
        div /= 100; // 一次取出两个数字
      }
      return true;
    }
};
