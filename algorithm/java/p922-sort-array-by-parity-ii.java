/*
 * @lc app=leetcode id=922 lang=java
 *
 * [922] Sort Array By Parity II
 *
 * https://leetcode.com/problems/sort-array-by-parity-ii/description/
 *
 * algorithms
 * Easy (66.70%)
 * Total Accepted:    30.7K
 * Total Submissions: 46K
 * Testcase Example:  '[4,2,5,7]'
 *
 * Given an array A of non-negative integers, half of the integers in A are
 * odd, and half of the integers are even.
 * 
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is
 * even, i is even.
 * 
 * You may return any answer array that satisfies this condition.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been
 * accepted.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int oddIdx = 1, evenIdx = 0;
        int[] res = new int[n];

        int i = 0;
        while (i < n) {
            if (A[i] % 2 == 0) {
                res[evenIdx] = A[i];
                evenIdx += 2;
            } else {
                res[oddIdx] = A[i];
                oddIdx += 2;
            }
            i++;
        }

        return res;
    } 
}

