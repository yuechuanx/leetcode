class Solution {
public:
    bool checkPerfectNumber(int num) {
        if(num == 1) return false;
        int sum = 1;
        for(int i = 2; i * i <= num; ++i) {
            if(num % i == 0) sum += (i + num / i);
            if(i * i == num) sum += i;
            if(sum > num) return false;
        }
        return sum == num;
    }
};
