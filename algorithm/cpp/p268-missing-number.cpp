class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int sum = 0, n = nums.size();
        for(auto &i : nums)
            sum += i;
        return 0.5 * n * (n + 1) - sum;
    }
};
