class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.size() <= 1) return nums.size();
        int pre = 0, cur = 0;
        while(cur < nums.size()) {
            if(nums[cur] == nums[pre]) ++cur;
            else nums[++pre] = nums[cur++];
        }
        return pre+1;
    }
};
