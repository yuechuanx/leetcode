class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int res = INT_MIN, curSum = 0;

        for(int num : nums) {
            curSum = max(curSum + num, num);
            res = max(res, curSum);
        }

        return res;
    }
};
