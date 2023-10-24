/* 
Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
*/

class Solution {
    /**
     * Binary Search
     * @param nums
     * @param target
     * @return 
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        int mid;
        
        while (left <= right) {
            mid = left + (right-left) / 2;
            if (target == nums[mid]) return mid;
            if (target < nums[mid]) right = mid - 1;
            else left = mid + 1;
        }
        
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 9, 15};
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(nums, 8));
    }
}
