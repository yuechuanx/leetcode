class Solution {
public:
    int getSum(int a, int b) {
        // 解决思路是使用 逻辑运算
        if(b == 0) return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return getSum(sum, carry);
    }
};

class Solution {
public:
    int getSum(int a, int b) {
        while (b) {
          int carry = (a & b) << 1;
          a = a ^ b;
          b = carry;
        }
        return a;
    }
};

class Solution {
public:
    int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
};
