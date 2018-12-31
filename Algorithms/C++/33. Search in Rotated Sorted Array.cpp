// Runtime: 8 ms, faster than 31.30% of C++ online submissions for Search in Rotated Sorted Array.
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int start = 0, end = nums.size();
        
        while (start != end) {  // 下标可能在左右侧进行跳转，所以不能用<>进行判断
            const int mid = start + (end-start) / 2; // 为啥这里用const？
            if (nums[mid] == target) {  // 最简单的一种情况
                return mid;
            } 
            if (nums[start] <= nums[mid]) { // 从start到mid处于有序状态，考虑了重复的元素？
                if (nums[start] <= target && target < nums[mid]) // 如果target在此之间
                    end = mid;
                else 
                    start = mid + 1;
            } else {    // 从mid到end处于有序状态
                if (nums[mid] < target && target <= nums[end - 1])
                    start = mid + 1;
                else 
                    end = mid;
            }
        }
        
        return -1;
    }
};