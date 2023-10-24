class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> res;
        for(int i = 0; i < nums.size(); ++i) {
            int tmp = target - nums[i];
            for(int j = i + 1; j < nums.size(); ++j) {
                if(nums[j] == tmp) {
                    res.push_back(i);
                    res.push_back(j);
                    return res;
                }
            }
        }
        return res;
    }
};

class Solution {
public:
    // 29 / 29 test cases passed.
    // Status: Accepted
    // Runtime: 12 ms
    // Memory Usage: 10.4 MB
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> res;
        unordered_map<int, int> map;
        
        for (int i = 0; i < nums.size(); ++i) {
            if (map.find(target - nums[i]) != map.end()) {
                res.push_back(i);
                res.push_back(map[target - nums[i]]);
                break;
            }
            map[nums[i]] = i;
        } 
        
        return res;
    }
};

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> m;  

        for (int i = 0;  i < nums.size(); ++i) {
            if (m.count(target - nums[i])) {
                return {i, m[target - nums[i]]};
            }
            m[nums[i]] = i;
        }
        return {};
    }
};