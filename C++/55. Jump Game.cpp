class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        if (n <= 1) return true;
        int res = 0;
        for (int i = 0; i < n-1; ++i) {
            res = max(i + nums[i], res);
            if (res >= n-1) return true;
            if (res == i && nums[i] == 0) return false;
        }

        return false;
    }
};
