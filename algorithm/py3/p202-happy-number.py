#
# @lc app=leetcode id=202 lang=python3
#
# [202] Happy Number
#
# https://leetcode.com/problems/happy-number/description/
#
# algorithms
# Easy (45.32%)
# Likes:    1314
# Dislikes: 314
# Total Accepted:    311K
# Total Submissions: 647K
# Testcase Example:  '19'
#
# Write an algorithm to determine if a number is "happy".
#
# A happy number is a number defined by the following process: Starting with
# any positive integer, replace the number by the sum of the squares of its
# digits, and repeat the process until the number equals 1 (where it will
# stay), or it loops endlessly in a cycle which does not include 1. Those
# numbers for which this process ends in 1 are happy numbers.
#
# Example: 
#
#
# Input: 19
# Output: true
# Explanation:
# 1^2 + 9^2 = 82
# 8^2 + 2^2 = 68
# 6^2 + 8^2 = 100
# 1^2 + 0^2 + 0^2 = 1
#
#

# @lc code=start


class Solution:
    def isHappy(self, n: int) -> bool:
        n_set = set([n])
        while n is not 1:
            square_sum = self.squareSum(n)
            if square_sum not in n_set:
                n_set.add(square_sum)
                n = square_sum
            else:
                return False

        return True

    def squareSum(self, n: int) -> int:
        res = 0
        for digit in str(n):
            res += int(digit) ** 2

        return res


class Solution2:
    pass
# @lc code=end
