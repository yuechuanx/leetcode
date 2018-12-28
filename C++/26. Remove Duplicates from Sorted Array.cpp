// Runtime: 24 ms, faster than 59.15% of C++ online submissions for Remove Duplicates from Sorted Array.
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.size() <= 1) return nums.size();
        int pre = 0, curr = 0;
        while(cur < nums.size()) {
            if(nums[curr] == nums[pre]) ++curr;
            else nums[++pre] = nums[curr++];
        }
        return pre+1;
    }
};


// Runtime: 20 ms, faster than 73.83% of C++ online submissions for Remove Duplicates from Sorted Array.
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.empty()) return 0;
        
        int index = 0;
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[index] != nums[i])
                nums[++index] = nums[i];
        }
        
        return index + 1;
    }
};

// Runtime: 28 ms, faster than 53.78% of C++ online submissions for Remove Duplicates from Sorted Array.
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        
        return distance(nums.begin(), unique(nums.begin(), nums.end()));
    }
};

// Runtime: 28 ms, faster than 53.78% of C++ online submissions for Remove Duplicates from Sorted Array.
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        
        return distance(nums.begin(), removeDuplicates(nums.begin(), nums.end(), nums.begin()));
    }
    
    template<typename InIt, typename OutIt>
    OutIt removeDuplicates(InIt first, InIt last, OutIt output) {
        while (first != last) {
            *output++ = *first;
            first = upper_bound(first, last, *first);
        }
        
        return output;
    }
};
