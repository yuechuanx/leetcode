
// first the x is 32-bit integer
// change x to char
// pick the '+' '-' sign
// use anothoer array to put the number
// chane the number array to number, remove head zero

/*
Solution 1:
首先将x转为正数处理
根据循环取模，得到尾数
将尾数以10为基数进行加乘
得到结果
*/
class Solution {
public:
    int reverse(int x) {
      long long res = 0;
      bool isPositive = true;
      // 将其转为正整数处理
      if(x < 0) {
        isPositive = false;
        x *= -1;
      }
      while (x > 0) {
        res = res * 10 + x % 10;
        x /= 10;
      }
      if(res > INT_MAX) return 0;
      if(isPositive) return res;
      else return -res;
    }
};

/*
Solution 2：

*/
class Solution {
public:
  int reverse(int x) {
    int res = 0;
    while (x != 0) {
      if(abs(res) > INT_MAX / 10) return 0; // 不可以更改为退出循环后判断res是否溢出，因为res为int类型
      res = res * 10 + x % 10;
      x /= 10;
    }
    return res;
  }
};

class Solution {
public:
  int reverse(int x) {
    long long res = 0;
    while (x != 0) {
      res = res * 10 + x % 10;
      x /= 10;
    }
    return (res > INT_MAX || res < -INT_MAX) ? 0 : res;
  }
};

class Solution {
public:
    int reverse(int x) {
      int res = 0;
      while (x != 0) {
        int t = res * 10 + x % 10;
        if(t / 10 != res) return 0; // 利用t发生溢出情况
        res = t;
        x /= 10;
      }
      return res;
    }
};
