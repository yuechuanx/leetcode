// Runtime: 16 ms, faster than 45.75% of C++ online submissions for Remove Duplicates from Sorted Array II.
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() <= 2) return nums.size();
        
        int index = 2;
        for (int curr = 2; curr < nums.size(); ++curr) {
            if (nums[curr] != nums[index - 2]) 
                // 首先判断当前位置，再index++
                nums[index++] = nums[curr];
        }
        
        return index; // 这里的index是处理后的nums的最后一个idx+1
    }
};


// Runtime: 12 ms, faster than 72.84% of C++ online submissions for Remove Duplicates from Sorted Array II.
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.empty()) return 0;
        
        int pre = nums[0] - 1, next = 0, count = 0;
        
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] == pre) { // 后一位与前一位相等，计数+1
                count++;
            } else {    
                pre = nums[i];
                count = 1;
            }
            if (count <= 2) nums[next++] = nums[i];
        }
        
        return next;
    }
};