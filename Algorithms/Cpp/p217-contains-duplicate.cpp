class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_map<int, int> m;
        for (int i = 0; i < nums.size(); ++i) {
            if(m.find(nums[i]) != m.end()) return true;
            ++m[nums[i]];
        }
        return false;

    }
};

class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        for(int i = 1; i < nums.size(); ++i){
            if(nums[i] == nums[i-1]) return true; // nums[i] == nums[i+1] 的情况下，进入循环后可能出现下标访问溢出
        }
        return false;
    }
};
